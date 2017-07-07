package br.com.felipemcardoso.ddd.security;

import javax.inject.Singleton;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.felipemcardoso.ddd.SegboxConstant;
import br.com.felipemcardoso.ddd.exception.SecurityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.felipemcardoso.ddd.exception.ErrorMessage;
import br.com.felipemcardoso.ddd.presentation.JsonType;

@Path("/login")
@Singleton
@Component
public class LoginController {

	@Autowired
	private IAuthenticationService authenticationService;

	private String encryptUserDescriptor(Token token) {
		String result = null;

		try {
			result = TokenService.encrypt(token.toJson());

		} catch (Exception e) {
			// this exception will be logged by the GenericExceptionMapper, so
			// it is not necessary to log it here
			throw new RuntimeException(e);
		}

		return result;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(@NotNull @Valid LoginCmd cmd) {

		try {

			Token token = authenticationService.authenticate(cmd.getEmail(), cmd.getPassword());

			String sessionId = encryptUserDescriptor(token);

			return Response.status(Response.Status.OK).header(SegboxConstant.ACCESS_TOKEN, sessionId).build();

		} catch (SecurityException e) {

			return Response.status(Response.Status.FORBIDDEN).header(SegboxConstant.ACCESS_TOKEN, "deleted")
					.type(JsonType.APPLICATION_JSON_UTF8).entity(new ErrorMessage(e.getMessage())).build();
		}
	}

}