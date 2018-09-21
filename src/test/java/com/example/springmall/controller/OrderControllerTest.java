package com.example.springmall.controller;

import com.example.springmall.bean.Cart;
import com.example.springmall.bean.Order;
import com.example.springmall.bean.Product;
import com.example.springmall.service.CartService;
import com.example.springmall.service.OrderService;
import com.example.springmall.service.ProductService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @MockBean
    private CartService cartService;

    @MockBean
    private ProductService productService;

    @Test
    @Ignore
    public void should_return_order_detail() throws Exception {
        List<Cart> cartList = getCartList();
        Cart cart = cartList.get(0);

        given(cartService.getAll()).willReturn(cartList);
        // TODO: why i cant use findById(any()) here ?
        when(productService.findById(cart.getId())).thenReturn(getFakeProduct());
        Order order = Order.builder().id(1).build();
        given(orderService.create(any())).willReturn(order);


        this.mockMvc.perform(
                post("/api/users/1/orders")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.totalAmount").value("100"));
    }

    private Product getFakeProduct() {
        return Product.builder().id(1).name("可乐").price(450).unit("瓶").imgUrl("api/img/1").build();
    }

    private List<Cart> getCartList() {
        ArrayList<Cart> cartArrayList = new ArrayList<>();
        cartArrayList.add(Cart.builder().id(1).productId(1).quantity(10).build());
        return cartArrayList;
    }
}