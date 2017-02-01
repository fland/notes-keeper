package org.noteskeeper.server;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/hello")
public class HelloWorld {
    GreetingService greetingService = new GreetingService();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage(@QueryParam("name") String name) {
        return greetingService.greet(name);
    }
}
