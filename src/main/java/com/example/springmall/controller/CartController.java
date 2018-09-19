package com.example.springmall.controller;

import com.example.springmall.bean.Cart;
import com.example.springmall.service.CartService;
import com.example.springmall.view.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<List<Cart>> saveProductToCart(
            @PathVariable int userId,
            @RequestBody List<ProductView> productViews
            ) {

        this.cartService.add(productViews);

        return new ResponseEntity<List<Cart>>(this.cartService.getAll(), HttpStatus.CREATED);
    }
}
