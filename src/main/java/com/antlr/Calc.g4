// grammar
grammar Calc;


@header {
    package com.antlr; 
    import java.util.*; 
}


prog: (expr)+ EOF # Program
;

expr: '(' 'exponent' DELIM expr DELIM expr ')'  # Exponent
    | '(' 'multiply' DELIM expr DELIM expr ')'  # Multiply
    | '(' 'add' DELIM expr DELIM expr ')'       # Add
    | INT                                       # Integer
;

// Tokens
INT: '0'?[1-9][0-9]*;
DELIM: ' ';
WS: [\t\n]+ -> skip; // Don't consider white space from tab and new line chars.


