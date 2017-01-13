package cm;

import mv.Engine;

public class Help implements Command {
	
	public void execute(Engine engine){
		Engine.showHelp(); 
	}
	public Command parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("HELP"))
		return new Help();
		else return null;
		}
	public String textHelp() {
		return " RESET: Vacia el programa actual " +
		System.getProperty("line.separator");
		}
	
	public String toString(){
		return "HELP";
	}
}
