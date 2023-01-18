package com.calc;

import java.util.*;

import com.antlr.CalcBaseVisitor;
import com.antlr.CalcParser;
import org.antlr.v4.runtime.tree.ParseTree;

public class CalcVisitor extends CalcBaseVisitor<Integer> {

    private Integer Operation(List<ParseTree> expression){
        int result = -1; // initializing result to dummy value
        String OP = expression.get(1).getText();
        // We start at i=3 to ignore the left bracket, op, delim tokens in a (non-int) expression context.
        for (int i = 3; i < expression.size(); i++) {
            if (expression.get(i).getChildCount() >= 1){
                // Here the i'th child (i >= 3), the object must be an int since a non int expression has > 1 children.
                if (result == -1){
                    // We re-initialize the result to its proper value
                    result = visit(expression.get(i));
                }
                else {
                    switch (OP) {
                        case "exponent":
                            result = (int) Math.pow(result, visit(expression.get(i)));
                            break;
                        case  "multiply":
                            result *= visit(expression.get(i));
                            break;
                        case "add":
                            result += visit(expression.get(i));
                            break;
                        default:
                            throw new RuntimeException("Invalid OP");
                    }
                }
            }
        }
        return result;
    }

    @Override public Integer visitProgram(CalcParser.ProgramContext ctx) {
        int value = visit(ctx); // evaluate the expr child
        return value;
    }

    @Override public Integer visitExponent(CalcParser.ExponentContext ctx) {
        return Operation(ctx.children);
    }


    @Override public Integer visitMultiply(CalcParser.MultiplyContext ctx) {
        return Operation(ctx.children);
    }

    @Override public Integer visitAdd(CalcParser.AddContext ctx) {
        return Operation(ctx.children);
    }

    @Override public Integer visitInteger(CalcParser.IntegerContext ctx) { return Integer.valueOf(ctx.INT().getText()); }
}
