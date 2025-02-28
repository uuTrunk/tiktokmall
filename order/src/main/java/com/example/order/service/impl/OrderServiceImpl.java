package com.example.order.service.impl;

import com.example.order.dto.OrderDTO;
import com.example.order.dto.OrderItemDTO;
import com.example.order.entity.Order;
import com.example.order.entity.OrderItem;
import com.example.order.entity.OrderItemPK;
import com.example.order.entity.OrderStatus;
import com.example.order.repository.OrderRepository;
import com.example.order.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public String createOrder(OrderDTO orderDTO) {
        // 1. 生成订单ID（使用UUID或雪花算法）
        String orderId = generateOrderId();

        // 2. 计算总金额
        BigDecimal totalAmount = calculateTotal(orderDTO.getItems());

        // 3. 创建订单实体
        Order order = new Order();
        order.setId(orderId);
        order.setUserId(orderDTO.getUserId());
        order.setTotalAmount(totalAmount);
        order.setStatus(OrderStatus.PENDING);
        order.setCreatedAt(LocalDateTime.now());

        // 4. 转换OrderItemDTO为OrderItem实体，并设置与Order的关联
        List<OrderItem> orderItems = orderDTO.getItems().stream().map(itemDTO -> {
            OrderItem item = new OrderItem();
            OrderItemPK id = new OrderItemPK();
            id.setOrderId(orderId);
            id.setProductId(itemDTO.getProductId());
            item.setId(id);
            item.setOrder(order);
            item.setQuantity(itemDTO.getQuantity());
            item.setPrice(itemDTO.getPrice());
            return item;
        }).collect(Collectors.toList());

        order.setItems(orderItems);

        // 5. 保存到数据库
        orderRepository.save(order);

        return orderId;
    }

    @Override
    public List<OrderDTO> listOrders(Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        return orders.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void markOrderPaid(String orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(OrderStatus.PAID);
        orderRepository.save(order);
    }

    private String generateOrderId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private BigDecimal calculateTotal(List<OrderItemDTO> items) {
        return items.stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private OrderDTO convertToDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setOrderId(order.getId());
        dto.setUserId(order.getUserId());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setCreatedAt(order.getCreatedAt());
        dto.setStatus(order.getStatus().name());
        return dto;
    }
}