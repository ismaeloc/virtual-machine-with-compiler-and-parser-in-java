package mv;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import bc.ByteCode;
import bc.ByteCodeParser;
import cm.Command;
import cm.CommandParser;
import elements.CPU;
import elements.LexicalParser;
import exceptions.ArrayException;
import exceptions.BadFormatByteCodeException;
import exceptions.DivByZeroException;
import exceptions.ExecutionErrorException;
import exceptions.LexicalAnalysisException;
import exceptions.StackException;
import elements.Compiler;

public class Engine { 
	
	 private boolean end; // controla que no se ha ejecutado el comando QUIT
	 private static Scanner in = new Scanner(System.in);
	 
	 private SourceProgram sProgram;
	 private ParsedProgram pProgram;
	 private ByteCodeProgram bcProgram;
	 private Compiler compiler;

	 public Engine(){
	 this.bcProgram = new ByteCodeProgram();
	 this.sProgram = new SourceProgram();
	 this.pProgram = new ParsedProgram();
	 this.compiler = new Compiler();
	 this.end = false;
	 }
	 
	 void pruebas() throws FileNotFoundException, ArrayException, LexicalAnalysisException{
		 try{
			 load("a.txt");
			 this.executeCompile();
		 }catch(ArrayException e){
			 System.out.println(e.getMessage());
		 }catch(LexicalAnalysisException e){
			 System.out.println(e.getMessage());
		 }
		 
		 
	 }
	 
	 public void start() throws FileNotFoundException, ArrayException, StackException, DivByZeroException, LexicalAnalysisException, BadFormatByteCodeException, ExecutionErrorException{
		 this.end = false;
		 String line = "";
		 while (!end) {
			 
			 load("arch.txt");
			 //Generado el SourceProgram
			 
			 //Hay que parsear a ParsedProgram
			 /*    */
			 System.out.print("> ");

		 Command command = null;
		 line = in.nextLine();
		 command = CommandParser.parse(line);
		 if (command == null) System.out.println("Error: Comando incorrecto.");
		 else {
		System.out.println("Comienza la ejecución de " + command.toString()); 
		 command.execute(this);
		 if(bcProgram.getNumberOfByteCodes() != 0){
			 for(int i = 0; i < bcProgram.getNumberOfByteCodes(); i++){
				 System.out.println(i + ": " + bcProgram.toString(i));
			 }
			 System.out.print(System.getProperty("line.separator"));
		 	}
		 }
		}
		 System.out.println("Fin de la ejecución....");
			in.close();
	 }
		 
		 public boolean executeCommandRun() throws StackException, DivByZeroException {
			 CPU cpu = new CPU(this.bcProgram);
			 return cpu.run();
			}
		 
	 public static boolean showHelp() {
		 CommandParser.showHelp();
		return true;
	 }
	 public boolean endExecution() { this.end = true; return end;}
	 public boolean addByteCodeInstruction(ByteCode bc, int pos) throws ArrayException {
		 return bcProgram.addBCInstruction(bc, pos);
	 }
	 public boolean resetProgram() {
		 this.bcProgram = new ByteCodeProgram();
		 return true;
	 }
	 public void replaceByteCode(int replace) throws BadFormatByteCodeException, ArrayException {
		 
		 
		 if(replace >= 0 && replace < bcProgram.getNumberOfByteCodes()){
			 String line;
			 ByteCode aux;
			 System.out.print("Nueva instrucción:" + System.getProperty("line.separator") + "> ");
			 line = in.nextLine();
			 aux = ByteCodeParser.parse(line);
			 if(aux != null){
			 bcProgram.replace(replace, aux);
			 }
			 else {
				 throw new BadFormatByteCodeException("Replace con bytecode incorrecto.");
			 }
		 }
		 else throw new ArrayException("Posicion no válida del array de bytecodes.");
	 }

	 public boolean readByteCodeProgram() throws ArrayException{
		 String line = "";
		 ByteCode bcode;
		 
		 do{
			 line = in.nextLine();
			 bcode = ByteCodeParser.parse(line);
			 if(bcode != null){
				 if(!this.addByteCodeInstruction(bcode, 0)){ //HE METIDO UN 0
					System.out.println("No hay memoria para el programa.");
					return true; //No cabe mas, pero lo que has metido hasta ahora esta bien.
				 }
			 }
			 else if(!line.equalsIgnoreCase("END")){
				 System.out.println("Instruccion incorrecta.");
			 }
		 }while(!line.equalsIgnoreCase("END"));
		
		 return true;
	 }
	 
	 public void load(String fichName) throws FileNotFoundException, ArrayException{
		 
		 String line;
		 
		 try{
			 Scanner sc = new Scanner(new File(fichName));
			 while(sc.hasNextLine()){
				 line = sc.nextLine(); 
				 sProgram.addInst(line);
			 }
			 
			 sc.close();
		 }
		 catch (FileNotFoundException e){
			 System.out.println("Archivo no encontrado.");
		 }
		 catch (ArrayException e){
			 throw new ArrayException("hola" + e.getMessage());
		 }
	 }
	 private void lexicalAnalysis() throws ArrayException, LexicalAnalysisException{
		 LexicalParser parser = new LexicalParser();
		 parser.initialite(sProgram);
		 try{
			 parser.lexicalParser(pProgram, "end");
		 }catch (ArrayException e){
			 throw new ArrayException("hola" + e.getMessage());
		 }catch(LexicalAnalysisException e){
			 System.out.println(e.toString()); //hacer throw
		 }
		 
	 }
	 public void executeCompile() throws LexicalAnalysisException, ArrayException{
		 try {
		 this.lexicalAnalysis();
		 this.generateByteCode();
		 }catch (LexicalAnalysisException e){
			 System.out.println(e.getMessage());
		 }catch(ArrayException e){
			 System.out.println(e.getMessage());
		 }
		 
	 }

	private void generateByteCode() throws ArrayException {
		this.compiler.initialize(bcProgram);
		this.compiler.compile(this.pProgram);
	}
	}