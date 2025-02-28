package com.example.order.service;

import com.example.order.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    String createOrder(OrderDTO orderDTO);
    List<OrderDTO> listOrders(Long userId);
    void markOrderPaid(String orderId);
}