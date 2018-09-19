package com.example.springmall.service;

import com.example.springmall.bean.Cart;
import com.example.springmall.repository.CartRepository;
import com.example.springmall.view.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public void add(List<ProductView> productViews) {
        this.cartRepository.add(productViews);

    }

    public List<Cart> getAll() {
        return this.cartRepository.findAll();
    }
}
