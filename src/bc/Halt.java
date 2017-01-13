package bc;

import elements.CPU;

public class Halt extends ByteCode {

	@Override
	public void execute(CPU cpu) {
		cpu.increaseProgramCounter();
		cpu.halt();
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("HALT")) return new Halt();
		else return null;
	}

	@Override
	public String toString() {
		return "HALT";
	}

}
