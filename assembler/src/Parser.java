import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.AssemblyLexer;
import parser.AssemblyParser;
import parser.AssemblyVisitor;
import statements.Statement;

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

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
