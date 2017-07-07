package br.com.felipemcardoso.ddd.infrastructure.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ClassPathResourceReaderImpl implements ClassPathResourceReader {

	private static final int BUFFER_SIZE = 1024;

	private static final Logger LOGGER = Logger.getLogger(ClassPathResourceReaderImpl.class.getName());

	@Override
	public String asString(String fileLocationInClasspath) {

		try (

				BufferedReader br = new BufferedReader(
						new InputStreamReader(new ClassPathResource(fileLocationInClasspath).getInputStream()),
						BUFFER_SIZE)

        ) {

			StringBuilder stringBuilder = new StringBuilder();

			String line;
			while ((line = br.readLine()) != null) {
				stringBuilder.append(line).append('\n');
			}

			return stringBuilder.toString();

		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			throw new RuntimeException(e);
		}

	}

}
