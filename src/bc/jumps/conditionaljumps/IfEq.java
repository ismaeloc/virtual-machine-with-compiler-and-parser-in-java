package bc.jumps.conditionaljumps;

import bc.ByteCode;
import bc.jumps.ConditionalJumps;

public class IfEq extends ConditionalJumps {
	
	public IfEq(int j){
		super(j);
	}

	public IfEq() {
		
	}

	@Override
	protected boolean compare(int n1, int n2) {
		if(n1 == n2) return false;
		else return true;
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		
		if(string1.equalsIgnoreCase("IFEQ")){
			return new IfEq(Integer.parseInt(string2));
		}
		else return null;
	}

	@Override
	protected String toStringAux() {
		// TODO Auto-generated method stub
		return "IFEQ";
	}

}
