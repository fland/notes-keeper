package org.noteskeeper.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/api")
public class HelloWorldController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping(path="/hello")
    public @ResponseBody String getMessage(@RequestParam(required=false) String name) {
        return greetingService.greet(name);
    }
}
