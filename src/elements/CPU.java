package elements;

import exceptions.ArrayException;
import exceptions.DivByZeroException;
import exceptions.ExecutionErrorException;
import exceptions.StackException;
import bc.ByteCode;
import mv.ByteCodeProgram;

public class CPU {

	private Memory memory = new Memory();
	private OperandStack stack = new OperandStack();
	private boolean halt = false;
	private int programCounter = 0;
	private ByteCodeProgram bcProgram;

	public CPU(ByteCodeProgram bcProgram) {
		this.bcProgram = bcProgram;
	}

	public boolean isHalted() {
		return this.halt;
	}

	public void halt() {
		this.halt = true;
	}

	public void run() throws ExecutionErrorException, ArrayException {
		this.programCounter = 0;
		int numBC = bcProgram.getNumberOfByteCodes();
		
		if(numBC == 0){
			throw new ExecutionErrorException("No hay programa");
		}
		
		while (this.programCounter < numBC
				&& !isHalted()){
			try{
			ByteCode bc = bcProgram.getByteCode(this.programCounter);
			bc.execute(this); // this es cpu
				//try y catch
			}catch(DivByZeroException e){
				throw new ExecutionErrorException("Fallo en la instrucción. " + this.programCounter + " " + e.getMessage());
			}catch(StackException e){
				throw new ExecutionErrorException("Fallo en la instrucción. " + this.programCounter + " " + e.getMessage());
			}catch(ArrayException e){
				throw new ArrayException("Fallo en la instrucción. " + this.programCounter + " " + e.getMessage());
			}
		System.out.println(this.toString());
		}

	}

	public String toString() {
		String s = System.getProperty("line.separator") + "Estado de la CPU: "
				+ System.getProperty("line.separator") + " Memoria: "
				+ this.memory + System.getProperty("line.separator")
				+ " Pila: " + this.stack + System.getProperty("line.separator");
		return s;
	}

	public int getSizeStack() {
		return this.stack.getNumElems();
	}

	public void setProgramCounter(int param) throws ArrayException { //throw 
		if(param >= this.bcProgram.getNumberOfByteCodes() && param < 0){
			throw new ArrayException("Accediendo fuera de los limites del array");
		}
		else {
			this.programCounter = param;
		}
	}

	public void increaseProgramCounter() {
		this.programCounter++;
	}

	public int pop() throws StackException {
		return this.stack.pop();
	}

	public boolean push(int param) throws StackException {
		return this.stack.push(param);
	}

	public boolean load(int param) throws StackException, ArrayException {
		if (param >= memory.getSize())
			throw new ArrayException("Accediendo fuera de los limites del array"); 
		else
			return stack.push(memory.read(param));
	}

	public boolean store(int param, int num) {
		return memory.write(param, num);
	}
}
