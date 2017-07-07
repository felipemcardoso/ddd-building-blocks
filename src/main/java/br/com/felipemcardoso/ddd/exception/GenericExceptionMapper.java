package br.com.felipemcardoso.ddd.exception;

import br.com.felipemcardoso.ddd.SegboxConstant;
import br.com.felipemcardoso.ddd.presentation.JsonType;
import org.apache.log4j.Logger;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {

    static Logger logger = Logger.getLogger(GenericExceptionMapper.class);

    @Override
    public Response toResponse(Exception e) {

        logger.error(e.getMessage(), e);

        if (e instanceof ClientErrorException) {
            return ((ClientErrorException) e).getResponse();

        } if (e instanceof SecurityException) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .type(JsonType.APPLICATION_JSON_UTF8)
                    .entity(new ErrorMessage(e.getMessage()))
                    .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .type(JsonType.APPLICATION_JSON_UTF8)
                    .entity(new ErrorMessage(SegboxConstant.GENERIC_EXCEPTION + " " + e.getMessage()))
                    .build();
        }
    }
}
