package com.example.order.service.impl;

import com.example.order.mapper.OrderItemMapper;
import com.example.order.mapper.OrderMapper;
import com.example.order.entity.Order;
import com.example.order.entity.OrderItem;
import com.example.order.service.OrderService;
import com.example.order.vo.OrderCreateVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.uutrunk.product.entity.Product;
import com.uutrunk.product.service.ProductCatalogService;
import org.apache.dubbo.config.annotation.DubboReference;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private OrderMapper orderMapper;
    private OrderItemMapper itemMapper;

    @DubboReference
    private ProductCatalogService productService;
    public OrderServiceImpl(ProductCatalogService productService) {
        this.productService = productService;
    }

    @Transactional
    public String createOrder(OrderCreateVO vo) {
        // 创建订单主记录
        Order order = new Order();
        order.setUserId(vo.getUserId());
        order.setStatus("pending");
        order.setCreatedAt(LocalDateTime.now());
        orderMapper.insert(order);

        // 处理订单项
        vo.getItems().forEach(item -> {
            Product product = productService.getProducts(item.getProductId().intValue());

            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setProductId(item.getProductId());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(BigDecimal.valueOf(product.getPrice()));
            itemMapper.insert(orderItem);
        });

        return order.getId();
    }

    public boolean updateOrderStatus(String orderId, String status) {
        Order order = orderMapper.selectById(orderId);
        if (order != null) {
            order.setStatus(status);
            return orderMapper.updateById(order) > 0;
        }
        return false;
    }
}