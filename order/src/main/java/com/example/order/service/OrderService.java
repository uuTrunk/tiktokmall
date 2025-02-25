package com.example.order.service;

import com.example.order.vo.OrderCreateVO;

public interface OrderService {
    String createOrder(OrderCreateVO vo);
    boolean updateOrderStatus(String orderId, String status);
}