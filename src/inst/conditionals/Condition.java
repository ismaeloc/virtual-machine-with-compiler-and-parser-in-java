package inst.conditionals;

import bc.ByteCode;
import bc.Store;
import bc.jumps.ConditionalJumps;
import elements.LexicalParser;
import exceptions.ArrayException;
import inst.assignments.Term;
import inst.assignments.TermParser;
import elements.Compiler;

public abstract class Condition {
	private Term term1, term2;
	protected ConditionalJumps cj;
	
	public Condition(){
		
	}
	
	public Condition(Term t1,Term t2){
		this.term1=t1;
		this.term2=t2;
	}
	
	
	
	public Condition parse(java.lang.String t1, String op, String t2, LexicalParser parser){
		this.term1=TermParser.parse(t1);
		this.term2=TermParser.parse(t2);
		return parseOp(term1, op, term2, parser);
	}

	protected abstract Condition parseOp(Term t1,String op,Term t2, LexicalParser lexParser);
	
	public void compile(Compiler compiler) throws ArrayException {
		
       ByteCode bc1, bc2, bc3;
		
		bc1 = term1.compile(compiler); 
		bc2 = term2.compile(compiler); 
		bc3 = this.compileOp();
		
		compiler.addByteCode(bc2);
		compiler.addByteCode(bc1);
		compiler.addByteCode(bc3);
		
	}
	protected abstract ConditionalJumps compileOp();

	public void setJump(int sizeBcProgram) {
		this.cj.setN(sizeBcProgram);
	}

}
