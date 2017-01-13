package bc.arithmetics;

import bc.ByteCode;
import bc.Push;
import elements.CPU;
import exceptions.StackException;

public class Div extends Arithmetics {


	@Override
	public void executeOp(CPU cpu, int n1, int n2) throws StackException {
		if(n1 != 0) new Push(n2/n1).execute(cpu);
		else throw new StackException("No hay suficientes operandos");
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("DIV")) return new Div();
		else return null;
	}

	@Override
	public String toString() {
		return "DIV";
	}

}
