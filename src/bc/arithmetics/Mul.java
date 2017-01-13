package bc.arithmetics;

import bc.ByteCode;
import bc.Push;
import elements.CPU;

public class Mul extends Arithmetics {

	@Override
	public void executeOp(CPU cpu, int n1, int n2) {
		new Push(n1*n2).execute(cpu);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("MUL")) return new Mul();
		else return null;
	}

	@Override
	public String toString() {
		return "MUL";
	}

}
