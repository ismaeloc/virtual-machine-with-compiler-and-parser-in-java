package exceptions;

public class LexicalAnalysisException extends Exception {
	private String line;
	
	public LexicalAnalysisException(String line){
		this.line = line;
	
	}
	public String toString(){
		return line;
	}
}
