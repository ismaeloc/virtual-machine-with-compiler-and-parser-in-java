package bc;

import elements.CPU;

public class Push extends ByteCodeOneParameter {
	
	public Push(int j){
		super(j);
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("PUSH"))
		return new Push(Integer.parseInt(string2));
		else return null;
	}

	@Override
	protected String toStringAux() {
		// TODO Auto-generated method stub
		return "PUSH";
	}

	@Override
	public void execute(CPU cpu) {
		cpu.increaseProgramCounter();
		cpu.push(param);
	}

}
