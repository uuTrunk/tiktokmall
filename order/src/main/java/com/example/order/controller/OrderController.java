package com.example.order.controller;


import com.example.order.dto.OrderDTO;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public String placeOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @GetMapping("/{userId}")
    public List<OrderDTO> listOrders(@PathVariable Long userId) {
        return orderService.listOrders(userId);
    }

    @PostMapping("/{orderId}/paid")
    public void markOrderPaid(@PathVariable String orderId) {
        orderService.markOrderPaid(orderId);
    }
}