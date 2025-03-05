package com.example.service;

import com.example.data.OrderCreateDTO;
import com.example.data.OrderDetailsVO;
import com.example.data.OrderQueryDTO;
import com.example.entity.OrderVO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @className: OrderQueryService
 * @author: bingjie_zou@163.com
 * @date: 2025/2/16 0:07
 * @version: 1.0
 * @description: AI大模型订单服务接口
 */


public interface AIOrderService {

    /**
     * 通过AI大模型自动调用接口，进行用户订单信息查询
     * @param orderQueryDTO 用户传入的查询信息
     * @return 返回查询到的订单详细信息列表 大模型会自动转换成语言告诉客户
     */
    List<OrderDetailsVO> getOrderDetails(OrderQueryDTO orderQueryDTO);

    /**
     * 创建订单对象
     * @param orderCreateDTO 包括用户ID和商品列表，列表中包括商品ID和数量
     * @return 返回订单号transactionId
     */
    OrderVO createOrder(@RequestBody OrderCreateDTO orderCreateDTO);
}
