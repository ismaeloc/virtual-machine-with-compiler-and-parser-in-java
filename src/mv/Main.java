package mv;

import java.io.FileNotFoundException;
import mv.Engine;
import exceptions.ArrayException;
import exceptions.BadFormatByteCodeException;
import exceptions.DivByZeroException;
import exceptions.ExecutionErrorException;
import exceptions.LexicalAnalysisException;
import exceptions.StackException;

//Hecho por Ismael Ocaña Ávila y Sergio Pacheco Fernández
public class Main {

	public static void main(String[] args) throws FileNotFoundException, ArrayException, StackException, DivByZeroException, LexicalAnalysisException, BadFormatByteCodeException, ExecutionErrorException {
		// TODO Auto-generated method stub
		Engine engine = new Engine();
		//engine.start();
		engine.pruebas();
	}

}
