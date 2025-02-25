package com.example.cart.model;

import jakarta.persistence.*;
import org.apache.catalina.User;

import java.time.LocalDateTime;
import java.util.List;

@IdClass(CartId.class) // 定义复合主键类
public class Cart {
    @Id
    @Column(name = "user_id")
    private Long userId; // 用户ID，与数据库表结构一致

    @Id
    @Column(name = "product_id")
    private Long productId; // 商品ID，与数据库表结构一致

    private LocalDateTime createdAt; // 创建时间，与数据库表结构一致

    private Integer quantity; // 数量，与数据库表结构一致

    private Boolean selected; // 是否选中，与数据库表结构一致
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "Id",
            foreignKey = @ForeignKey(name = "fk_user"))
    private User user;  // 确保有对应的User实体类

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;  // 确保有对应的Product实体类
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

}