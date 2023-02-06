import data.Data;
import data.LabelPlaceholder;
import data.Opcode;
import data.RawData;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.AssemblyLexer;
import parser.AssemblyParser;
import parser.AssemblyVisitor;
import statements.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Parser {

    public Parser(String path){
        try {
            // Load assembly file
            CharStream cs = CharStreams.fromFileName(path);
            // Tokenize file
            AssemblyLexer lexer = new AssemblyLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            // create the Parse Tree
            AssemblyParser parser = new AssemblyParser(tokens);
            AssemblyParser.ProgramContext pc = parser.program();
            // Visit the nodes of the Parse Tree
            Visitor visitor = new Visitor();
            visitor.visitProgram(pc);
            // Get sequence of statements
            ArrayList<Statement> statements = visitor.getStatements();
            HashMap<String, Integer> constMap = visitor.getConstMap();
            HashMap<String, Boolean> varMap = visitor.getVarMap();
            System.out.println("***********************************");
            System.out.println("Flattened Statements:");
            System.out.println("***********************************");
            for(int i=0;i<statements.size();i++){
                Statement stmt = statements.get(i);
                System.out.printf("0x%04x : ", i);
                System.out.println(stmt);
            }

            // Check for duplicate names
            List<String> constNames = constMap.keySet().stream().toList();
            List<String> varNames = varMap.keySet().stream().toList();
            for(String c : constNames){
                if(varNames.contains(c)){
                    System.err.println("Constant and Variable has the same name! \""+c+"\"");
                    System.exit(0);
                }
            }

            // Apply Constants:
            for(Statement stmt : statements){
                for(String name: constNames) {
                    stmt.applyConstant(name, constMap.get(name));
                }
            }

            ArrayList<Data> IR = new ArrayList<Data>();
            HashMap<String, Integer> variableMap = new HashMap<String, Integer>();
            HashMap<String, Integer> labelMap = new HashMap<String, Integer>();
            ArrayList<String> labels = visitor.getLabels();
            // Add jump to entry point:
            IR.add(new Opcode("JMP"));
            IR.add(new LabelPlaceholder("main"));
            int address = IR.size();

            // Allocate space for variables
            for(String varName : varNames){
                IR.add(new RawData(0));
                variableMap.put(varName, address);
                address++;
            }

            // Convert Statement list to Intermediate Representation
            for(Statement stmt : statements){
                if(stmt instanceof Instruction){
                    Instruction inst = (Instruction) stmt;
                    IR.add(new Opcode(inst.opcode));
                    if(inst instanceof CompoundConstantInstruction){
                        CompoundConstantInstruction compInst = (CompoundConstantInstruction) inst;
                        if(!compInst.hasValue){
                            System.err.println("UNKNOWN Constant: \""+compInst.constantName+"\"");
                            System.exit(0);
                        }
                        IR.add(new RawData(compInst.constantValue));
                        address++;
                    }else if(inst instanceof CompoundLiteralInstruction){
                        IR.add(new RawData(((CompoundLiteralInstruction) inst).literal));
                        address++;
                    }else if(inst instanceof CompoundVariableInstruction){
                        String name = ((CompoundVariableInstruction) inst).variableName;
                        if(variableMap.containsKey(name)){
                            IR.add(new RawData(variableMap.get(name)));
                        }else if(labels.contains(name)){
                            IR.add(new LabelPlaceholder(name));
                        }else{
                            System.err.println("UNKNOWN Variable/Label: \""+name+"\"");
                            System.exit(0);
                        }
                        address++;
                    }
                    address++;
                }else if(stmt instanceof Label){
                    labelMap.put(((Label) stmt).name, address);
                }
            }

            System.out.println("***********************************");
            System.out.println("Intermediate Representation:");
            System.out.println("***********************************");
            for(Data d : IR){
                System.out.println(d);
            }

            System.out.println("***********************************");
            System.out.println("Machine Code:");
            System.out.println("***********************************");
            byte[] data = new byte[IR.size()*2];
            for(int i=0;i<IR.size();i++){
                System.out.printf("0x%04x : ", i);
                int a = IR.get(i).emit(labelMap);
                System.out.printf("0x%04x\n", a);
                data[i*2] = (byte)((a >> 8) & 0x0FF);
                data[(i*2)+1] = (byte)(a & 0x0FF);
            }
            FileOutputStream fis = new FileOutputStream(path.replace(".asm", ".bin"));
            fis.write(data, 0, data.length);
            fis.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
