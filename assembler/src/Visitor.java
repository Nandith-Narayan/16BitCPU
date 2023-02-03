import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.AssemblyParser;
import parser.AssemblyVisitor;
import statements.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Visitor implements AssemblyVisitor<DataWrapper> {

    ArrayList<Statement> statements;
    HashMap<String, Integer> constMap;
    HashMap<String, Boolean> varMap;

    public Visitor(){
        statements = new ArrayList<Statement>();
        constMap = new HashMap<String, Integer>();
        varMap = new HashMap<String, Boolean>();
    }

    public ArrayList<Statement> getStatements(){
        return this.statements;
    }
    @Override
    public DataWrapper visitProgram(AssemblyParser.ProgramContext ctx) {
        for(AssemblyParser.StatementContext stmt : ctx.statement()){
            visitStatement(stmt);
        }

        return null;
    }

    @Override
    public DataWrapper visitStatement(AssemblyParser.StatementContext ctx) {
        Logger.log("Visiting Statement: \""+ctx.getText()+"\"", 0);

        if(ctx.label() != null){
            return visitLabel(ctx.label());
        }
        if(ctx.variable() != null){
            return visitVariable(ctx.variable());
        }
        if(ctx.constant() != null){
            return visitConstant(ctx.constant());
        }
        if(ctx.simple_instruction() != null){
            return visitSimple_instruction(ctx.simple_instruction());
        }
        if(ctx.compound_instruction() != null){
            return visitCompound_instruction(ctx.compound_instruction());
        }


        return null;
    }

    @Override
    public DataWrapper visitSimple_instruction(AssemblyParser.Simple_instructionContext ctx) {
        String opcode = ctx.OPCODE_SIMPLE().getText();

        Logger.log("Encountered "+opcode, 1);

        statements.add(new Instruction(opcode));

        return null;
    }

    @Override
    public DataWrapper visitCompound_instruction(AssemblyParser.Compound_instructionContext ctx) {
        String opcode = ctx.OPCODE_COMPOUND().getText();

        Logger.log("Encountered "+opcode, 1);

        if(ctx.literal() != null){
            int literal = visitLiteral(ctx.literal()).integer;
            statements.add(new CompoundLiteralInstruction(opcode, literal));
        }else if(ctx.IDENTIFIER() != null){
            String id = ctx.IDENTIFIER().getText();
            if(ctx.DOLLAR_SIGN() == null) {

                Logger.log("Encountered Constant: \"" + id + "\"", 2);

                statements.add(new CompoundConstantInstruction(opcode, id));
            }else{

                Logger.log("Encountered Variable: \"" + id + "\"", 2);

                statements.add(new CompoundVariableInstruction(opcode, id));
            }
        }


        return null;
    }

    @Override
    public DataWrapper visitLabel(AssemblyParser.LabelContext ctx) {
        String labelName = ctx.IDENTIFIER().getText();

        Logger.log("Encountered new Label: \""+labelName+"\"", 1);

        statements.add(new Label(labelName));
        return null;
    }

    @Override
    public DataWrapper visitLiteral(AssemblyParser.LiteralContext ctx) {
        if(ctx.DECIMAL_LITERAL() != null){
            String txt = ctx.DECIMAL_LITERAL().getText().replace("0d","");
            Logger.log("Encountered Decimal Literal: "+txt+"", 2);
            return new DataWrapper(Integer.parseInt(txt));
        }
        if(ctx.HEX_LITERAL() != null){
            String txt = ctx.HEX_LITERAL().getText().replace("0x","");
            Logger.log("Encountered Hex Literal: 0x"+txt+"", 2);
            return new DataWrapper(Integer.parseInt(txt, 16));
        }
        if(ctx.BINARY_LITERAL() != null) {
            String txt = ctx.BINARY_LITERAL().getText().replace("0b", "");
            Logger.log("Encountered Binary Literal: 0b"+txt+"", 2);
            return new DataWrapper(Integer.parseInt(txt, 2));
        }

        String txt = ctx.DECIMAL_LITERAL().getText().replace("0d","");
        Logger.log("UNKNOWN Literal type, defaulting to Decimal: "+txt, 2);
        return new DataWrapper(Integer.parseInt(txt));
    }

    @Override
    public DataWrapper visitConstant(AssemblyParser.ConstantContext ctx) {
        String constName = ctx.IDENTIFIER().getText();
        if(!constMap.containsKey(constName)){

            Logger.log("Encountered new Constant: \""+constName+"\"", 1);

            int literal = visitLiteral(ctx.literal()).integer;
            constMap.put(constName, literal);
        }else{
            Logger.err("Encountered Duplicate Constant: \""+constName+"\"", 1);
        }

        return null;
    }

    @Override
    public DataWrapper visitVariable(AssemblyParser.VariableContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
        if(!varMap.containsKey(varName)){

            Logger.log("Encountered new Variable: \""+varName+"\"", 1);

            varMap.put(varName, true);
        }else{
            Logger.err("Encountered Duplicate Variable: \""+varName+"\"", 1);
        }

        return null;
    }

    @Override
    public DataWrapper visit(ParseTree parseTree) {
        return null;
    }

    @Override
    public DataWrapper visitChildren(RuleNode ruleNode) {
        return null;
    }

    @Override
    public DataWrapper visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    @Override
    public DataWrapper visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}
