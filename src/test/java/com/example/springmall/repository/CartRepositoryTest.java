package com.example.springmall.repository;

import com.example.springmall.bean.Cart;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CartRepositoryTest {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void should_add_to_database() {
        Cart cart = Cart.builder().productId(1).quantity(10).build();

        Cart savedCart = this.cartRepository.save(cart);
        Cart fetchedCart = testEntityManager.find(Cart.class, savedCart.getId());
        assertThat(fetchedCart, notNullValue());
    }

    @Test
    @Ignore
    public void should_return_all_cart() {
        testEntityManager.persist(Cart.builder().productId(1).quantity(1).build());
        List<Cart> carts = this.cartRepository.findAll();
        assertThat(carts.size(), is(1));
    }
}