package br.com.felipemcardoso.ddd.security;

import br.com.felipemcardoso.ddd.SegboxConstant;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

/**
 * Created by felipe on 10/31/15.
 */
@Path("/logout")
@Singleton
@Component
public class LogoutController {

    @GET
    public Response logout() {
        NewCookie cookie = new NewCookie(SegboxConstant.ACCESS_TOKEN, "deleted");

        return Response.status(Response.Status.OK).cookie(cookie).build();
    }

}
