package bc.arithmetics;

import bc.ByteCode;
import elements.CPU;
import exceptions.DivByZeroException;
import exceptions.StackException;

public abstract class Arithmetics extends ByteCode {

	@Override
	public void execute(CPU cpu) throws StackException, DivByZeroException {
		int n1, n2;
		
		if(cpu.getSizeStack() >= 2){
			n1 = cpu.pop();
			n2 = cpu.pop(); 
			executeOp(cpu, n1, n2);
		}
		else throw new StackException("No hay suficientes operandos");
	}
	public abstract void executeOp(CPU cpu, int n1, int n2) throws StackException, DivByZeroException;

}
