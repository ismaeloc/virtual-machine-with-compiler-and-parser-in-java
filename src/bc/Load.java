package bc;

import elements.CPU;

public class Load extends ByteCodeOneParameter {
	
	public Load (int j){
		super(j);
	}
	

	@Override
	protected String toStringAux() {
		// TODO Auto-generated method stub
		return "LOAD";
	}

	@Override
	public void execute(CPU cpu) {
		cpu.increaseProgramCounter();
		cpu.load(param);
	}
	protected ByteCode parseAux(String string1, String string2) {
		
		if(string1.equalsIgnoreCase("LOAD")){
			return new Load(Integer.parseInt(string2));
		}
		else return null;
	}

}
