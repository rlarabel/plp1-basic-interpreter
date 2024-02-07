#  PLp1: A Dynamically Typed Functional Language for Instruction 

PLp1 (PL point 1) is a programming language designed for practice interpretation.
PLp1 is a simple dynamically typed language that contains elements of functional, object-oriented and imperative paradigms.  PLp1 is intended to be simple enough to interpret in a
single semester by any student willing to put in some effort. Each feature
included in the language was added specifically to help students learn about the meaning of programs written in different paradigms. The goal of this project is to help student understand what it means to express something in a language by writing an operational semantics (fancy words for interpreter). In the process, I hope that you will understand object-oriented design better and also learn about functional programming.

## Lexical Properties of PLp1

1.  In PLp1, blanks are significant.
1.  In PLp1, all keywords are reserved; that is, the programmer cannot use an PLp1 keyword as the name of a variable.

	The valid keywords are:

$\begin{array}{lcl}
\langle \mathbf{CASE} \rangle & \rightarrow & \texttt{case}\\
\langle \mathbf{CLASS} \rangle & \rightarrow & \texttt{class}\\
\langle \mathbf{CREATE} \rangle & \rightarrow & \texttt{create}\\
\langle \mathbf{DEFAULT} \rangle & \rightarrow & \texttt{default}\\
\langle \mathbf{ENDIF} \rangle & \rightarrow & \texttt{endif}\\
\langle \mathbf{ELSE} \rangle & \rightarrow & \texttt{else}\\
\langle \mathbf{FALSE} \rangle & \rightarrow & \texttt{false}\\
\langle \mathbf{FUNCTION} \rangle & \rightarrow & \texttt{function}\\
\langle \mathbf{IF} \rangle & \rightarrow & \texttt{if}\\
\langle \mathbf{INIT} \rangle & \rightarrow & \texttt{init}\\
\langle \mathbf{LAMBDA} \rangle & \rightarrow & \texttt{lambda}\\
\langle \mathbf{LET} \rangle & \rightarrow & \texttt{let}\\
\langle \mathbf{METHOD} \rangle & \rightarrow & \texttt{method}\\
\langle \mathbf{NULL} \rangle & \rightarrow & \texttt{null}\\
\langle \mathbf{SWITCH} \rangle & \rightarrow & \texttt{switch}\\
\langle \mathbf{THEN} \rangle & \rightarrow & \texttt{then}\\
\langle \mathbf{TRUE} \rangle & \rightarrow & \texttt{true}\\
\end{array}$


Note that PLp1 is *case sensitive*, that is, the variable
`X` differs from `x`.  Thus, `switch` is a keyword, but
`SWITCH` be a variable name.


1. The following special characters have meanings in an PLp1
program. 

$\begin{array}{lcl}
\langle \mathbf{AND} \rangle & \rightarrow & \texttt{\&}\\
\langle \mathbf{ASSIGN} \rangle & \rightarrow & \texttt{=}\\
\langle \mathbf{COMMA} \rangle & \rightarrow & \texttt{,}\\
\langle \mathbf{COLON} \rangle & \rightarrow & \texttt{:}\\
\langle \mathbf{DIVIDE} \rangle & \rightarrow & \texttt{/}\\
\langle \mathbf{DOT} \rangle & \rightarrow & \texttt{.}\\
\langle \mathbf{EQUAL} \rangle & \rightarrow & \texttt{==}\\
\langle \mathbf{GREATER} \rangle & \rightarrow & \texttt{>}\\
\langle \mathbf{GREATEREQUAL} \rangle & \rightarrow & \texttt{>=}\\
\langle \mathbf{INVOKE} \rangle & \rightarrow & \texttt{->}\\
\langle \mathbf{LB} \rangle & \rightarrow & \texttt{\{}\\
\langle \mathbf{LBK} \rangle & \rightarrow & \texttt{[}\\
\langle \mathbf{LESS} \rangle & \rightarrow & \texttt{<}\\
\langle \mathbf{LESSEQUAL} \rangle & \rightarrow & \texttt{<=}\\
\langle \mathbf{LP} \rangle & \rightarrow & \texttt{(}\\
\langle \mathbf{MINUS} \rangle & \rightarrow & \texttt{-}\\
\langle \mathbf{MULTIPLY} \rangle & \rightarrow & \texttt{*}\\
\langle \mathbf{NOT} \rangle & \rightarrow & \texttt{!}\\
\langle \mathbf{NOTEQUAL} \rangle & \rightarrow & \texttt{!=}\\
\langle \mathbf{OR} \rangle & \rightarrow & \texttt{|}\\
\langle \mathbf{PLUS} \rangle & \rightarrow & \texttt{+}\\
\langle \mathbf{RB} \rangle & \rightarrow & \texttt{\}}\\
\langle \mathbf{RBK} \rangle & \rightarrow & \texttt{]}\\
\langle \mathbf{RP} \rangle & \rightarrow & \texttt{)}\\
\end{array}$


