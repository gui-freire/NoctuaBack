package br.com.noctua.exceptions;

public class IncorrectPasswordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7677885421933294554L;
	
	public IncorrectPasswordException(String msgError) {
		super(msgError);
	}

}
