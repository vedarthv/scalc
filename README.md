S-expression calculator
=======================

## Getting Started
Please download the [`scalc.jar`](https://github.com/vedarthv/scalc/blob/9888e74db8abfcc312ad850ad7182bd535f18922/scalc.jar) file to run the code. 
Then use the following command to use the program: `java -jar ./scalc.jar <arg>`. Please use `JDK 8` or more recent versions of Java.

## Usage

The general syntax of an expression is `(OP EXPR EXPR)`, where `OP` = {`add`, `multiply`, `exponent`} and `EXPR` ={ $\mathbb{N}$, `(OP EXPR EXPR)`}.

### Example 
`java -jar ./scalc.jar (add 1 (multiply 2 0))`
>`1`


## Technologies Used
For this project I used Java and [ANTLR4](https://www.antlr.org/about.html). ANTLR is used to specify a grammer, which is then used to generate a Java interface which can be used to parse some given text. ANTLR is very powerful as it has extensive tooling such as the ability to generate parse trees. Here is a generated parse tree of the expression `(add 1 (multiply 5 (exponent 3 5)) 5 (multiply 4 2) 5)` using the grammer from [`Calc.g4`](https://github.com/vedarthv/scalc/blob/42d3b257b2cc64839a3e63807823886a1369a89e/src/main/java/com/antlr/Calc.g4):

![parseTree](https://user-images.githubusercontent.com/87582836/213109614-8b36f292-c594-4b5b-8182-e558ac38584c.png)
Normally a grammer is defined in a `*.g4` file and then it is complied using the ANTLR library. The generated classes can vary depending on your choice of having `visitor` and or `listener` classes. 

ANTLR defines an interface for the respective `visitor` and/or `listener` Java classes and a base implementation which can be extended to do meaningful computation and evaluation of an expression following the specified grammer.

## File Index / Important Files
- ANTLR Grammer File: [`Calc.g4`](https://github.com/vedarthv/scalc/blob/42d3b257b2cc64839a3e63807823886a1369a89e/src/main/java/com/antlr/Calc.g4)
- [ANTLR Generated Java Files](https://github.com/vedarthv/scalc/tree/master/src/main/java/com/antlr)
- Implementation of the Visitor class [`CalcVisitor.java`](https://github.com/vedarthv/scalc/blob/42d3b257b2cc64839a3e63807823886a1369a89e/src/main/java/com/calc/CalcVisitor.java)
- Instantiating the program [`Calc.java`](https://github.com/vedarthv/scalc/blob/42d3b257b2cc64839a3e63807823886a1369a89e/src/main/java/com/calc/Calc.java)
- Jar file of the program [`scalc.jar`](https://github.com/vedarthv/scalc/blob/9888e74db8abfcc312ad850ad7182bd535f18922/scalc.jar)
