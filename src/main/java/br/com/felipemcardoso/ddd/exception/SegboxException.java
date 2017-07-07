package br.com.felipemcardoso.ddd.exception;

/**
 * Exceção genérica do segbox.
 * <p>
 */
public class SegboxException extends RuntimeException {

    private static final long serialVersionUID = -4056610325442377275L;

	public SegboxException(String message) {
        super(message);
    }
}
