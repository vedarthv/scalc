// Generated from java-escape by ANTLR 4.11.1

    package com.antlr; 
    import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalcVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link CalcParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CalcParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Expression}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CalcParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(CalcParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Exponent}
	 * labeled alternative in {@link CalcParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExponent(CalcParser.ExponentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link CalcParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiply(CalcParser.MultiplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link CalcParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(CalcParser.AddContext ctx);
}