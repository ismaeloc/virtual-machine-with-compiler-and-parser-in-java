package inst.assignments;

import bc.ByteCode;
import bc.Load;
import elements.Compiler;

public class Variable implements Term {
	
	private String varName;

	public Variable(String st) {
		this.varName = st;
	}

	@Override
	public Term parse(String term) {
		if (term.length() != 1) return null;
		else {
			char name = term.charAt(0);
			if ('a' <= name && name <= 'z') return new Variable(term);
			else return null;
		}
	}

	@Override
	public ByteCode compile(Compiler compiler) {
		
		ByteCode bc;
		int i = compiler.indexOf(varName);
		bc = new Load(i);
		return bc;
	}

	public String toString() {
		return varName;
	}

}
