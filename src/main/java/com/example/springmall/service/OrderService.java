package com.example.springmall.service;

import com.example.springmall.bean.Order;
import com.example.springmall.bean.OrderItem;
import com.example.springmall.repository.OrderItemRepository;
import com.example.springmall.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public Order create(ArrayList<OrderItem> orderItems) {


        Order order = Order.builder().items(orderItems).userId(1).build();
        return this.orderRepository.save(order);
    }
}
