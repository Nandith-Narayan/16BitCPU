import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.AssemblyParser;
import parser.AssemblyVisitor;
import statements.Label;
import statements.Statement;

import java.util.ArrayList;

public class Visitor implements AssemblyVisitor<DataWrapper> {

    ArrayList<Statement> statements;

    public Visitor(){
        statements = new ArrayList<Statement>();
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
        Logger.log("Visiting Statement: \""+ctx.getText()+"\"");

        if(ctx.label() != null){
            visitLabel(ctx.label());
        }
        return null;
    }

    @Override
    public DataWrapper visitSimple_instruction(AssemblyParser.Simple_instructionContext ctx) {
        return null;
    }

    @Override
    public DataWrapper visitCompound_instruction(AssemblyParser.Compound_instructionContext ctx) {
        return null;
    }

    @Override
    public DataWrapper visitLabel(AssemblyParser.LabelContext ctx) {
        String labelName = ctx.IDENTIFIER().getText();

        Logger.log("Encountered new Label: \""+labelName+"\"");

        statements.add(new Label(labelName));
        return null;
    }

    @Override
    public DataWrapper visitLiteral(AssemblyParser.LiteralContext ctx) {
        return null;
    }

    @Override
    public DataWrapper visitConstant(AssemblyParser.ConstantContext ctx) {
        return null;
    }

    @Override
    public DataWrapper visitVariable(AssemblyParser.VariableContext ctx) {
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
