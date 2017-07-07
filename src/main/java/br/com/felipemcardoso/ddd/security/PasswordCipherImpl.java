package br.com.felipemcardoso.ddd.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class PasswordCipherImpl implements PasswordCipher {

	@Override
	public String cipher(String password) {
		MessageDigest algorithm = getAlgorithm();
		byte[] messageDigest = getBytes(password, algorithm);

		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}

		return hexString.toString();
	}

	private byte[] getBytes(String password, MessageDigest algorithm) {
		byte messageDigest[];
		try {
			messageDigest = algorithm.digest(password.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return messageDigest;
	}

	private MessageDigest getAlgorithm() {
		MessageDigest algorithm;
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		return algorithm;
	}

}
