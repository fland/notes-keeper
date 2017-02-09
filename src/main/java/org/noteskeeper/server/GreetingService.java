package org.noteskeeper.server;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("greetingService")
@Transactional
public class GreetingService implements IGreetingService{

    public GreetingService(){}

    @Override
    public String greet(String name){
        if (name == null || name.isEmpty()) {
            return "Hello, Anonymous";
        } else {
            return "Hello, " + name;
        }
    }
}
