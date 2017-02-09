package org.noteskeeper.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorld {

    @Autowired
    private  IGreetingService greetingService ;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage(@QueryParam("name") String name) {
        System.out.println("============================================name "+  name);
        return greetingService.greet(name);
    }
}
