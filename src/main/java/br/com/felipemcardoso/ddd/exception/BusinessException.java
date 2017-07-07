package br.com.felipemcardoso.ddd.exception;

/**
 * Exceção de negócio.
 * <p>
 * Created by felipe on 3/28/15.
 */
public class BusinessException extends SegboxException {

    private static final long serialVersionUID = 1298434071930220516L;

	public BusinessException(String message) {
        super(message);
    }
}
