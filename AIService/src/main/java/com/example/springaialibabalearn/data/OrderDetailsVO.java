package com.example.springaialibabalearn.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @className: OrderDetailsVO
 * @author: bingjie_zou@163.com
 * @date: 2025/2/15 23:53
 * @version: 1.0
 * @description:
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsVO {
    // 订单号  联表查询 主表和明细表
    private String orderId;
    // 用户ID
    private Long userId;
    // 订单总金额
    private BigDecimal totalAmount;
    // 订单状态
    private String status;
    // 订单创建时间
    private LocalDateTime createdAt;
    // 商品ID
    private Long productId;
    // 购买数量
    private Integer quantity;
    // 购买时价格
    private BigDecimal price;
}
