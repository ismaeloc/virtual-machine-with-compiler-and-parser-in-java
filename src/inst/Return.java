package inst;

import bc.Halt;
import elements.LexicalParser;
import exceptions.ArrayException;
import elements.Compiler;

public class Return implements Instruction{
	public Return(){
		
	}
	
	public Instruction lexParse(String[] words, LexicalParser lexParser){
		if (words.length != 1) return null;
		else {
			if (!words[0].equalsIgnoreCase("return")) return null;
			else {
				lexParser.increaseProgramCounter();
				return new Return();
			}
		}
	}
	public void compile(Compiler compiler) throws ArrayException {
		compiler.addByteCode(new Halt());
	}
}
