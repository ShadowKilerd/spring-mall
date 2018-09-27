package com.example.springmall.integration;

import com.example.springmall.bean.Order;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderTest {
    
    @Autowired
    private TestRestTemplate testRestTemplate;
    
    @Autowired
    private Flyway flyway;

    @Before
    public void setUp() throws Exception {
        flyway.clean();
        flyway.migrate();
    }

    @Test
    @Ignore
    public void should_return_201_and_order_detail_when_creating_order() {

        ResponseEntity<Order> response = this.testRestTemplate.postForEntity(
                "/users/1/orders",
                null,
                Order.class
        );

        assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
        Order order = response.getBody();
        assertThat(order.getId(), is(1));

    }
}
