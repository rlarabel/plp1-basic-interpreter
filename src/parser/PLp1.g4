/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
grammar PLp1;

@header {
package parser;
}

program :
            ( element )+
        ;
            
element :
            function            
            | expression        
        ;

function :
             FUNCTION ID LP paramList RP LB expressionList RB
         ;

paramList :
              ( ID (COMMA ID)* )?
          ;

expressionList :
                   ( expression )+
               ;

expression :
                  expression MULT expression     
                | expression DIV expression     
                | expression ADD expression     
                | expression SUB expression     
                | expression EQ expression    
                | expression NE expression    
                | expression LT expression     
                | expression LE expression    
                | expression GT expression     
                | expression GE expression    
                | expression OR expression     
                | expression AND expression     
                | NOT expression                
                | varRef                        
                | constantExp                   
                | ifExpr                        
                | lambdaExp                     
                | assignment                    
                | switchExp                     
                | letExp                        
                | LP expression RP            
                | expression INVOKE LP argumentList RP    
           ;

varRef : ID              
       ;

constantExp :
             INTNUM             
             | FLOATNUM         
             | listExp          
             | STRING           
             | TRUE           
             | FALSE          
             | NULL            
            
         ;

listExp :
         LK (constantExp (COMMA constantExp)*)? RK
     ;


ifExpr :
           IF expression THEN expression ELSE expression ENDIF
       ;

lambdaExp :
           LAMBDA LP paramList RP LB expressionList RB
       ;

assignment :
               ID ASSIGN expression
           ;

letExp :
        LET LP letDecls RP LB expressionList RB
    ;

letDecls :
             ( letDecl )*
         ;

letDecl :
            LK ID expression RK
        ;

switchExp :
            SWITCH LB switchCases defaultCase RB
          ;

switchCases :
                ( switchCase )*
            ;

switchCase :
               CASE expression COLON expressionList
           ;

defaultCase :
                DEFAULT COLON expressionList
            ;

argumentList :
                 ( expression ( COMMA expression )*)?
             ;
                    
 
FUNCTION    : 'function';
IF          : 'if';
THEN        : 'then';
ELSE        : 'else';
ENDIF       : 'endif';
LAMBDA      : 'lambda';
LET         : 'let';
SWITCH      : 'switch';
CASE        : 'case';
DEFAULT     : 'default';
TRUE        : 'true';
FALSE       : 'false';
NULL        : 'null';

INVOKE      : '->';
EQ          : '==';
NE          : '!=';
LE          : '<=';
GE          : '>=';
MULT        : '*';
DIV         : '/';
ADD         : '+';
SUB         : '-';
LT          : '<';
GT          : '>';
NOT         : '!';
OR          : '|';
AND         : '&';
ASSIGN      : '=';

LP          : '(';
RP          : ')';
LB          : '{';
RB          : '}';
LK          : '[';
RK          : ']';
COMMA       : ',';
COLON       : ':';


fragment                
ALPHA : [a-zA-Z]
      ;

fragment
DIGIT : [0-9]
      ;

ID : ALPHA (ALPHA | DIGIT)*
   ;

fragment
POSITIVE : [1-9]
         ;

INTNUM : (POSITIVE DIGIT* | '0')
       ;

fragment
EXPONENT : ('e' | 'E') ('+' | '-')? DIGIT+
         ;

FLOATNUM : INTNUM '.' DIGIT+ EXPONENT?
         ;

STRING : '\'' ( ~[\n\r'])* '\'' 
       ;

NEWLINE : '\r'?'\n' ;

WS : [ \t]+ -> skip ; 

