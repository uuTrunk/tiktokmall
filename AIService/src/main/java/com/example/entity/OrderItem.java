package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @className: OrderItem
 * @author: bingjie_zou@163.com
 * @date: 2025/3/2 16:51
 * @version: 1.0
 * @description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    /** 订单明细的ID 由订单号与产品ID构成 */
    private String orderId;
    /** 购买数量 */
    private Integer quantity;
    /** 价格 */
    private BigDecimal price;
    /** 订单ID */
    private Long productId;
}

