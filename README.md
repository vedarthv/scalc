S-expression calculator
=======================

## Usage
Please download the `scalc.jar` file to run the code. 
Then use the following command to use the program: `java -jar ./scalc.jar <arg>`.

## Technologies Used
For this project I used Java and [ANTLR4](https://www.antlr.org/about.html). ANTLR is used to specify a grammer, which is then used to generate a Java interface which can be used to parse some given text. ANTLR is very powerful as it has extensive tooling such as the ability to generate parse trees. Normally a grammer is defined in a `*.g4` file and then it is complied using the ANTLR library. The generated classes can vary depending on your choice of having `visitor` and or `listener` classes. 

Typically, after the Java files are generated, ANTLR defines an interface for the respective `visitor` and `listener` classes and a base implementation which can be extended to do meaningful computation and evaluation of the grammer. 

## File Index / Important Files
- ANTLR Grammer File: [`Calc.g4`](https://github.com/vedarthv/scalc/blob/42d3b257b2cc64839a3e63807823886a1369a89e/src/main/java/com/antlr/Calc.g4)
- [ANTLR Generated Java Files](https://github.com/vedarthv/scalc/tree/master/src/main/java/com/antlr)
- Implementation of the Visitor class [`CalcVisitor.java`](https://github.com/vedarthv/scalc/blob/42d3b257b2cc64839a3e63807823886a1369a89e/src/main/java/com/calc/CalcVisitor.java)
- Instantiating the program [`Calc.java`](https://github.com/vedarthv/scalc/blob/42d3b257b2cc64839a3e63807823886a1369a89e/src/main/java/com/calc/Calc.java)
