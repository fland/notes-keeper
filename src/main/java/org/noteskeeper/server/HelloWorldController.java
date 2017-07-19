package org.noteskeeper.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/hello")
    public String getMessage(@RequestParam(required=false) String name) {
        return greetingService.greet(name);
    }
}
