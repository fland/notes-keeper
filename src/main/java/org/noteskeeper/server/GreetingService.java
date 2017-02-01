package org.noteskeeper.server;

public class GreetingService {

    public GreetingService(){}

    public String greet(String name){
        if (name == null && name.isEmpty()) {
            return "Hello, Anonymous!";
        } else {
            return "Hello, " + name;
        }
    }
}
