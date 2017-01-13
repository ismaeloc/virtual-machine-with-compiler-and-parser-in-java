package cm;

import exceptions.ArrayException;
import mv.Engine;

public class AddByteCodeProgram implements Command {
	
	public void execute(Engine engine) throws ArrayException{ //he puesto el array exception
		engine.readByteCodeProgram();
	}
	
	public Command parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("BYTECODE"))
		return new AddByteCodeProgram();
		else return null;
		}
	
	public String textHelp() {
		return " BYTECODE: Introduce un programa en base a instrucciones " 
				+ System.getProperty("line.separator");
		}
	public String toString(){
		return "BYTECODE";
	}

}
