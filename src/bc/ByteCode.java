package bc;

import elements.CPU;
import exceptions.ArrayException;
import exceptions.DivByZeroException;
import exceptions.StackException;

public abstract class ByteCode {
	

	 abstract public void execute(CPU cpu) throws StackException, DivByZeroException, ArrayException;
	 abstract public ByteCode parse(String[ ] s);
	 abstract public String toString();
	}