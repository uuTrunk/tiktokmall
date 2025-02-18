package com.uutrunk.checkout.service;

import com.uutrunk.checkout.entity.Order;

import java.util.List;

/**
 * @author uuTrunk
 */
public interface OrderService {
    public List<Order> listOrder(int userId);
    public boolean markOrderPaid(int userId, String orderId);
}
