package com.example.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @className: OrderItemDTO
 * @author: bingjie_zou@163.com
 * @date: 2025/2/27 20:07
 * @version: 1.0
 * @description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {
    /** 商品ID */
    private Long productId;
    /** 商品数量 */
    private Integer quantity;
    /** 商品价格 */
    private BigDecimal price;

}
