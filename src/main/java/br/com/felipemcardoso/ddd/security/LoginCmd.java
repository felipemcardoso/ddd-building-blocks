package br.com.felipemcardoso.ddd.security;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class LoginCmd {

	@Email(message = "{login.email.invalid}")
	private String email;

	@NotNull(message = "{login.password.empty}")
	private String password;

	public LoginCmd() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}