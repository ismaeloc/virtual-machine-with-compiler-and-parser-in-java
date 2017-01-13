package mv;

import exceptions.ArrayException;

public class SourceProgram {
	String [] source;
	int size;
	public final int MAX_SC = 100;
	
	public SourceProgram(){
		this.source = new String[MAX_SC];
		this.size = 0;
	}
	public String getInst(int k){ 
		return source[k];
	}
	public int getSize(){
		return this.size;
	}
	public void reset(){
		this.size = 0;
	}
	public void addInst(String ins) throws ArrayException{
		if(size >= MAX_SC -1) throw new ArrayException("Programa demasiado grande, no cabe en memoria."
			+	System.getProperty("line.separator"));
		else if(size >= 0 && size < MAX_SC -1) {
			this.source[this.size] = ins;
			this.size++;
		}
		else {
			throw new ArrayException("Accediendo a posiciones incorrectas." + System.getProperty("line.separator"));
		}
	}

	public String toString(){ //mirar que hace
		return "";
	}
}
