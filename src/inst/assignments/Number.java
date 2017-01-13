package inst.assignments;

import bc.ByteCode;
import bc.Push;
import elements.LexicalParser;
import exceptions.ArrayException;
import inst.Instruction;
import elements.Compiler;

public class Number implements Term{
	
	private int number;
	
	public Number(int n){
		this.number = n;
	} 

	public Term parse(String term) {
		if (term.length()!=1) return null;
		 else {
		Integer num = Integer.parseInt(term);
		if (num != null)
		return new Number(num);
		else return null;
		 }
		}

	public ByteCode compile(Compiler compiler) {
		return new Push(number);
	}
	public String toString(){
		return null;
	}



	
}
