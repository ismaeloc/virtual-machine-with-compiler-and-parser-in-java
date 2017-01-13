package cm;

import exceptions.ArrayException;
import exceptions.BadFormatByteCodeException;
import exceptions.DivByZeroException;
import exceptions.ExecutionErrorException;
import exceptions.LexicalAnalysisException;
import exceptions.StackException;
import mv.Engine;

public interface Command { 

	 abstract public String textHelp();
	 abstract public void execute(Engine engine) throws java.io.FileNotFoundException,
     LexicalAnalysisException,
     ArrayException,
     BadFormatByteCodeException,
     StackException,
     DivByZeroException,
     ExecutionErrorException;
	 abstract public Command parse(String[] s);

	}