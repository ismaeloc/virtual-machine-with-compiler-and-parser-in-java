package bc;

import elements.CPU;
import exceptions.StackException;

public class Out extends ByteCode {

	@Override
	public void execute(CPU cpu) throws StackException{
		int num = cpu.pop();
		
		cpu.increaseProgramCounter();
			if(num != -1){
				System.out.println(num);
			}
			else throw new StackException("No hay suficientes operandos");
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("OUT")) return new Out();
		else return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "OUT";
	}

}
