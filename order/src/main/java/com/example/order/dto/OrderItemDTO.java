package com.example.order.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO {
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    private Long productId;
    private Integer quantity;
    private BigDecimal price;
}