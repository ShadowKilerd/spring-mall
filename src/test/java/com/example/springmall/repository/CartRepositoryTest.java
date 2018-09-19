package com.example.springmall.repository;

import com.example.springmall.bean.Cart;
import com.example.springmall.view.ProductView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CartRepositoryTest {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void should_add_to_database() {
        Cart cart = Cart.builder().productId(1).quantity(10).build();

        this.cartRepository.save(cart);
        // TODO: ? how to test it after saving
    }

    @Test
    public void should_return_all_cart() {
        List<Cart> carts = this.cartRepository.findAll();
        assertThat(carts.size(), is(2));
    }
}