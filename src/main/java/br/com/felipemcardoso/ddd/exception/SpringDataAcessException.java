package br.com.felipemcardoso.ddd.exception;

import br.com.felipemcardoso.ddd.SegboxConstant;
import br.com.felipemcardoso.ddd.presentation.JsonType;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class SpringDataAcessException implements ExceptionMapper<DataAccessException> {

    @Override
    public Response toResponse(DataAccessException e) {

        if (e instanceof DuplicateKeyException) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorMessage(SegboxConstant.DUPLICATE_KEY))
                    .type(JsonType.APPLICATION_JSON_UTF8)
                    .build();
        }

        if (e instanceof DataIntegrityViolationException) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorMessage(SegboxConstant.INTEGRITY_EXCEPTION))
                    .type(JsonType.APPLICATION_JSON_UTF8)
                    .build();
        }

        if (e instanceof EmptyResultDataAccessException) {
            return Response.status(Response.Status.NOT_FOUND)
                    .type(JsonType.APPLICATION_JSON_UTF8)
                    .entity(new ErrorMessage(SegboxConstant.RECORD_NOT_FOUND))
                    .build();
        }

        return Response.status(Response.Status.BAD_REQUEST)
                .type(JsonType.APPLICATION_JSON_UTF8)
                .entity(new ErrorMessage(e.getMessage()))
                .build();
    }
}
