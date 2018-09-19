package com.example.springmall.service;

import com.example.springmall.bean.Cart;
import com.example.springmall.repository.CartRepository;
import com.example.springmall.view.ProductView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CartServiceTest {

    @InjectMocks
    private CartService cartService;

    @Mock
    private CartRepository cartRepository;

    @Test
    public void should_add_products_to_cart() {
        ArrayList<ProductView> productViews = new ArrayList<>();
        this.cartService.add(productViews);

        verify(cartRepository, times(1)).add(productViews);
    }

    @Test
    public void should_return_all_cart() {
        given(this.cartRepository.findAll()).willReturn(getCarts());
        List<Cart> carts = this.cartService.getAll();
        assertThat(carts.size(), is(2));
        assertThat(carts.get(0).getProductId(), is(1));
    }

    private List<Cart> getCarts() {
        ArrayList<Cart> cartArrayList = new ArrayList<>();
        cartArrayList.add(Cart.builder().productId(1).quantity(10).build());
        cartArrayList.add(Cart.builder().productId(2).quantity(3).build());

        return cartArrayList;
    }
}