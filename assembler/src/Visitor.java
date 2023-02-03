import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.AssemblyParser;
import parser.AssemblyVisitor;

import javax.xml.crypto.Data;

public class Visitor implements AssemblyVisitor<DataWrapper> {
    @Override
    public DataWrapper visitProgram(AssemblyParser.ProgramContext ctx) {
        return null;
    }

    @Override
    public DataWrapper visitStatement(AssemblyParser.StatementContext ctx) {
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
        return null;
    }

    @Override
    public DataWrapper visitLiteral(AssemblyParser.LiteralContext ctx) {
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
