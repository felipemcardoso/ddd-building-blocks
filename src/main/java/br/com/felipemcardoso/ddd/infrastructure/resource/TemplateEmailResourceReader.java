package br.com.felipemcardoso.ddd.infrastructure.resource;

import java.util.List;

import br.com.felipemcardoso.ddd.query.QueryModel;
import br.com.felipemcardoso.ddd.util.Assert;

public abstract class TemplateEmailResourceReader<T extends QueryModel> {

	private static final String TBODY = "{{TBODY}}";

	private final String classPathResource;

	private final ClassPathResourceReader classPathResourceReader;

	private String resourceAsString;

	public TemplateEmailResourceReader(ClassPathResourceReader classPathResourceReader, String classPathResource) {
		Assert.notNull(classPathResourceReader, "O classPathResourceReader não pode ser null");
		Assert.isNotEmpytString(classPathResource, "O classPathResource não pode ser null ou string vazia");

		this.classPathResourceReader = classPathResourceReader;
		this.classPathResource = classPathResource;
		this.resourceAsString = this.classPathResourceReader.asString(this.classPathResource);

		if (!this.resourceAsString.contains(TBODY)) {
			throw new IllegalArgumentException("O resource " + classPathResource + " deve conter a substring " + TBODY);
		}
	}

	public String getResourceAsStringFilled(List<T> dtos) {

		String emailBody = dtoToString(dtos);

		return resourceAsString.replace(TBODY, emailBody);
	}

	protected abstract String dtoToString(List<T> dtos);

}
