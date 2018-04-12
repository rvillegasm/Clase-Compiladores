
import java.util.List;
import java.util.ArrayList;

%%

%class SumaEnteros
%public
%init{
  listaEnteros = new ArrayList<Integer>();
%init}
%function getLex
%int
%{
   private List<Integer> listaEnteros;

   public void imprimirLista() {
     for(Integer i : listaEnteros) {
       System.out.println(i);
     }
   }

   public int sumarLista() {
     int suma = 0;
     for(Integer i : listaEnteros) {
       suma += i;
     }
     return suma;
   }
%}
%eofval{
  return 0;
%eofval}

Entero = 0 | [1-9][0-9]*
TerminadorLinea = \r|\n|\r\n
EspaciosBlanco = {TerminadorLinea} | [ \t\f]+

%%

{Entero}	 { listaEnteros.add(Integer.parseInt(yytext()));
	   	   return 1;
	 	 }
.        	 { return 1; }
{EspaciosBlanco} {}