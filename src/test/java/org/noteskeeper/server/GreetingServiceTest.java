package org.noteskeeper.server;

/**
 * Created by ioan1 on 2/5/2017.
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GreetingServiceTest {

    private GreetingService service = new GreetingService();

    @Test
    public void greetGreetsAnonymousWhenPassedNullOrEmptyName() {
        String expectedGreeting = "Hello, Anonymous";
        assertEquals(expectedGreeting, service.greet(null));
        assertEquals(expectedGreeting, service.greet(""));
    }

    @Test
    public void greetGreetsUserWhenPassedName() {
        String expectedGreeting = "Hello, Ivan";
        assertEquals(expectedGreeting, service.greet("Ivan"));
    }
}