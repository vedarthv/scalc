package com.calc;
import com.antlr.CalcLexer;
import com.antlr.CalcParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.tree.*;

import java.util.Arrays;

public class Calc {

    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from standard input
        CharStream charStream = CharStreams.fromString(args[0]);
        CalcLexer lexer = new CalcLexer(charStream); // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer); // create a parser that feeds off the tokens buffer
        CalcParser parser = new CalcParser(tokens);
        ParseTreeVisitor visitor = new CalcVisitor();  // We will use our extended baseVisitor class to perform operations
        int result = (int) visitor.visit(parser.expr()); // Our Visitor class is passed a parse tree, the visitor class then performs the appropriate ops
        System.out.println(result);
    }


}
