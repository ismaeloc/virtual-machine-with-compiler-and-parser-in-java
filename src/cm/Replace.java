package cm;

import exceptions.ArrayException;
import exceptions.BadFormatByteCodeException;
import mv.Engine;

public class Replace implements Command {
	
	private int replace;

	public Replace(int replace) {
		this.replace = replace;
	}
	
	public void execute(Engine engine) throws BadFormatByteCodeException, ArrayException, NumberFormatException{
		engine.replaceByteCode(replace);
	}
	public Command parse(String[] s) {
		if (s.length==2 && s[0].equalsIgnoreCase("REPLACE"))
			try{
				return new Replace(Integer.parseInt(s[1]));
			}catch (NumberFormatException e){
				throw new NumberFormatException("Se esperaba un número");
			}
		else return null;
		}
	public String textHelp() {
		return " REPLACE N: Reemplaza la instruccion N por la solicitada al usuario " +
		System.getProperty("line.separator");
		}
	public String toString(){
		return "REPLACE";
	}
}
