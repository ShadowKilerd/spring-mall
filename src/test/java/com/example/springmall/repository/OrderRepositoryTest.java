package com.example.springmall.repository;

import com.example.springmall.bean.Order;
import com.example.springmall.bean.OrderItem;
import com.example.springmall.bean.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void should_return_order_detail() {

        List<Product> products = productRepository.findAll();

        ArrayList<OrderItem> orderItems = new ArrayList<>();
        for(Product product: products){
            orderItems.add(OrderItem.builder().product(product).quantity(1).build());
        }
        Order order = Order.builder().userId(1).items(orderItems).build();
        Order savedOrder = this.orderRepository.save(order);

        Order fetchedOrder = this.testEntityManager.find(Order.class, savedOrder.getId());

        assertNotNull(fetchedOrder);
    }
}