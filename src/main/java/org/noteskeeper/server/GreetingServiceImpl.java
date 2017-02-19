package org.noteskeeper.server;

import org.springframework.stereotype.Service;

@Service("greetingService")
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String greet(String name){
        if (name == null || name.isEmpty()) {
            return "Hello, Anonymous";
        } else {
            return "Hello, " + name;
        }
    }
}
