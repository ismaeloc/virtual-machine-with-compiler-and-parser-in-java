package inst.conditionals;

import bc.jumps.ConditionalJumps;
import bc.jumps.conditionaljumps.IfLeq;
import elements.LexicalParser;
import inst.assignments.Term;

public class LessEq  extends Condition{
	
	public LessEq(){
		super();
	}
	public LessEq(Term t1, Term t2){
		super(t1,t2);
	}

	@Override
	protected Condition parseOp(Term t1, String op, Term t2, LexicalParser lexParser) {
		if(op.equals("<=") && t1 != null && t2 != null) return new LessEq(t1, t2);
		else return null;
	}

	@Override
	protected ConditionalJumps compileOp() {
		// TODO Auto-generated method stub
		return new IfLeq();
	}

}
