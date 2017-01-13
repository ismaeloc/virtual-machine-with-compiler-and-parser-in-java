package cm;

import exceptions.DivByZeroException;
import exceptions.StackException;
import mv.Engine;

public class Run implements Command {

	public Run() {
	}
	public void execute(Engine engine) throws StackException, DivByZeroException{
		engine.executeCommandRun();
	}
	public Command parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("RUN"))
		return new Run();
		else return null;
		}
	public String textHelp() {
		return " RUN: Ejecuta el programa " +
		System.getProperty("line.separator");
		}
	public String toString(){
		return "RUN";
	}
}
