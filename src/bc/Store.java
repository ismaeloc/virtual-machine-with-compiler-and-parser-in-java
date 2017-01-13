package bc;

import elements.CPU;
import exceptions.StackException;

public class Store extends ByteCodeOneParameter {
	
	public Store(int j){
		super(j);
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		
		if(string1.equalsIgnoreCase("STORE")){
			return new Store(Integer.parseInt(string2));
		}
		else return null;
	}

	@Override
	protected String toStringAux() {
		return "STORE";
	}

	@Override
	public void execute(CPU cpu) throws StackException {
		cpu.increaseProgramCounter();
		int a = cpu.pop();
		if(a != -1) cpu.store(param, a);
		else throw new StackException("No hay suficientes operandos");
		
	}

}
