package bc.jumps;

import bc.ByteCode;
import bc.ByteCodeOneParameter;
import elements.CPU;
import exceptions.ArrayException;

public class Goto extends ByteCodeOneParameter {
	
	public Goto(int j){
		super(j);
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("GOTO"))
		return new Goto(Integer.parseInt(string2));
		else return null;
	}

	@Override
	protected String toStringAux() {
		
		return "GOTO";
	}

	@Override
	public void execute(CPU cpu) throws ArrayException {
		cpu.setProgramCounter(this.param);
	}

}
