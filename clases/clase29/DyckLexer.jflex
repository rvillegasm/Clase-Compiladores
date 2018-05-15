import java_cup.runtime.*;

%%
%class DyckLexer
%cup

%%
"(" { return new Symbol(DyckSymbols.LPAREN); }
")" { return new Symbol(DyckSymbols.RPAREN); }
<<EOF>> { return new Symbol(DyckSymbols.EOF); }