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
        //ANTLRInputStream input = new ANTLRInputStream(System.in); // create a lexer that feeds off of input CharStream
        CharStream charStream = CharStreams.fromString("(add 1 1 1 (multiply 2 6) (exponent 3 1))");
        CalcLexer lexer = new CalcLexer(charStream); // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer); // create a parser that feeds off the tokens buffer
        CalcParser parser = new CalcParser(tokens);
        ParseTreeVisitor visitor = new CalcVisitor();
        int result = (int) visitor.visit(parser.expr());

        System.out.println(result); // print LISP-style tree


    }


}
