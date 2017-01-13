package bc.arithmetics;

import bc.ByteCode;
import bc.Push;
import elements.CPU;

public class Sub extends Arithmetics {

	@Override
	public void executeOp(CPU cpu, int n1, int n2) {
		new Push(n2-n1).execute(cpu);
	}

	@Override
	public String toString() {
		return "SUB";
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("SUB")) return new Sub();
		else return null;
	}

}
