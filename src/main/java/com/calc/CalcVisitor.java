package com.calc;

import java.util.*;

import com.antlr.CalcBaseVisitor;
import com.antlr.CalcParser;

public class CalcVisitor extends CalcBaseVisitor<Integer> {

    @Override public Integer visitProgram(CalcParser.ProgramContext ctx) {
        int value = visit(ctx); // evaluate the expr child
        //System.out.println(value); // print the result
        return value;
    }

    @Override public Integer visitExpression(CalcParser.ExpressionContext ctx) {
        Integer value = visit(ctx); // evaluate the expr child
        System.out.println(value); // print the result
        return 0;
    }

    @Override public Integer visitExponent(CalcParser.ExponentContext ctx) {
        int result = -1; // initializing result to dummy value

        int startIndex = 3; // We start at i=3 to ignore the left bracket, op, delim tokes in a (non-int) expression context.
        for (int i = 3; i < ctx.getChildCount(); i++) {

            if (ctx.children.get(i).getChildCount() >= 1){
                // Here the i'th child (i >= 3), the object must be an int since a non int expression has > 1 children.
                if (result == -1){
                    // We re-initialize the result to its proper value
                    result = visit(ctx.getChild(i));
                }
                else {
                    result = (int) Math.pow(result, visit(ctx.getChild(i)));
                }
            }
        }
        return result;
    }


    @Override public Integer visitMultiply(CalcParser.MultiplyContext ctx) {
        int result = -1; // initializing result to dummy value

        int startIndex = 3; // We start at i=3 to ignore the left bracket, op, delim tokes in a (non-int) expression context.
        for (int i = 3; i < ctx.getChildCount(); i++) {

            if (ctx.children.get(i).getChildCount() >= 1){
                // Here the i'th child (i >= 3), the object must be an int since a non int expression has > 1 children.
                if (result == -1){
                    // We re-initialize the result to its proper value
                    result = visit(ctx.getChild(i));
                }
                else {
                    result *= visit(ctx.getChild(i));
                }
            }
        }
        return result;
    }

    @Override public Integer visitAdd(CalcParser.AddContext ctx) {
        int result = -1; // initializing result to dummy value

        int startIndex = 3; // We start at i=3 to ignore the left bracket, op, delim tokes in a (non-int) expression context.
        for (int i = 3; i < ctx.getChildCount(); i++) {

            if (ctx.children.get(i).getChildCount() >= 1){
                // Here the i'th child (i >= 3), the object must be an int since a non int expression has > 1 children.
                if (result == -1){
                    // We re-initialize the result to its proper value
                    result = visit(ctx.getChild(i));
                }
                else {
                    result += visit(ctx.getChild(i));
                }
            }
        }
        return result;
    }

    @Override public Integer visitInteger(CalcParser.IntegerContext ctx) { return Integer.valueOf(ctx.INT().getText()); }
}
