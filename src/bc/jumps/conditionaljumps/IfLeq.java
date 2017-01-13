package bc.jumps.conditionaljumps;

import bc.ByteCode;
import bc.jumps.ConditionalJumps;

public class IfLeq extends ConditionalJumps {
	
	public IfLeq(int j){
		super(j);
	}

	public IfLeq() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean compare(int n1, int n2) { //creo que el fallo está aqui en el <=
		if(n1 <= n2) return false; //sc <= c
		else return true;
	}
	protected ByteCode parseAux(String string1, String string2) {
		
		if(string1.equalsIgnoreCase("IFLEQ")){
			return new IfLeq(Integer.parseInt(string2));
		}
		else return null;
	}

	@Override
	protected String toStringAux() {
		// TODO Auto-generated method stub
		return "IFLEQ";
	}

}
