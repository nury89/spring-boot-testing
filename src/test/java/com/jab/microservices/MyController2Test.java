package com.jab.microservices;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyApplication.class}, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class MyController2Test {

    @Autowired
    private MockMvc mockMvc;
	@MockBean
    private MyService service;
    private static final String URI_GET_GREETING = "/greeting";
	
    @Test
    public void whenGreetingThenReturn200OK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URI_GET_GREETING))
                .andExpect(status().is2xxSuccessful())
                .andReturn();
    }
    
    @Test
    public void whenGreetingServiceThenReturn200OK() throws Exception {
        Mockito.when(service.greet()).thenReturn("hola");
        mockMvc.perform(MockMvcRequestBuilders.get(URI_GET_GREETING))
                .andExpect(status().is2xxSuccessful())
                .andReturn();
    }

}
