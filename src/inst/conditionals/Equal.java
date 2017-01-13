package inst.conditionals;

import bc.jumps.ConditionalJumps;
import bc.jumps.conditionaljumps.IfEq;
import elements.LexicalParser;
import inst.assignments.Term;

public class Equal extends Condition{
	
	public Equal(){
		super();
	}
	public Equal(Term t1, Term t2){
		super(t1,t2);
	}

	@Override
	protected Condition parseOp(Term t1, String op, Term t2, LexicalParser lexParser) {
		if(op.equals("=") && t1 != null && t2 != null) return new Equal(t1, t2);
		else return null;
	}

	@Override
	protected ConditionalJumps compileOp() {
		
		return new IfEq(); // HACER ESTO EN TODOS LOS SALTOS
	}

}
