import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.AssemblyLexer;
import parser.AssemblyParser;
import parser.AssemblyVisitor;

import java.io.IOException;

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


        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
