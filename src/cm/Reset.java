package cm;

import mv.Engine;

public class Reset implements Command {

	
	public void execute(Engine engine){
		engine.resetProgram();
	}
	public Command parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("RESET"))
		return new Reset();
		else return null;
		}
	public String textHelp() { 
		return " RESET: Vacia el programa actual " +
		System.getProperty("line.separator");
		}
	public String toString(){
		return "RESET";
	}

}
