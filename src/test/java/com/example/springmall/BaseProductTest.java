package com.example.springmall;

import com.example.springmall.bean.Product;
import com.example.springmall.controller.ProductController;
import com.example.springmall.service.ProductService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@WebMvcTest(ProductController.class)
public abstract class BaseProductTest extends BaseTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.mockMvc(mockMvc);
        given(productService.getProducts()).willReturn(getProducts());


    }

    private List<Product> getProducts() {
        ArrayList<Product> productList = new ArrayList<>();

        Product product = new Product();
        product.setId(1);
        product.setName("可乐");
        product.setPrice(450);
        product.setUnit("瓶");
        product.setImgUrl("api/img/1");
        product.setTotalAmount(10);

        Product secondProduct = new Product();
        secondProduct.setId(2);
        secondProduct.setName("雪碧");
        secondProduct.setPrice(450);
        secondProduct.setUnit("瓶");
        secondProduct.setImgUrl("api/img/2");
        secondProduct.setTotalAmount(5);

        productList.add(product);
        productList.add(secondProduct);

        return productList;
    }
}
