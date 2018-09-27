package com.example.springmall.integration;

import com.example.springmall.view.ProductView;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CartTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    public Flyway flyway;

    @Before
    public void setUp() throws Exception {
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void should_return_201_when_add_products_into_cart() {

        List<ProductView> productViewList = new ArrayList<>();
        productViewList.add(new ProductView(1, 10));
        productViewList.add(new ProductView(2, 10));

        ResponseEntity<String> response = this.testRestTemplate
                .postForEntity("/users/1/carts", productViewList, String.class);
        assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
    }
}

