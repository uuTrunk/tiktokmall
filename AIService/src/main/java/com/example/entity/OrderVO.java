package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @className: OrderVO
 * @author: bingjie_zou@163.com
 * @date: 2025/3/2 21:24
 * @version: 1.0
 * @description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {
    /** 订单ID */
    private String orderId;
    /** 商品列表 */
    private List<OrderItem> items;
    /** 错误信息 */
    private String errorMsg;
    /** 总价 */
    private BigDecimal totalAmount;
}
