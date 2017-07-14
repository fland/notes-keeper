package org.noteskeeper.server;

/**
 * Created by ipetrenko on 7/14/17.
 */

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class HelloWorldControllerTest {
    @Configuration
    static class HelloWorldControllerTestConfiguration {
        @Bean
        public GreetingService greetingService() {
            return Mockito.mock(GreetingServiceImpl.class);
        }
        @Bean
        public HelloWorldController helloWorldController() {
            return new HelloWorldController();
        }
    }

    @Autowired
    private HelloWorldController helloWorldController;
    @Autowired
    private GreetingService greetingServiceMock;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        Mockito.reset(greetingServiceMock);
        mockMvc = MockMvcBuilders.standaloneSetup(this.helloWorldController).build();
    }
    @Test
    public void greet_ShouldShowGreetingMessage() throws Exception {
        final String returnedValue = "someString";
        when(greetingServiceMock.greet(null)).thenReturn(returnedValue);

        this.mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(returnedValue));

        verify(greetingServiceMock).greet(null);
        verifyNoMoreInteractions(greetingServiceMock);
    }
}