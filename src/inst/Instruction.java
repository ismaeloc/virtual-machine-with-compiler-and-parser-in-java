package inst;

import elements.LexicalParser;
import exceptions.ArrayException;
import exceptions.LexicalAnalysisException;
import elements.Compiler;

public interface Instruction {
	
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws ArrayException, LexicalAnalysisException;
	public void compile(Compiler compiler) throws ArrayException;

}
