package br.com.felipemcardoso.ddd.infrastructure.resource;

public interface ClassPathResourceReader {
	
	String asString(String fileLocationInClasspath);

}
