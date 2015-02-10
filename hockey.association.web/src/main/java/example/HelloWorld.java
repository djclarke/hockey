package example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorld {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello(@QueryParam("name") String name, @PathParam("path") String path) {
        return "Hello, " + name;
    }
}