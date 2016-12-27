package com.dudream.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by dudream on 2016/12/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void dataTest() {
        String resp = this.restTemplate.getForObject("/data/user?userId=10", String.class);

        System.out.println(resp);
    }

    @Test
    public void webTest() {
        String resp = this.restTemplate.getForObject("/web/index", String.class);

        System.out.println(resp);
    }

}
