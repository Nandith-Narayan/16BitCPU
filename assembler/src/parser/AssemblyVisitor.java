// Generated from java-escape by ANTLR 4.11.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AssemblyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AssemblyVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AssemblyParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(AssemblyParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link AssemblyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(AssemblyParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AssemblyParser#simple_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_instruction(AssemblyParser.Simple_instructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AssemblyParser#compound_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_instruction(AssemblyParser.Compound_instructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AssemblyParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(AssemblyParser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link AssemblyParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(AssemblyParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link AssemblyParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(AssemblyParser.VariableContext ctx);
}