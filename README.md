S-expression calculator
=======================

Write a command line program that acts as a simple calculator: it takes a
single argument as an expression and prints out the integer result of
evaluating it.

Assuming the program is implemented in Python, invocations should look like:

    $ ./calc.py 123
    123

    $ ./calc.py "(add 12 12)"
    24

You're free to use whatever programming language you like, the invocation above
is just an example. The general point of taking an argument and printing out
its evaluation is the only contract to abide by.

Expression syntax
-----------------

Since the expression is passed in as a command line argument, it is a string.
The syntax resembles [S-expressions][sexp] but the rules are simplified. An
expression can be in one of two forms:

### Integers

An integer is just a sequence of base 10 digits. For example:

    123

### Function calls

A function call takes the following form:

    (FUNCTION EXPR EXPR)

A function call is always delimited by parenthesis `(` and `)`.

The `FUNCTION` is one of `add` or `multiply`.

The `EXPR` can be any arbitrary expression, i.e. it can be further function
calls or integer expressions.

Exactly one space is used to separate each term.

For example:

    (add 123 456)

    (multiply (add 1 2) 3)

Expression grammar
------------------

A formal grammar specified in [EBNF][ebnf]:

    DIGIT = "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9";

    EXPR = INTEGER | ADD | MULTIPLY;

    INTEGER = DIGIT, { DIGIT };

    ADD = "(", "a", "d", "d", " ", EXPR, " ", EXPR, ")";

    MULTIPLY = "(", "m", "u", "l", "t", "i", "p", "l", "y", " ", EXPR, " ", EXPR, ")";

Expression semantics
--------------------

The goal is to write an integer calculator that supports the `add` and
`multiply` functions. The program should take an expression string as a command
line argument and print out the result of evaluating the expression.

The examples follow the convention:

    INPUT
    OUTPUT

Where `INPUT` is the expression string passed as a single argument and `OUTPUT`
is the output printed to stdout by your program.

### Integers

Integers should be evaluated as the number they represent:

    123
    123

    0
    0

### Add

The `add` function should:

1. accept exactly 2 sub-expressions
2. fully evaluate the 2 sub-expressions
3. return the result of adding the 2 sub-expressions together

```
(add 1 1)
2

(add 0 (add 3 4))
7

(add 3 (add (add 3 3) 3))
12
```

### Multiply

The `multiply` function should:

1. accept exactly 2 sub-expressions
2. fully evaluate the 2 sub-expressions
3. return the result of multiplying the 2 sub-expressions together

```
(multiply 1 1)
1

(multiply 0 (multiply 3 4))
0

(multiply 2 (multiply 3 4))
24

(multiply 3 (multiply (multiply 3 3) 3))
81
```

Examples
--------

Besides the examples already provided above, it should be possible to mix and
match integers and function calls to build arbitrary calculations:

    (add 1 (multiply 2 3))
    7

    (multiply 2 (add (multiply 2 3) 8))
    28

Assumptions
-----------

A list of assumptions you're allowed to make:

- Since numbers are specified by digits only, you don't have to deal with
  inputting negative numbers.

- Depending on your choice of language, you may have to pick a data type to
  represent your integers and calculations. Pick something that gives you at
  least 32 bits. None of the calculations will deal with numbers larger than
  that and you won't be penalized for not dealing with overflow.

- You can be pretty lax about error handling. Throwing an exception when in an
  invalid state is fine.

  The tested examples will always be well formed. That means that:

  - Parenthesis will always be balanced.
  - Only the `add` and `multiply` functions will be called.
  - There will always be a single space between the function arguments.
  
Evaluation Criteria
-------------------

This is not a complete rubric by which we evaluate your submission, but gives
you a baseline of things we look for.

### Core Requirements

Any submission that fails to meet the following criteria will almost certainly
be rejected:

- Your code must run without modification. That means no compile or runtime
  errors for normal testcases.

- Your code must implement the required interface: a command line program that
  takes a single argument, evaluates the expression, and prints out a single
  number before exiting. This is not the same as taking input from standard
  input (`stdin`)!

- Your code must handle the following types of expressions:

    - Simple numbers: `45`

    - Simple add expressions: `(add 1 1)`

    - Simple multiply expressions: `(multiply 2 1)`

    - Expression arguments that are nested to an arbitrary depth:
      `(add 1 (multiply (add 2 1) 3))`. There should be no explicit limit in
      your code to how deep expressions can be.

- Your code must be idiomatic and espouse best practices in your programming
  language of choice. We recognize that different camps have different
  definitions of "idiomatic", so this is a loosely defined point, but if you're
  building an object-oriented calculator (for example), please don't write
  functions that communicate over global variables.

### Impressing Us

While the core requirements above serve as a baseline, here are additional
things that we look for. These are less objective but serve as a sliding scale
by which we grade submissions:

- Code clarity: how easy is it to read and reason about your code? Is data and
  control flow obvious and easy to follow?

- Abstraction: there are many similarities between the subproblems. Do you
  exploit the patterns and have clear delegation of responsibility, or merely
  copy/paste code?

- Extensibility: How easy is it to add new behaviours to your code? Examples:

    - What if we needed to support an arbitrary number of arguments to `add`
      and `multiply` instead of supporting exactly 2, as in
      `(add 1 2 3 4 (multiply 2 3 5))`?

    - What if we needed to add another function type, like `(exponent 2 5)`
      that calculates 2^5 = 32? Does that have a natural place to fit into your
      code or would that require large scale reworking?

- User experience: we've explicitly avoided requiring error handling, but how
  would your code need to be modified if the user provided malformed
  expressions. How good could you make your error messages?

To re-emphasize, we're not looking for submissions to implement all of the
points above nor are we asking you to implement any of the example behaviours.
These are simply hypothetical questions that we ask ourselves when looking at
your code.

[sexp]: https://en.wikipedia.org/wiki/S-expression
[ebnf]: https://en.wikipedia.org/wiki/Extended_Backus%E2%80%93Naur_form
