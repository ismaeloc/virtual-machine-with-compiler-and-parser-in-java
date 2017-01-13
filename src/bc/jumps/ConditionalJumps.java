package bc.jumps;

import bc.ByteCodeOneParameter;
import elements.CPU;
import exceptions.ArrayException;
import exceptions.StackException;

public abstract class ConditionalJumps extends ByteCodeOneParameter {
	
	
	public ConditionalJumps(){}
	public ConditionalJumps(int j){ super(j); }

	@Override
	public void execute(CPU cpu) throws StackException, ArrayException {
		
		int n1, n2;
		if(cpu.getSizeStack() >= 2){
			n1 = cpu.pop(); //c
			n2 = cpu.pop(); //sc
			if(compare(n2,n1)) cpu.setProgramCounter(this.param);
			else cpu.increaseProgramCounter();
		}
		else throw new StackException("No hay suficientes operandos");
	}
	abstract protected boolean compare(int n1, int n2);
	
	public void setN(int n){
		this.param = n;
	}
}
