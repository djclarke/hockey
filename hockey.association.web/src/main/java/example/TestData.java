package example;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.sun.jersey.core.spi.factory.ResponseBuilderImpl;

@Path("/data")
public class TestData {

    @GET
    @Path("{path:.*}")
    @Produces(MediaType.TEXT_HTML)
    public Response getData(@Context UriInfo ui, @PathParam("path") String path, @CookieParam("test") Cookie cookie) {
        
        ResponseBuilder builder=new ResponseBuilderImpl();
        builder.entity(path + "::" + (cookie == null ? "" : cookie.getValue()+"-"+cookie.getVersion()));
        builder.status(Status.INTERNAL_SERVER_ERROR);
        builder.cookie(new NewCookie("test", System.currentTimeMillis()+"ms"));
        return builder.build();
    }
}