1. Comments are delimited by a `//`. All characters following the `//` on the same line are part of the comment.


1.  Identifiers are written with upper and
lowercase letters and are defined
as follows:

$\begin{array}{l c l}
\langle \mathbf{ALPHA} \rangle&\rightarrow&\texttt{a} \; \mid \; \texttt{b} \; \mid \; \texttt{c} \; \mid \; \cdots \; \mid \; \texttt{z} \; \mid \; \texttt{A} \; \mid \; \texttt{B} \; \mid \; \cdots \; \mid \; \texttt{Z}\\
\langle \mathbf{DIGIT} \rangle &\rightarrow&\texttt{0} \; \mid \; \texttt{1} \; \mid \; \texttt{2} \; \mid \; \cdots \; \mid \; \texttt{9}\\
\langle \mathbf{IDENTIFIER} \rangle &\rightarrow&\langle \mathbf{LETTER} \rangle \; (\langle \mathbf{LETTER} \rangle \; \mid \langle \mathbf{DIGIT} \rangle \; )^{*}\\
\end{array}$

1.  Constants are defined as follows:

$\begin{array}{l c l}
\langle \mathbf{POSITIVE} \rangle &\rightarrow&\texttt{1} \; \mid \; \texttt{2} \; \mid \; \texttt{3} \; \mid \; ... \; \mid \; \texttt{9}\\
\langle \mathbf{INTNUM} \rangle &\rightarrow&\langle \mathbf{POSITIVE} \rangle \; \langle \mathbf{DIGIT} \rangle^{*} \; \mid \; {\tt 0}\\
\langle\mathbf{EXPONENT}\rangle & \rightarrow & (\;\texttt{e}\; \mid \;\texttt{E}\;)\; (\;\texttt{+}\; \mid \;\texttt{-}\;)? \;(\;\langle\mathbf{DIGIT}\rangle\;)^+ \\
\langle\mathbf{FLOATNUM}\rangle & \rightarrow & \langle \mathbf{INTNUM} \rangle \; (\;\langle \mathbf{DOT} \rangle \;(\;\langle \mathbf{DIGIT} \rangle\; )^+\\
 & & \;(\;\langle\mathbf{EXPONENT}\rangle\;)?\; \mid \; \langle\mathbf{EXPONENT}\rangle\;) \\
\langle \mathbf{STRING} \rangle & \rightarrow & ' \; (\;\sim[ \; ' \;]\;)^* \; '\\
\end{array}$

1. Whitespace, newline, tab, and spaces may only appear withing strings and comments. In all other contexts, encountering a space indicates the end of a lexeme.

## Context-free Grammar

The following grammar describes the context-free syntax of PLp1:

