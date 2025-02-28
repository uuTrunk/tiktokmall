package com.example.cart.controller;

import com.example.cart.model.CartItem;
import com.example.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{userId}/items")
    public void addItem(@PathVariable Long userId,
                        @RequestParam Long productId,
                        @RequestParam(defaultValue = "1") Integer quantity) {
        cartService.addToCart(userId, productId, quantity);
    }

    @GetMapping("/{userId}")
    public List<CartItem> getCart(@PathVariable Long userId) {
        return cartService.getCart(userId);
    }

    @DeleteMapping("/{userId}")
    public void emptyCart(@PathVariable Long userId) {
        cartService.emptyCart(userId);
    }
}