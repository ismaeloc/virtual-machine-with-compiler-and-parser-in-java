package elements;
import exceptions.ArrayException;
import exceptions.LexicalAnalysisException;
import mv.ParsedProgram;
import mv.SourceProgram;
import inst.Instruction;
import inst.InstructionParser;

public class LexicalParser {
	
	private SourceProgram sProgram;
	private int programCounter;
	
	public void initialite(SourceProgram sProgram){
		this.programCounter = 0;
		this.sProgram = sProgram;
	}


	public void lexicalParser(ParsedProgram pProgram, String stopKey) throws ArrayException, LexicalAnalysisException{
		
		int numProgram = sProgram.getSize();
		boolean stop = false;
		
		while(programCounter < numProgram && !stop){
			String line =  sProgram.getInst((programCounter));
			

			if (line.equalsIgnoreCase(stopKey)) stop = true;
			else {
				
				Instruction instruction = InstructionParser.parse(line,this);
				if(instruction != null) pProgram.addInst(instruction);
				else {
					throw new LexicalAnalysisException("Instrucción incorrecta.");
				}
			
			}
		}
	}
	public void increaseProgramCounter(){
		this.programCounter++;
	}
	public int getPC(){
		return this.programCounter;
	}
	public String getSourceLine(){
		return sProgram.getInst((programCounter));
	}
}
