package br.com.felipemcardoso.ddd.infrastructure.resource;

import br.com.felipemcardoso.ddd.util.Assert;

public abstract class EmailResourceReader {

	private final String classPathResource;

	private final ClassPathResourceReader classPathResourceReader;

	protected final String resourceAsString;

	public EmailResourceReader(ClassPathResourceReader classPathResourceReader, String classPathResource) {
		Assert.notNull(classPathResourceReader, "O classPathResourceReader não pode ser null");
		Assert.isNotEmpytString(classPathResource, "O classPathResource não pode ser null ou string vazia");

		this.classPathResourceReader = classPathResourceReader;
		this.classPathResource = classPathResource;
		this.resourceAsString = this.classPathResourceReader.asString(this.classPathResource);
	}
	
	public abstract String getResourceAsStringFilled(String...values);

}
