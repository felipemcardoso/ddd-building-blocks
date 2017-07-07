package br.com.felipemcardoso.ddd.exception;

import br.com.felipemcardoso.ddd.presentation.JsonType;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class ValidationExceptionMappter implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .type(JsonType.APPLICATION_JSON_UTF8)
                .entity(new ErrorMessage(obterMessagem(e)))
                .build();
    }

    private String obterMessagem(ConstraintViolationException e) {

        StringBuilder message = new StringBuilder();

        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            message.append(violation.getMessage() + "\n\r");
        }

        return message.toString();
    }
}
