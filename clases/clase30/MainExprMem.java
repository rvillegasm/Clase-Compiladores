import java_cup.runtime.*;
import java.io.Reader;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class MainExprMem {

    public static void usage() {
	System.err.println("MainExprMem <file>");
	System.exit(1);
    }
    
    public static void main(String[] args) {
	if(args.length != 1) {
	    usage();
	}

	try {
	    ExprMemLexer scan = new ExprMemLexer(new FileReader(args[0]));
	    ExprMemParser parser = new ExprMemParser(scan);
	    System.out.println("Valor expr :" + (Integer) parser.parse().value );
	    System.out.println("Memoria: " + parser.getMemory());
	}
	catch(FileNotFoundException fnfe) {
	    usage();
	}
	catch(Exception e) {
	    System.err.println(e);
	    System.exit(1);
	}
    }
}
