package com.example.springmall.controller;

import com.example.springmall.view.ProductView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/carts")
public class CartController {

    @PostMapping
    public ResponseEntity<String> saveProductToCart(
            @PathVariable int userId,
            @RequestBody List<ProductView> productViews
            ) {

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
