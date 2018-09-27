package com.example.springmall.controller;


import com.example.springmall.bean.Product;
import com.example.springmall.controller.ProductController;
import com.example.springmall.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void should_return_product_list_when_get_product_list() throws Exception {
        given(productService.getProducts()).willReturn(getProducts());
        this.mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("可乐"))
                .andExpect(jsonPath("$[1].name").value("雪碧"));
    }

    private List<Product> getProducts() {
        ArrayList<Product> productList = new ArrayList<>();

        Product product = new Product();
        product.setName("可乐");
        product.setPrice(450);
        product.setUnit("瓶");
        product.setImgUrl("api/img/1");
        product.setTotalAmount(10);

        Product secondProduct = new Product();
        secondProduct.setName("雪碧");
        secondProduct.setPrice(450);
        secondProduct.setUnit("瓶");
        secondProduct.setImgUrl("api/img/1");
        secondProduct.setTotalAmount(10);

        productList.add(product);
        productList.add(secondProduct);

        return productList;
    }
}
