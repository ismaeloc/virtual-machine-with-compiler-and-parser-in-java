package inst.assignments;

import bc.ByteCode;
import bc.Store;
import elements.LexicalParser;
import exceptions.ArrayException;
import inst.Instruction;
import elements.Compiler;

public class SimpleAssignment implements Instruction{
	
	private String varName;
	private Term rhs;
	
	public SimpleAssignment(){
		
	}
	public SimpleAssignment(String varName, Term rhs){
		this.varName = varName;//x
		this.rhs = rhs;//y
	}
	
	
	public Instruction lexParse(String[] words, LexicalParser lexParser){
		
		Variable var = new Variable("");
		
		if(words.length != 3) return null;
		else {
			if(var.parse(words[0]) == null) return null;
			this.varName = words[0];
			if(!words[1].equals("=")) return null;
			this.rhs = TermParser.parse(words[2]);
			if(rhs == null) return null;
			lexParser.increaseProgramCounter();
			return new SimpleAssignment(varName, rhs);
		}	
	}
	public void compile(Compiler compiler) throws ArrayException{
		ByteCode bc;
		int var = compiler.indexOf(varName); 
		bc = rhs.compile(compiler);
		compiler.addByteCode(bc);
		compiler.addByteCode(new Store(var));
	}
	
	public String toString(){
		return null;
	}
}
