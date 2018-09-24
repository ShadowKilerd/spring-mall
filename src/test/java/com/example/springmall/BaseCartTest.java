package com.example.springmall;

import com.example.springmall.bean.Cart;
import com.example.springmall.controller.CartController;
import com.example.springmall.service.CartService;
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

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringMallApplication.class)
@WebMvcTest(CartController.class)
public abstract class BaseCartTest extends BaseTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartService cartService;

    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.mockMvc(mockMvc);
        given(cartService.getAll()).willReturn(getCartList());
    }

    private List<Cart> getCartList() {
        ArrayList<Cart> cartArrayList = new ArrayList<>();
        cartArrayList.add(Cart.builder().productId(1).quantity(10).build());
        cartArrayList.add(Cart.builder().productId(2).quantity(5).build());
        return cartArrayList;
    }
}