{\small
$\begin{array}{ l c l}
 & & \\
\mathbf{program} & \rightarrow &  ( \; \mathbf{functionDef}\\
								 & \mid & \; \; \mathbf{classDef} \\
								 & \mid & \; \; \mathbf{expression} \; )^+\\
 & & \\
\mathbf{functionDef} & \rightarrow &  \langle \mathbf{FUNCTION} \rangle \; \langle \mathbf{ID} \rangle \; \langle \mathbf{LP} \rangle \; \mathbf{paramList} \; \langle \mathbf{RP} \rangle\\ 
 & & \langle \mathbf{LB} \rangle \;\mathbf{expressionList} \; \langle \mathbf{RB} \rangle \\	
 & & \\
 \mathbf{paramList}& \rightarrow & ( \; \langle \mathbf{ID} \rangle \; ( \; \langle \mathbf{COMMA} \rangle \; \langle \mathbf{ID} \rangle \; )^* \; )?\\
 & & \\
 \mathbf{classDef} & \rightarrow & \langle \mathbf{CLASS} \rangle	\; \langle \mathbf{ID} \rangle \; \langle \mathbf{LB} \rangle \;   \mathbf{variables} \; \mathbf{init} \; \mathbf{methods} \; \langle \mathbf{RB} \rangle		\\		
 & & \\
 \mathbf{variables}	& \rightarrow & ( \;\langle \; \mathbf{ID} \; \rangle \;)^*\\
  & & \\
 \mathbf{init} & \rightarrow & \langle \mathbf{INIT} \rangle \; \langle \mathbf{LP} \rangle \; \mathbf{paramList} \; \langle \mathbf{RP} \rangle \;  \langle \mathbf{LB} \rangle \; \mathbf{expressionList} \; \langle \mathbf{RB} \rangle\\
 & & \\
 \mathbf{methods} & \rightarrow & ( \; \mathbf{method} \; )^*\\
  & & \\
 \mathbf{method} & \rightarrow & \langle \mathbf{METHOD} \rangle \; \langle \mathbf{ID} \rangle \; \langle \mathbf{LP} \rangle \; \mathbf{paramList} \; \langle \mathbf{RP} \rangle \;  \langle \mathbf{LB} \rangle \; \mathbf{expressionList} \; \langle \mathbf{RB} \rangle\\
 & & \\
 \mathbf{expressionList} & \rightarrow & ( \;  \mathbf{expression} \ )^+ \\
 & & \\
 \mathbf{expression}& \rightarrow &  \mathbf{expression} \; \langle \mathbf{MULTIPLY} \rangle \; \mathbf{expression} \\
 & \mid & \mathbf{expression} \; \langle \mathbf{DIVIDE} \rangle \; \mathbf{expression} \\
 & \mid & \mathbf{expression} \; \langle \mathbf{PLUS} \rangle \; \mathbf{expression} \\
 & \mid & \mathbf{expression} \; \langle \mathbf{MINUS} \rangle \; \mathbf{expression} \\
 & \mid & \mathbf{expression} \; \langle \mathbf{EQUAL} \rangle \; \mathbf{expression} \\
 & \mid & \mathbf{expression} \; \langle \mathbf{NOTEQUAL} \rangle \; \mathbf{expression} \\
 & \mid & \mathbf{expression} \; \langle \mathbf{LESS} \rangle \; \mathbf{expression} \\
 & \mid & \mathbf{expression} \; \langle \mathbf{LESSEQUAL} \rangle \; \mathbf{expression} \\
 & \mid & \mathbf{expression} \; \langle \mathbf{GREATER} \rangle \; \mathbf{expression} \\
 & \mid & \mathbf{expression} \; \langle \mathbf{GREATEREQUAL} \rangle \; \mathbf{expression} \\
 & \mid & \mathbf{expression} \; \langle \mathbf{OR} \rangle \; \mathbf{expression} \\
 & \mid & \mathbf{expression} \; \langle \mathbf{AND} \rangle \; \mathbf{expression} \\
 & \mid &\langle \mathbf{NOT} \rangle \; \mathbf{expression} \\
 & \mid & \ \mathbf{varRef}\; \mid \; \mathbf{constantExp}  
 \; \mid \; \mathbf{createExpr} \; \mid \; \mathbf{ifExpr}\\
 &  \mid  &   \mathbf{lambdaExpr}  \; \mid \;  \mathbf{assignment}  
 \; \mid \;  \mathbf{switchExpr}  \\ 
 & \mid &  \mathbf{letExpr}  \; \mid \; \langle \mathbf{LP} \rangle \;  \mathbf{expression}  \; \langle \mathbf{RP} \rangle\\
 & \mid & \mathbf{expression} \; \langle \mathbf{INVOKE} \rangle \; \langle \mathbf{LP} \rangle \; \mathbf{argumentList}  \; \langle \mathbf{RP} \rangle\\
 \end{array}$
} %the \small

