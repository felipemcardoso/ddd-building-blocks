package br.com.felipemcardoso.ddd.security;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SecurityCatalog {

	private Map<Feature, List<Role>> byFeatures = new LinkedHashMap<Feature, List<Role>>();
	
	private Map<Role, List<Feature>> byRoles = new LinkedHashMap<>();

	public SecurityCatalog() {
	}

	public void addRoleToFeature(Role role, Feature feature) {

		byFeatures.putIfAbsent(feature, new ArrayList<>());		

		byFeatures.get(feature).add(role);

		byRoles.putIfAbsent(role, new ArrayList<>());
		
		byRoles.get(role).add(feature);
	}

	public boolean isAllowed(String role, Feature feature) {

		List<Role> roles = byFeatures.get(feature);

		if (roles != null && (roles.contains(new Role(role)) || roles.contains(Role.ALL) )) {
			return true;
		}

		return false;
	}
	
	public List<Feature> getFeatures(String role) {
		return byRoles.getOrDefault(new Role(role), new ArrayList<>());
	}
}