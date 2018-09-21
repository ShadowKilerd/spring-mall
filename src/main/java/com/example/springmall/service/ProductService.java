package com.example.springmall.service;

import com.example.springmall.bean.Product;
import com.example.springmall.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }

    public Product findById(int productId) {
        return this.productRepository.findById(productId).orElse(null);
    }

    public Product findByValue() {
        return null;
    }
}
