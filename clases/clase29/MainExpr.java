import java_cup.runtime.*;
import java.io.Reader;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class MainExpr {

    public static void usage() {
	System.err.println("MainExpr <file>");
	System.exit(1);
    }
    
    public static void main(String[] args) {
	if(args.length != 1) {
	    usage();
	}

	try {
	    ExprLexer scan = new ExprLexer(new FileReader(args[0]));
	    ExprParser parser = new ExprParser(scan);
	    parser.parse();
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
