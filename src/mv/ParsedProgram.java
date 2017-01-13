package mv;

import exceptions.ArrayException;
import inst.Instruction;


public class ParsedProgram{
	
	Instruction [] pProgram;
	int size;
	static final int MAX_P = 100;
	
	public ParsedProgram(){
		this.pProgram = new Instruction [MAX_P];
		this.size = 0;
	}
	
	public void addInst(Instruction ins) throws ArrayException{
		if(size >= MAX_P -1) throw new ArrayException("Programa demasiado grande, no cabe en memoria."
				+	System.getProperty("line.separator"));
			else if(size >= 0 && size < MAX_P -1) {
				this.pProgram[this.size] = ins;
				this.size++;
			}
			else {
				throw new ArrayException("Accediendo a posiciones incorrectas." + System.getProperty("line.separator"));
			}
	}
	
	public String toString(){ //mirar que hace
		return "";
	}
	
	public Instruction getInst(int k){
		return pProgram[k];
	}
	public int getSize(){
		return this.size;
	}
	public void reset(){
		this.size = 0;
	}

}
