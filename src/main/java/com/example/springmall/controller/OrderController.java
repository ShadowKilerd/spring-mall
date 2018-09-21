package com.example.springmall.controller;


import com.example.springmall.bean.Cart;
import com.example.springmall.bean.Order;
import com.example.springmall.bean.OrderItem;
import com.example.springmall.bean.Product;
import com.example.springmall.service.CartService;
import com.example.springmall.service.OrderService;
import com.example.springmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/orders")
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Order> create_order(
            @PathVariable int userId
    ) {

        List<Cart> carts = cartService.getAll();

        ArrayList<OrderItem> orderItems = new ArrayList<>();

        for (Cart cart : carts) {
            orderItems.add(
                    OrderItem
                            .builder()
                            .product(productService.findById(cart.getProductId()))
                            .quantity(cart.getQuantity())
                            .build()
            );
        }

        Product product = this.productService.findByValue();

        Order order = this.orderService.create(orderItems);

        return new ResponseEntity<>(order, HttpStatus.CREATED);


//        Order order = new Order();
//        order.setId(1);
//
//        return new ResponseEntity<>(order, HttpStatus.CREATED);


    }
}
