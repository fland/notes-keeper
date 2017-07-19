package org.noteskeeper.server;

/**
 * Created by ipetrenko on 7/14/17.
 */

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class HelloWorldControllerTest {

    @Autowired
    private HelloWorldController helloWorldController;
    @MockBean
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