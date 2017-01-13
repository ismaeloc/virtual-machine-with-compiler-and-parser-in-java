package exceptions;

public class DivByZeroException extends ExecutionErrorException {

	public DivByZeroException(String line) {
		super(line);
	}

}
