package br.com.felipemcardoso.ddd.exception;

public class PermissionDeniedException extends SecurityException {

	private static final long serialVersionUID = -2907866959558987411L;

	public PermissionDeniedException(String feature) {
		super("Usuário sem permissão na funcionalidade " + feature);
	}

}