{\small
$\begin{array}{ l c l}
 \mathbf{varRef} & \rightarrow &  \langle \mathbf{ID} \rangle \; ( \; \langle  \mathbf{DOT} \rangle \; \langle \mathbf{ID} \rangle \;)? \\
  & & \\
 \mathbf{constantExp}\ & \rightarrow & \langle \mathbf{INTUM} \rangle \; \mid \; \langle \mathbf{FLOATNUM} \rangle \; \mid \;  \mathbf{listExp} \; \mid \; \langle \mathbf{STRING} \rangle \\
 & \mid & \langle \mathbf{TRUE} \rangle \; \mid \; \langle \mathbf{FALSE} \rangle \; \mid \; \langle \mathbf{NULL} \rangle\\
 & & \\
 \mathbf{listExp}  & \rightarrow & \langle \mathbf{LBK} \rangle \;  ( \; \mathbf{constantExp} \; ( \; \langle \mathbf{COMMA} \rangle \;  \mathbf{constantExp} \; )^* \;)? \;\langle \mathbf{RBK} \rangle \\
 & & \\
 \mathbf{createExpr} & \rightarrow & \langle \mathbf{CREATE} \rangle \; \langle \mathbf{ID} \rangle \\
 & & \\
 \mathbf{ifExpr} & \rightarrow & \langle \mathbf{IF} \rangle \; \mathbf{expression} \; \langle \mathbf{THEN} \rangle \; \mathbf{expression} \; \langle \mathbf{ELSE} \rangle \; \mathbf{expression} \; \langle \mathbf{ENDIF} \rangle \\
 & & \\
 \mathbf{lambdaExpr} & \rightarrow & \langle \mathbf{LAMBDA} \rangle \; \langle \mathbf{LP} \; \rangle \; \mathbf{paramList} \; \langle \; \mathbf{RP} \rangle \; \langle \mathbf{LB} \rangle \; \mathbf{expressionList} \; \langle \mathbf{RB} \rangle \\
 & & \\
 \mathbf{assignment} & \rightarrow & \langle \mathbf{ID} \rangle \; \langle \mathbf{ASSIGN} \rangle \;  \mathbf{expression}  \\
 & & \\
 \mathbf{switchExpr} & \rightarrow &  \langle \mathbf{SWITCH} \rangle \; \langle \mathbf{LB} \rangle \; \mathbf{switchCases} \; \mathbf{defaultCase} \; \langle \mathbf{RB} \rangle\\
 & & \\
 \mathbf{switchCases} & \rightarrow & ( \;  \mathbf{switchCase} \;  \;)^+\\ 
 & & \\
 \mathbf{switchCase} & \rightarrow & \langle \mathbf{CASE} \rangle \; \mathbf{expression} \;  \langle \mathbf{COLON} \rangle \; \mathbf{expressionList} \\
 & & \\
 \mathbf{defaultCase} & \rightarrow & \langle \mathbf{DEFAULT} \rangle \;  \langle \mathbf{COLON} \rangle \; \mathbf{expressionList} \\
 & & \\
 \mathbf{letExpr} & \rightarrow & \langle \mathbf{LET} \rangle \; \langle \mathbf{LP} \rangle \;  \mathbf{letDecls}  \; \langle \mathbf{RP} \rangle \; \langle \mathbf{LB} \rangle \; \mathbf{expressionList} \; \langle \mathbf{RB} \rangle \\
 & & \\
 \mathbf{letDecls} & \rightarrow & ( \;  \mathbf{letDecl} \;  \;)^*\\ 
 & & \\
 \mathbf{letDecl} & \rightarrow & \langle \mathbf{LBK} \rangle \; \langle \mathbf{ID} \rangle \; \mathbf{expression} \; \langle \mathbf{RBK} \rangle \\
 & & \\
 \mathbf{argumentList}& \rightarrow & ( \; \mathbf{expression} \; ( \; \langle \mathbf{COMMA} \rangle \; \mathbf{expression} \; )^* \; )?\\
\end{array}$
}

\newpage

## PLp1 Notes

### Function Declarations

The semantics of function definition cause the variable to be added to the environment with a closure as a value.

```
Example:

function even (n)  {
    if (n == 0) then
        true 
   else 
       odd->(n - 1)
   endif
 }

function odd (n) {
    if (n == 0) then
        false
    else
        even->(n - 1)
    endif
 }
```

In the above program, the variables `even` and `odd` are added to the environment with closures for values. The value of a function definition is a closure.

### Assignments

A variable is given a new value using an `assignment` expression.

```
x = 2 + 3
```

In the previous expression, `x` is given the value 5 and 5 is the return value of the entire `assign` expression.

### If Expression

If the first expression in an `if` is `true`, then the expression in the `then`-part is evaluated and returned. Otherwise the expression in the `else`-part is evaluated and returned.

```
if x == 5 then 5 else 4 endif
```

The value returned by this expression is `5`.
 
### Switch Expression

The `switch` expression is a concise format for a sequence of `if-then-else-if` expressions. For example,

```
if x == 5 then
  5+2
else
  if x == 6 then
    5+3
  else 
    if x == 7 then
      5+4
    else
      5+5
    fi
  fi
fi   
```

