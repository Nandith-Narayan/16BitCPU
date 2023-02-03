// Generated from java-escape by ANTLR 4.11.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link assemblyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface assemblyVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link assemblyParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(assemblyParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link assemblyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(assemblyParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link assemblyParser#simple_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_instruction(assemblyParser.Simple_instructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link assemblyParser#compound_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_instruction(assemblyParser.Compound_instructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link assemblyParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(assemblyParser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link assemblyParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(assemblyParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link assemblyParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(assemblyParser.VariableContext ctx);
}