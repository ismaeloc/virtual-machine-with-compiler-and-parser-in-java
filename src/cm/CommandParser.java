package cm;

public class CommandParser {

	private final static Command[] commands = {
		new Help(), new Quit(), new Reset(),
		new Replace(0), new Run(), new AddByteCodeProgram() };


	public static Command parse(String line) {
		line = line.trim();
		String[] words = line.split(" +");
		
		boolean found = false;
		 int i=0;
		 Command c = null;
		 while (i < commands.length && !found){
		 c = commands[i].parse(words);
		 if (c!=null) found=true;
		 else i++;
		 }
		 return c;
		
	}
	
	public static void showHelp(){
		String s = "";
		
		for(int i = 0; i < commands.length; i++) s+= commands[i].textHelp();
		System.out.println(s);
	}
	
}