package cm;

import mv.Engine;

public class Quit implements Command {

	@Override
	public String textHelp() {
		return " QUIT: Termina con la ejecución del programa " +
				System.getProperty("line.separator");
	}

	@Override
	public void execute(Engine engine) {
		engine.endExecution();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("QUIT"))
		return new Quit();
		else return null;
	}
	public String toString(){
		return "QUIT";
	}

}
