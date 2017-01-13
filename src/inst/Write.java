package inst;

import bc.ByteCode;
import bc.Load;
import bc.Out;
import inst.assignments.Term;
import inst.assignments.Variable;
import elements.LexicalParser;
import exceptions.ArrayException;
import elements.Compiler;

public class Write implements Instruction{
	
	private String varName;
	private Term term1;
	public Write(){
		
	}
	public Write(String varName){
		this.varName = varName;
	}
	
	public Instruction lexParse(String[] words, LexicalParser lexParser){
		
		if (words.length != 2) return null;
		else {
			
			this.term1 = new Variable(words[1]);
			this.term1 = term1.parse(words[1]);
			
			if (!words[0].equalsIgnoreCase("write")) return null;
			else if(term1 == null) return null;
			else {
				lexParser.increaseProgramCounter();
				return new Write(words[1]);
			}
		}
	}
	public void compile(Compiler compiler) throws ArrayException {
		ByteCode bc;
		int i = compiler.indexOf(varName);
		bc = new Load(i);
		compiler.addByteCode(bc);
		compiler.addByteCode(new Out());
	}

}