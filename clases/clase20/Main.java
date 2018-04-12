import java.io.FileReader;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
	if(args.length != 1) {
	    System.err.println("Usage: Main<filename>");
	    System.exit(1);
	}
	try {
	    FileReader fr = new FileReader(args[0]);
	    SumaEnteros se = new SumaEnteros(fr);

	    while(se.getLex() != 0);

	    se.imprimirLista();
	    System.out.println("Suma: " + se.sumarLista());
	    fr.close();
	}
	catch(FileNotFoundException fnfe) {
	    System.err.println("Usage: Main <filename>");
	    System.exit(1);
	}
	catch(Exception e) {
	    System.err.println(e.toString());
	    System.exit(1);
	}
    }
    
}

