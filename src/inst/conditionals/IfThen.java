package inst.conditionals;

import elements.LexicalParser;
import exceptions.ArrayException;
import exceptions.LexicalAnalysisException;
import inst.Instruction;
import mv.ParsedProgram;
import elements.Compiler;

public class IfThen implements Instruction{
	
	private Condition condition;
	private ParsedProgram body = new ParsedProgram();

	public IfThen(Condition cd, ParsedProgram pP) {
		this.condition = cd;
		this.body = pP;
	}
	
	public IfThen(){
		
	}
	
	

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws ArrayException, LexicalAnalysisException {
		
		if (words.length == 4 && words[0].equalsIgnoreCase("if")) {
			this.condition = ConditionParser.parse(words[1], words[2], words[3], lexParser);
			if (this.condition != null) {
//Hemos quitado wb con new, creo que con body vale pa eso esta
				lexParser.increaseProgramCounter(); //creo que es 
				lexParser.lexicalParser(body,"ENDIF");
				lexParser.increaseProgramCounter();
				return new IfThen(this.condition, body);
				}
			else return null;
			}
			else return null;
		}

	

	@Override
	 public void compile(Compiler compiler) throws ArrayException{
		 this.condition.compile(compiler);
		 compiler.compile(this.body);
		 this.condition.setJump(compiler.getSizeBcProgram());
		 }

}
