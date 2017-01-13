package bc;

import bc.arithmetics.Add;
import bc.arithmetics.Div;
import bc.arithmetics.Mul;
import bc.arithmetics.Sub;
import bc.jumps.Goto;
import bc.jumps.conditionaljumps.IfEq;
import bc.jumps.conditionaljumps.IfLe;
import bc.jumps.conditionaljumps.IfLeq;
import bc.jumps.conditionaljumps.IfNeq;

public class ByteCodeParser {
	
	private final static ByteCode[] bcodes = {
		new Add(), new Sub(), new Mul(), new Div(), 
		new Out(), new Halt(), new Push(0), new Store(0), new Load(0), new Goto(0),
		new IfEq(0), new IfLe(0), new IfLeq(0), new IfNeq(0)
	};

	
	public static ByteCode parse(String line) {

		line = line.trim();
		String[] words = line.split(" +");
		
		boolean found = false;
		int i=0;
		ByteCode b = null;
		while (i < bcodes.length && !found){
		b = bcodes[i].parse(words);
		if (b!=null) found=true;
		 else i++;
		 }
		 return b;
		}
	}

