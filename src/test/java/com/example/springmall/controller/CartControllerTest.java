package com.example.springmall.controller;

import com.example.springmall.bean.Cart;
import com.example.springmall.service.CartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CartController.class)
public class CartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartService cartService;

    @Test
    public void should_get_all_cart_when_add_product_to_cart() throws Exception {
        given(cartService.getAll()).willReturn(getCartList());
        this.mockMvc
                .perform(
                        post("/api/users/1/carts")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("[{\"productId\": 1, \"quantity\": 10},{\"productId\": 2, \"quantity\": 3}]")
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$[0].productId").value("1"))
                .andExpect(jsonPath("$[0].quantity").value("10"));
    }

    private List<Cart> getCartList() {
        ArrayList<Cart> cartArrayList = new ArrayList<>();
        cartArrayList.add(Cart.builder().productId(1).quantity(10).build());
        cartArrayList.add(Cart.builder().productId(2).quantity(5).build());
        return cartArrayList;
    }
}