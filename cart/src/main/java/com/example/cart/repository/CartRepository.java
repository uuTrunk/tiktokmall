package com.example.cart.repository;

import com.example.cart.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<CartItem, Long> {

    // 自定义复合主键查询方法
    List<CartItem> findByUserId(Long userId);

    CartItem findByUserIdAndProductId(Long userId, Long productId);

    @Modifying
    @Query("DELETE FROM CartItem c WHERE c.userId = :userId")
    void deleteByUserId(@Param("userId") Long userId);
}