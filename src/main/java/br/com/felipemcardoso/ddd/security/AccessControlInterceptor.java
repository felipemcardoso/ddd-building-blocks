package br.com.felipemcardoso.ddd.security;

import java.io.Serializable;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.felipemcardoso.ddd.exception.PermissionDeniedException;

@Aspect
@Component
public class AccessControlInterceptor implements Serializable {

	private static final long serialVersionUID = 5184652299877122018L;

	@Autowired
	private SecurityCatalogLoader catalogComponent;

	@Before(" execution(@AccessControl public * *(..)) && @annotation(acessControl) "
			+ " && @within(org.springframework.stereotype.Service)) ")
	public void interceptAccessControlCall(AccessControl acessControl) throws Throwable {

		TokenDescriptor tokenDescriptor = SessionContext.descriptor();

		if (tokenDescriptor != null && tokenDescriptor.getToken() != null) {

			Token token = tokenDescriptor.getToken();

			for (Class<? extends Feature> featureClass : acessControl.value()) {
				
				Feature feature = featureClass.newInstance();
				
				boolean allowed = catalogComponent.getSecurityCatalog().isAllowed(token.getPerfil(), feature);

				if (!allowed) {
					throw new PermissionDeniedException(feature.getName());
				}
			}
		}
	}

}