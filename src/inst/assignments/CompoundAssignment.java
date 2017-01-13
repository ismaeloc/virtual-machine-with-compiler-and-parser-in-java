package inst.assignments;

import bc.ByteCode;
import bc.Store;
import bc.arithmetics.Add;
import bc.arithmetics.Div;
import bc.arithmetics.Mul;
import bc.arithmetics.Sub;
import elements.LexicalParser;
import exceptions.ArrayException;
import inst.Instruction;
import elements.Compiler;

public class CompoundAssignment implements Instruction{
	
	private String varName;
	private String operator;
	private Term term1, term2;
	
	public CompoundAssignment(String varName,String operator, Term t1, Term t2){
		this.varName = varName;
		this.operator = operator;
		this.term1 = t1;
		this.term2 = t2;
	}
	public CompoundAssignment(){
		
	}
	
	public Instruction lexParse(String[] words, LexicalParser lexParser){
		Variable var = new Variable("");
		
		if(words.length != 5) return null;
		else {
			if(var.parse(words[0]) == null) return null;
			this.varName = words[0];
			if(!words[1].equals("=")) return null;
			this.term1 = TermParser.parse(words[2]);
			if(term1 == null) return null;
			this.term2 = TermParser.parse(words[4]);
			this.operator = op(words[3]); //llamamos al switch de operaciones
			if(this.operator == null) return null; 
			lexParser.increaseProgramCounter();
			return new CompoundAssignment(varName, operator, term1, term2);
		}	
		
	}
	
	private String op(String operator){
		switch(operator){
		default: return null;
		case "+": return "+"; 
		case "-": return "-";
		case "*": return "*";
		case "/": return "/";
		}
	}
	
	public void compile(Compiler compiler) throws ArrayException{
		ByteCode bc1, bc2, bc3;
		
		int var = compiler.indexOf(varName); 
		
		bc1 = term1.compile(compiler); 
		bc2 = term2.compile(compiler); 
		bc3 = bcop(operator);
		
		compiler.addByteCode(bc2);
		compiler.addByteCode(bc1);
		compiler.addByteCode(bc3);
		compiler.addByteCode(new Store(var));	
	}
	
	private ByteCode bcop(String operator){
		switch(operator){
		default: return null;
		case "+": return new Add(); 
		case "-": return new Sub();
		case "*": return new Mul();
		case "/": return new Div();
		}
	}
	
	public String toString(){
		return "";
	}
}
