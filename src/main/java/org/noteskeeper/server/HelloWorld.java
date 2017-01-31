package org.noteskeeper.server;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/hello")
public class HelloWorld {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage(@QueryParam("name") String name) {
        if (name == null && name.isEmpty()) {
            return "Hello, Anonymous!";
        } else {
            return "Hello, " + name;
        }
    }
}
