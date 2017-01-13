package bc.arithmetics;

import bc.ByteCode;
import bc.Push;
import elements.CPU;

public class Add extends Arithmetics {

	@Override
	public void executeOp(CPU cpu, int n1, int n2) {
		new Push(n1+n2).execute(cpu);
	}
	public String toString(){
		return "ADD";
	}
	public ByteCode parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("ADD")) return new Add();
		else return null;
	}
}
