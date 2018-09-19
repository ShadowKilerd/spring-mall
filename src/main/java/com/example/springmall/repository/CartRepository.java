package com.example.springmall.repository;

import com.example.springmall.bean.Cart;
import com.example.springmall.view.ProductView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;


public interface CartRepository extends JpaRepository<Cart, Integer> {
    public List<Cart> findAll();
}
