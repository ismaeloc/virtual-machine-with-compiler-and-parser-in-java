package inst.conditionals;

import bc.jumps.Goto;
import elements.LexicalParser;
import exceptions.ArrayException;
import exceptions.LexicalAnalysisException;
import inst.Instruction;
import mv.ParsedProgram;
import elements.Compiler;


public class While implements Instruction {

	private Condition condition;
	private ParsedProgram body = new ParsedProgram();

	public While(Condition cd, ParsedProgram pP) {
		this.condition = cd;
		this.body = pP;
	}

	public While() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws ArrayException, LexicalAnalysisException{
		
		if (words.length == 4 && words[0].equalsIgnoreCase("while")) {
			this.condition = ConditionParser.parse(words[1], words[2], words[3], lexParser);
			if (this.condition != null) {
//Hemos quitado wb con new, creo que con body vale pa eso esta
				lexParser.increaseProgramCounter(); //creo que es 
				lexParser.lexicalParser(body,"ENDWHILE");
				lexParser.increaseProgramCounter();
				return new While(this.condition, body);
				}
			else return null;
			}
			else return null;
		}

	@Override
	public void compile(Compiler compiler) throws ArrayException{
		 int m = compiler.getSizeBcProgram();
		 this.condition.compile(compiler);
		 compiler.compile(this.body);
		 compiler.addByteCode(new Goto(m));
		 this.condition.setJump(compiler.getSizeBcProgram());

	}

}
