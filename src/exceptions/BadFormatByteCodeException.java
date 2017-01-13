package exceptions;

public class BadFormatByteCodeException extends Exception {
	public BadFormatByteCodeException(String line){
		super(line);
	}

}
