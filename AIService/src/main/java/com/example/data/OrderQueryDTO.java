package com.example.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: OrderQueryDTO
 * @author: bingjie_zou@163.com
 * @date: 2025/2/16 0:02
 * @version: 1.0
 * @description:
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderQueryDTO {

    // 订单号  联表查询 主表和明细表
    private String orderId;

    // 订单状态
    private String status;

    // 用户名
    private Long userId;
}
