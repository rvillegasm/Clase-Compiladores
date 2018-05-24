package co.edu.eafit.dis.st0270.s20181.expr;

import java_cup.runtime.Symbol;

%%
%cup
%class ExprLexer
%line
%column

number = [1-9][0-9]*
whitespace = [ \t]

%%

"+"	{ return new Symbol(ExprSymbols.ADD); }
"-"	{ return new Symbol(ExprSymbols.SUB); }
"*"	{ return new Symbol(ExprSymbols.TIMES); }
"/"	{ return new Symbol(ExprSymbols.DIV); }
"("	{ return new Symbol(ExprSymbols.LPAREN); }
")"	{ return new Symbol(ExprSymbols.RPAREN); }
{whitespace}	 { }
{number}	 { return new Symbol(ExprSymbols.NUMBER, new Integer(yytext())); }
<<EOF>>		 { return new Symbol(ExprSymbols.EOF); }