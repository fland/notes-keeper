package org.noteskeeper.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
@Path("/hello")
public class HelloWorld {

    @Autowired
    private  IGreetingService greetingService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage(@QueryParam("name") String name) {
        return greetingService.greet(name);
    }
}
