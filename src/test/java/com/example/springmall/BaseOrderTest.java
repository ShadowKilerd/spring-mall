package com.example.springmall;

import com.example.springmall.bean.Cart;
import com.example.springmall.bean.Order;
import com.example.springmall.bean.Product;
import com.example.springmall.controller.OrderController;
import com.example.springmall.controller.ProductController;
import com.example.springmall.service.CartService;
import com.example.springmall.service.OrderService;
import com.example.springmall.service.ProductService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringMallApplication.class)
@WebMvcTest(OrderController.class)
public abstract class BaseOrderTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @MockBean
    private ProductService productService;

    @MockBean
    private CartService cartService;

    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.mockMvc(mockMvc);
        List<Cart> cartList = getCartList();
        Cart cart = cartList.get(0);

        given(cartService.getAll()).willReturn(cartList);
        when(productService.findById(cart.getId())).thenReturn(getFakeProduct());
        Order order = Order.builder().id(1).build();
        given(orderService.create(any())).willReturn(order);


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
