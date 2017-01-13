package bc.jumps.conditionaljumps;

import bc.ByteCode;
import bc.jumps.ConditionalJumps;

public class IfNeq extends ConditionalJumps {
	
	public IfNeq(int j){
		super(j);
	}

	public IfNeq() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean compare(int n1, int n2) {
		if(n1 == n2) return true;
		else return false;
		
	}
	protected ByteCode parseAux(String string1, String string2) {
		
		if(string1.equalsIgnoreCase("IFNEQ")){
			return new IfNeq(Integer.parseInt(string2));
		}
		else return null;
	}

	@Override
	protected String toStringAux() {
		// TODO Auto-generated method stub
		return "IFNEQ";
	}
}
