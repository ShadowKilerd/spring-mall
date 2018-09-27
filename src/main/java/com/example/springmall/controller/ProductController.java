package com.example.springmall.controller;

import com.example.springmall.bean.Product;
import com.example.springmall.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @HystrixCommand(defaultFallback = "failedCallback")
    @PreAuthorize("hasRole('USER')")
    public List<Product> getProductList() {
        return this.productService.getProducts();
    }

    public List<Product> failedCallback() {
        return Arrays.asList(new Product());
    }
}
