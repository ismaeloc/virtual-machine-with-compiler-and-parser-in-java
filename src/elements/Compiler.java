package elements;

import bc.ByteCode;
import exceptions.ArrayException;
import inst.Instruction;
import mv.ByteCodeProgram;
import mv.ParsedProgram;

public class Compiler {
	
	 private ByteCodeProgram bcProgram;
	 private String[] varTable;
	 private int numVars;
	 
	 public void compile(ParsedProgram pProgram) throws ArrayException{
		 int i = 0;
		 
		 try{
			 while(i < pProgram.getSize()){
				 Instruction inst = pProgram.getInst(i);
				 inst.compile(this);
				 i++;
			 }
		 }catch(ArrayException e){
			 throw new ArrayException("Fallo producido en la linea " + i + " ");
		 }

	 }

	public int getSizeBcProgram(){

		return this.bcProgram.getNumberOfByteCodes();
	}
	
	public int indexOf(String varName){
		
		int i = 0;
		
		while(i < numVars){
			if (varName.equals(varTable[i])){
				return i;	
			}
			i++;
		}
		this.varTable[numVars] = varName;
		this.numVars++;
		
		return i;
	} 
	
	 public void addByteCode(ByteCode bc) throws ArrayException{
		try{
			this.bcProgram.addBCInstruction(bc, this.getSizeBcProgram());
		}catch(ArrayException e){
			throw new ArrayException(e.getMessage());
		}
	 }
	 public int getVariable(int i){
		 return 9;
	 }
	 public void initialize(ByteCodeProgram bcProgram){
		 this.bcProgram = bcProgram;
		 this.numVars = 0;
		 this.varTable = new String[100];
	 }
	 
}
