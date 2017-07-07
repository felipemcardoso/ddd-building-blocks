package br.com.felipemcardoso.ddd.exception;

public class InvalidLoginExcpetion extends SecurityException {

	private static final long serialVersionUID = 4181230663584288569L;
	
	public InvalidLoginExcpetion() {
		super("Dados inválidos");		
	}

}
