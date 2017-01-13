package exceptions;

public class ExecutionErrorException extends Exception {

	public ExecutionErrorException(String line){
		super(line);
	}

}
