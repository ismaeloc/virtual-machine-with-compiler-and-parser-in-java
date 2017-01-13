package inst;

import inst.assignments.CompoundAssignment;
import inst.assignments.SimpleAssignment;
import inst.assignments.Term;
import inst.conditionals.IfThen;
import inst.conditionals.While;
import elements.LexicalParser;
import exceptions.ArrayException;
import exceptions.LexicalAnalysisException;

public class InstructionParser {
	
	public InstructionParser(){
		
	}
	private final static Instruction[] instructions={
		 new SimpleAssignment(), new CompoundAssignment(),
		 new Write(), new Return(), new While(), new IfThen()};
	
	public static Instruction parse(String line, LexicalParser parser) throws ArrayException, LexicalAnalysisException{
		line = line.trim();
		String[] words = line.split(" +");
		Instruction instruction;
		
		for (Instruction inst : instructions) {
			instruction = inst.lexParse(words, parser);
			if (instruction != null)
				return instruction;
		}
		return null;
	}

}
