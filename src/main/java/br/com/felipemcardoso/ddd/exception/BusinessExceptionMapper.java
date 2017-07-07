package br.com.felipemcardoso.ddd.exception;

import br.com.felipemcardoso.ddd.presentation.JsonType;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {

    @Override
    public Response toResponse(BusinessException be) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorMessage(be.getMessage()))
                .type(JsonType.APPLICATION_JSON_UTF8).build();
    }
}
