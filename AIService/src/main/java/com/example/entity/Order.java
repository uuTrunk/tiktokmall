package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: Order
 * @author: bingjie_zou@163.com
 * @date: 2025/2/27 20:14
 * @version: 1.0
 * @description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    /** 订单ID */
    private String id;
    /** 用户ID */
    private Long userId;
    /** 总金额 */
    private BigDecimal totalAmount;
    /** 订单状态 */
    private String status;
    /** 创建时间 */
    private LocalDateTime createdAt;
    /** 商品列表 */
    private List<OrderItem> items = new ArrayList<>();

}
