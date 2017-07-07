package br.com.felipemcardoso.ddd.exception;

public class InactiveSubscriptionException extends SecurityException {

	private static final long serialVersionUID = 9200926967482525130L;

	public InactiveSubscriptionException() {
		super("Assiantura inativa");
	}

}
