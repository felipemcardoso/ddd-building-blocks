package br.com.felipemcardoso.ddd.security;

public interface PasswordCipher {

	String cipher(String password);
}
