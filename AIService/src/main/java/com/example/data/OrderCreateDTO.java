package com.example.data;

import lombok.Data;

import java.util.List;

/**
 * @className: OrderCreateDTO
 * @author: bingjie_zou@163.com
 * @date: 2025/2/27 20:03
 * @version: 1.0
 * @description:
 */

@Data
public class OrderCreateDTO {
    /** 用户id */
    private Long userId;
    /** 商品列表 */
    private List<OrderItemDTO> items;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}