can equivalently be expressed as

```
switch {
  case x == 5  : 5+2
  case x == 6  : 5+3
  case x == 7  : 5+4
  default      : 5+5
}
```

### Let Expressions

Variables are given scope in PLp1 using a `let` expression. For example,

```
let ([x 5]) {
  x + 10
}
```

gives scope to the variable `x` in the body of the `let` expression and gives it an initial value of `5`. The expression evaluation returns the value `10`.

### Function Invocation

A function invocation is done with the `->` operator. Thus, the expression `even->(n-1)` in the previous declaration of `odd` calls the function `even` with the value of `n-1` as an argument. PLp1 also defines the language-supported functions in Table~\ref{tab:base`.

| **Function Prototype** | **Parameter Types** | **Description**|
|-----------------------|---------------------|----------------|
| `first->(L)` | `L` -  a list | Return the first element of a `L`|
| `rest->(L)` | `L` - a list | Return a list contain all elements of `L` except the firs|t
| `insert->(e,L)` | `e` - any value, `L` - a list | Insert `e` onto the front of `L`|
| `list->(e,...)` | `e,...` - one or more values | create a list containing all parameters|
| `emptyp->(L)` | `L` - a list | Return true iff `L` is an empty list|
| `pairp->(L)` | `L` - a list | true iff `L` is a non-empty list|
| `listp->(L)` | `L` - a list | Return true iff `L` is a list |
| `equalp->(L1,L2)` | `L1,L2` - lists | Return true iff `L1` and `L2` are equivalent lists |
| `length->(L)` | `L` - a list | Return the length of `L` |
| `numberp->(e)` | `e` - any value | Return true iff `e` is a number |
| `exit->()` |  | exit the interpreter\\ |


### Lambda Expression

PLp1 supports first-class functions. Thus, functions are values just as numbers are values. The expression

```
lambda (x) { x + 2 }
```

declares a nameless function that adds `2` to its argument. A lambda expression can be put anywhere in a program that any other expression can be put. Thus, it can be asssigned to a variable in an assignment expression or called in an invocation as in

```
(lambda (x) { x + 2 })->(3)
```

which returns the value `5`.

### Expressions

PLp1 arithmetic expressions compute simple values of type integer or float
For both integer and floating point numbers,
arithmetic and comparison are defined.


#### Coercion:
If an expression contains operands of only one type, evaluation is
straight forward.
When an operand contains mixed types, the situation is more complex.
If an arithmetic expression has an integer operand and a float
operand, the integer operand should be converted to a float
before the operation is performed.

Relational and logic operators always produce a boolean. To perform a
comparison between an integer and a float, the integer is converted to a float. Logic operators are only defined on boolean values. In addition, boolean values may not be used in relational and arithmetic operators.

The table below summarizes the coercion rules.

| **Left Operand Type** | **Possible Right Operand Types** |
|-----------------------|------------------------|
|  |*Float* - *Integer* - *Boolean* - *List* - *String* |
|	*Integer* | Float - Integer - *error* - *error* - *error*|
|	*Float* | Float - Float - *error* - *error* - *error*|
|	*Boolean* |  *error* - *error* - *error* - *error* - *error*|
|	*List* |  *error* - *error* - *error* - *error* - *error*|
|	*String* |  *error* - *error* - *error* - *error* - *error*|

#### Operator Precedence

Operator precedences in PLp1 are specified in the table below.
Multiplication and division have the highest priority, `&` and `|` have
the lowest. 

|**Operator**|**Precedence**|
|------|-----------|
|*, /|5|
|+, -|4|
|<, <=, =, >=, >, !=|3|
|!|2|
|&, \||1|

Precedence has already been encoded in the grammar above.

<!-- ### Classes and Objects

PLp1 supports simple classes without inheritance. Classes may contain instance variables and methods. All variables have private access and all methods have public access. The code below defines a class with one instance variable and getter and setter methods for that variable.

```
class test {
    x
    init() { x = 3 }
    method setX(n) { x = n }
    method getX() { x }
}
```


To instantiate an object, the `create` operator is used. In the expression

```
t = create test
```

a new instance of `test` is assigned to the variable `t`. Methods are accessed using the `.` operator and invoked using the `->` operator. As an example, the following code returns the value `0`.

```
function f (x) {
    t = create test
    t.setX->(x)
    t.getX->()
}

f->(0)
``` -->