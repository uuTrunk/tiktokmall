package com.example.order.controller;

import com.example.order.service.OrderService;
import com.example.order.vo.OrderCreateVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private  OrderService orderService;

    /**
     * 创建订单
     * @param vo 订单创建请求参数
     * @return 订单ID
     */
    @PostMapping("/create")
    public String createOrder(@RequestBody @Valid OrderCreateVO vo) {
        return orderService.createOrder(vo);
    }

    /**
     * 更新订单状态
     * @param orderId 订单ID
     * @param status 新状态
     * @return 更新结果
     */
    @PutMapping("/{orderId}/status")
    public boolean updateStatus(@PathVariable String orderId,
                                @RequestParam String status) {
        return orderService.updateOrderStatus(orderId, status);
    }
}