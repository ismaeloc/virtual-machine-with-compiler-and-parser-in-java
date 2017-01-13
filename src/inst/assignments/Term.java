package inst.assignments;

import bc.ByteCode;
import elements.Compiler;

public interface Term {
	 Term parse(String term);
	 ByteCode compile(elements.Compiler compiler);
}
