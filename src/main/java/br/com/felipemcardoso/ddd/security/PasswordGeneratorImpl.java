package br.com.felipemcardoso.ddd.security;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class PasswordGeneratorImpl implements PasswordGenerator {

	private static final int LENGTH = 6;

	private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	@Override
	public String generate() {
		char[] password = new char[LENGTH];

		Random random = new Random();

		for (int i = 0; i < LENGTH; i++) {
			if (random.nextBoolean()) {
				int c = random.nextInt(2 * LENGTH);
				password[i] = CHARS.charAt(c);
			} else {
				password[i] = Character.forDigit(random.nextInt(10), 10);
			}

		}

		return new String(password);
	}

}
