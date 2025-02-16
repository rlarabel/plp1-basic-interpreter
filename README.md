[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/zOc7B3yj)
# CS 4850 PLp1 Rudimentary Interpreter Project
*Due Date*: Friday, March 29, 2024 @ 11:59pm.  


## Purpose

The purpose of this project is to gain experience in giving meaning to a
programming language by interpreting expressions in PLp1.


## Project Summary

In this project, you will need to implement an interpreter of the abstract syntax that you generated in Project 1. For full credit, you must use the visitor pattern we developed in class. Specifically, your interpreter must be able to 

1. Evaluate any abstract syntax generated for

    <ol type="a">
        <li> List, string, integer, floating-point and boolean constants,
        <li> Arithmetic, relational and boolean expressions,
        <li> If expressions, and
        <li> Switch expressions
    </ol>

1. Perform dynamic type checking according to the rules in the language definition document.
1. Evaluate function invocations for the PLp1 language-defined function listed in Table~1 in the language definition document. You must catch any error that could occur in a language defined function and report a suitable error message. Specifically, no Java exception or error produced by performing a language defined function should be left uncaught.
\end{enumerate}

## Abstract Syntax Tree

I have provided my AST generator in the shell project on GitHub. I have used ANTLR v4 as a parser and scanner. The code for the AST is in `src/ast`. The ANTLR parser and scanner specification is in `src/parser/PLp1.g4`. All other files in `src/parser` are automatically generated by the ANTLR system.

Walking the AST involves the visitor pattern. The interface for a visitor pattern is in `src/visitor/Visitor.java`. An example implementation of that interface is in `src/visitor/SourceVisitor.java`. That visitor converts the AST back into its source text representation. 

The table below gives the syntax and the AST representation for that syntax. 

|**Non-terminal** | **AST**|
|:--- | :--- |
$\mathbf{program}$ | $P \rightarrow \$\textbf{prog} \; (F \; \| \; E )^+$
$\mathbf{functionDef}$ | $ F \rightarrow \$\mathbf{func} \; P_l \; E_l $
$\mathbf{paramList}$ | $P_l \rightarrow I^*$ 
$\mathbf{expressionList}$ | $E_l \rightarrow E^+$
$\mathbf{Expression}$ | $E \rightarrow \$\mathbf{mult} \; E \; E$
| | $\quad \| \quad \mathbf{\$div} \; E \; E$
| | $\quad \| \quad \mathbf{\$plus} \; E \; E$
| | $\quad \| \quad \mathbf{\$minus} \; E \; E$
| | $\quad \| \quad \mathbf{\$eq} \; E \; E$
| | $\quad \| \quad \mathbf{\$neq} \; E \; E$
| | $\quad \| \quad \mathbf{\$lt} \; E \; E$
| | $\quad \| \quad \mathbf{\$le} \; E \; E$
| | $\quad \| \quad \mathbf{\$gt} \; E \; E$
| | $\quad \| \quad \mathbf{\$ge} \; E \; E$
| | $\quad \| \quad \mathbf{\$or} \; E \; E$
| | $\quad \| \quad \mathbf{\$and} \; E \; E$
| | $\quad \| \quad \mathbf{\$assign} \; I \; E$
| | $\quad \| \quad \mathbf{\$if} \; E \; E \; E$
| | $\quad \| \quad \mathbf{\$call} \; E \; E_l$
| | $\quad \| \quad \mathbf{\$switch} \; (E \; E_l)^+$
| | $\quad \| \quad \mathbf{\$lambda} \; P_l \; E_l $
| | $\quad \| \quad \mathbf{\$let} \; (I E)^* \; E_l $
| | $\quad \| \quad \mathbf{\$not} \; E$
| | $\quad \| \quad I \; \| \; C$
|$\langle \mathbf{ID} \rangle$ | $I \rightarrow \$\mathbf{id} \; @str$|
|$\langle \mathbf{constantExp} \rangle$ | $C \rightarrow \$\mathbf{int} \; @num$|
| | $\quad \| \; \$\mathbf{float} \; @num$|
| | $\quad \| \; \$\mathbf{list} \; C^*$|
| | $\quad \| \; \$\mathbf{str} \; @str$|

## What to do

Write a visitor using the supplied interface to walk the AST and interpreter it for the subset of syntax listed above. You will also need to implement a base environment. I have provided a partial implementation in `src/util`.

## Submission

Write all of your code in Java. Submit it via git.
