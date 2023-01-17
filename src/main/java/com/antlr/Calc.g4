// grammar
grammar Calc;


@header {
    package com.antlr; 
    import java.util.*; 
}


prog: (expr)+ EOF # Program
;

expr: '(' op (DELIM expr)+ ')'  # Expression
    | INT                       # Integer
;

op:  'exponent' # Exponent
    |'multiply' # Multiply
    |'add'      # Add
;

// Tokens
INT: [0-9]+;
DELIM: ' ';
WS: [\t\n]+ -> skip; // Don't consider white space from tab and new line chars.


