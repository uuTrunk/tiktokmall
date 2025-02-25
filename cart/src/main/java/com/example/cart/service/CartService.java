package com.example.cart.service;

import com.example.cart.model.CartItem;
import com.example.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Transactional
    public void addToCart(Long userId, Long productId, Integer quantity) {
        CartItem existingItem = cartRepository.findByUserIdAndProductId(userId, productId);

        if (existingItem != null) {
            // 商品已存在，更新数量
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
        } else {
            // 新增商品
            CartItem newItem = new CartItem();
            newItem.setUserId(userId);
            newItem.setProductId(productId);
            newItem.setQuantity(quantity);
            cartRepository.save(newItem);
        }
    }

    public List<CartItem> getCart(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    @Transactional
    public void emptyCart(Long userId) {
        cartRepository.deleteByUserId(userId);
    }
}