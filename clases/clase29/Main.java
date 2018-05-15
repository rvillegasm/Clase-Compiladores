import java_cup.runtime.*;
import java.io.Reader;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Main {

    public static void usage() {
	System.err.println("Main <file>");
	System.exit(1);
    }
    
    public static void main(String[] args) {
	if(args.length != 1) {
	    usage();
	}

	try {
	    DyckLexer scan = new DyckLexer(new FileReader(args[0]));
	    DyckParser parser = new DyckParser(scan);
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
