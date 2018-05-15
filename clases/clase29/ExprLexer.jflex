import java_cup.runtime.*;

%%
%class ExprLexer
%cup

digit = [0-9][0-9]*
whitespace = [ \t\v]+
newline = \n|\r\n

%%

"+" { return new Symbol(ExprSymbols.SUM); }
"-" { return new Symbol(ExprSymbols.RES); }
"*" { return new Symbol(ExprSymbolS.MUL); }
"/" { return new Symbol(ExprSymbols.DIV); }
"(" { return new Symbol(ExprSymbols.LPAREN); }
")" { return new symbol(ExprSymbols.RPAREN); }
{digit} { return new symbol(ExprSymbols.NUMBER); }
{whitespace} {}
{newline} {}
<<EOF>> { return new Symbol(ExprSymbols.EOF); }