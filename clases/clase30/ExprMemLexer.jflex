import java_cup.runtime.Symbol;

%%
%cup
%line
%column
%class ExprMemLexer

number = [1-9][0-9]*
whitespace = [ \t]

%%

"+"	{ return new Symbol(ExprMemSymbols.ADD); }
"-"	{ return new Symbol(ExprMemSymbols.SUB); }
"*"	{ return new Symbol(ExprMemSymbols.TIMES); }
"/"	{ return new Symbol(ExprMemSymbols.DIV); }
"S" 	{ return new Symbol(ExprMemSymbols.STORE); }
"R"	{ return new Symbol(ExprMemSymbols.RECALL); }
"("	{ return new Symbol(ExprMemSymbols.LPAREN); }
")"	{ return new Symbol(ExprMemSymbols.RPAREN); }
{whitespace} { } 
{number}     { return new Symbol(ExprMemSymbols.NUMBER, new Integer(yytext())); }
<<EOF>>	     { return new Symbol(ExprMemSymbols.EOF); }