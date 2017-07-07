package br.com.felipemcardoso.ddd.security;

import br.com.felipemcardoso.ddd.SegboxConstant;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.io.IOException;

public class AuthenticationRequestFilter implements ContainerRequestFilter {

	static Logger log = Logger.getLogger(AuthenticationRequestFilter.class.getName());

	private static final String LOGIN = "/login";

	private static final String REDEFINIR_SENHA = "/senha";

	private static final String LOGOUT = "/logout";

    private static final String HEALTH = "/health";

	private static final String ASSINATURA = "/assinatura";

	private static final String ASSINATURA_SEGURADORA = "/assinatura/seguradora";
	
	private static final String ASSINATURA_CONFIRMACAO = "/assinatura/confirmacao";

	@Context
	private HttpServletRequest httpServletRequest;

	@Context
	private HttpServletResponse httpServletResponse;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		String path = httpServletRequest.getPathInfo();
		String method = httpServletRequest.getMethod();

		boolean securedUrl = !LOGIN.equals(path) && !LOGOUT.equals(path) && !REDEFINIR_SENHA.equals(path)
				&& !HEALTH.equals(path) && !ASSINATURA.equals(path) && !ASSINATURA_SEGURADORA.equals(path)
				&& !ASSINATURA_CONFIRMACAO.equals(path) && !HttpMethod.OPTIONS.equals(method);

		if (securedUrl) {
			String sessionId = extractSessionId(httpServletRequest);

			if (sessionId == null || !validateSession(sessionId)) {

				httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN, SegboxConstant.UNAUTHORIZED_ACCESS);

				requestContext.abortWith(
						Response.status(Response.Status.FORBIDDEN).entity(SegboxConstant.UNAUTHORIZED_ACCESS).build());

			}
		}

	}

	private boolean validateSession(String sessionId) {
		try {
			String tokenJson = TokenService.decrypt(sessionId);

			// TODO validar tempo e origem

			Token token = Token.fromJson(tokenJson);
			SessionContext.set(new TokenDescriptor(token, sessionId));

			return true;

		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return false;
	}

	private String extractSessionId(HttpServletRequest request) {
		String content = request.getHeader(SegboxConstant.ACCESS_TOKEN);

		if (content != null && content.length() > 2) {
			content = content.substring(1, content.length() - 1);

			return content;
		}

		return null;
	}
}