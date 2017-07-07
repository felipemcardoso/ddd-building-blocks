package br.com.felipemcardoso.ddd.security;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.annotation.PostConstruct;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class SecurityCatalogLoader {

	@Autowired
	private FeatureHelper featureHelper;

	private SecurityCatalog securityCatalog;

	public SecurityCatalog getSecurityCatalog() {
		return securityCatalog;
	}

	@PostConstruct
	public void load() throws IOException, ParseException, ClassNotFoundException {

		ClassPathResource resource = new ClassPathResource("security.catalog.json");

		try (InputStreamReader inputStreamReader = new InputStreamReader(resource.getInputStream())) {

			JSONParser parser = new JSONParser();

			JSONObject jsonObject = (JSONObject) parser.parse(inputStreamReader);

			securityCatalog = new SecurityCatalog();

			JSONArray features = (JSONArray) jsonObject.get("features");

			for (int i = 0; i < features.size(); i++) {

				JSONObject featureObject = (JSONObject) features.get(i);

				String featureName = (String) featureObject.get("feature");

				Feature feature = featureHelper.getFeature(featureName);

				JSONArray roles = (JSONArray) featureObject.get("roles");

				for (int j = 0; j < roles.size(); j++) {

					securityCatalog.addRoleToFeature(new Role((String) roles.get(j)), feature);

				}

			}
		}

	}
}
