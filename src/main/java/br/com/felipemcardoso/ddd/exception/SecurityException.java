package br.com.felipemcardoso.ddd.exception;

public class SecurityException extends SegboxException {

	private static final long serialVersionUID = -7653288931731662069L;
	
	public SecurityException(String message) {
		super(message);
	}

}
