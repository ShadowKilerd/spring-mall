package com.example.springmall.service;

import com.example.springmall.bean.Product;
import com.example.springmall.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void should_get_product_list() {

        given(productRepository.findAll()).willReturn(getProducts());

        List<Product> products = this.productService.getProducts();
        assertThat(products.size(), is(2));
        Product product = products.get(0);
        assertThat(product.getName(), is("可乐"));
        assertThat(product.getPrice(), is(450));


    }

    private List<Product> getProducts() {
        ArrayList<Product> productList = new ArrayList<>();
        Product product = new Product();
        product.setName("可乐");
        product.setPrice(450);
        productList.add(product);
        productList.add(new Product());
        return productList;
    }
}