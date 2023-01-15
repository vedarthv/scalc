// grammar
grammar Calc;

prog: (expr)+ EOF
;

expr: '(' OP DELIM expr DELIM expr ')' | INT
;

OP: 'exponent' | 'multiply' | 'add'
;

INT: '0'?[1-9][0-9]*;
DELIM: ' ';
WS: [\t\n]+ -> skip; // Don't consider white space from tab and new line chars.


