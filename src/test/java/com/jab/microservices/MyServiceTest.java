package com.jab.microservices;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyApplication.class}, webEnvironment = WebEnvironment.RANDOM_PORT)
class MyServiceTest {

    @InjectMocks
    private MyService service;
	
    @Test
    public void whenFindGreet() {
        String response = service.greet();
        Assert.assertNotNull(response);
    }

}
