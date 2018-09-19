package com.example.springmall.integration;

import com.example.springmall.bean.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductsTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void should_return_product_list_when_calling_get_product_list() {

        ResponseEntity<List<Product>> productListEntity =this.testRestTemplate.exchange(
                "/api/integration",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>(){}
                );
        assertThat(productListEntity.getStatusCode(), is(HttpStatus.OK));
        List<Product> productList = productListEntity.getBody();
        assertThat(productList.size(), is(2));
        Product product = productList.get(0);
        assertThat(product.getName(), is("可乐"));
        assertThat(product.getPrice(), is(450));
        assertThat(product.getUnit(), is("瓶"));
        assertThat(product.getTotalAmount(), is(10));
        assertThat(product.getImgUrl(), is("api/img/1"));

    }
}
