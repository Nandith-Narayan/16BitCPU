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
            for(Statement stmt: statements){
                System.out.println(stmt);
            }


        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
