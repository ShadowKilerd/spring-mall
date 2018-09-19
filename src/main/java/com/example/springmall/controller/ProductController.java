package com.example.springmall.controller;

import com.example.springmall.bean.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    public List<Product> getProductList() {
        ArrayList<Product> productList = new ArrayList<>();
        Product product = new Product();
        product.setName("可乐");
        product.setPrice(450);
        product.setUnit("瓶");
        product.setImgUrl("api/img/1");
        product.setTotalAmount(10);
        productList.add(product);
        productList.add(new Product());

        return productList;
    }
}
