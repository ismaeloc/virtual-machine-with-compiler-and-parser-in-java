package mv;

import exceptions.ArrayException;
import bc.ByteCode;

public class ByteCodeProgram {
	 private static final int MAX_INSTR = 100;
	 private ByteCode[] bcProgram;
	 private int numBc;
	 
	 public ByteCodeProgram(){
	 this.bcProgram = new ByteCode[ByteCodeProgram.MAX_INSTR];
	 this.numBc = 0;
	 }
	 
	 public boolean addBCInstruction(ByteCode instr, int pos) throws ArrayException {
		 
		 if (pos < 0) throw new ArrayException("Escritura fuera de rango."); 
		 else if(pos < MAX_INSTR){
			 this.bcProgram[pos] = instr;
			 this.numBc++;//al hacer replace acordarse de hacer numBC--
			 return true;
		 }
		 else {
			 throw new ArrayException("Array de bytecodes lleno."); 
		 }
}
	 public int getNumberOfByteCodes() {return this.numBc;}
	 
	 public ByteCode getByteCode(int i) {return this.bcProgram[i];}
	 public void reset() {this.numBc = 0; }
	 public void replace(int replace, ByteCode bc) {
		 this.bcProgram[replace] = bc;
	}
	 public String toString(int pos){
		 return bcProgram[pos].toString();
	 }
}