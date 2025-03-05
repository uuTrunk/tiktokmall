package com.example.service.impl;

import com.example.common.Constants;
import com.example.dao.AIOrderMapper;
import com.example.dao.AIProductMapper;
import com.example.data.OrderCreateDTO;
import com.example.data.OrderDetailsVO;
import com.example.data.OrderItemDTO;
import com.example.data.OrderQueryDTO;
import com.example.entity.Order;
import com.example.entity.OrderItem;
import com.example.entity.OrderVO;
import com.example.dao.AIOrderDetailsMapper;
import com.example.service.AIOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @className: OrderQueryService
 * @author: bingjie_zou@163.com
 * @date: 2025/2/16 0:06
 * @version: 1.0
 * @description: AI大模型订单服务接口的实现类
 */

@Service
public class AIOrderServiceImpl implements AIOrderService {

    @Autowired
    private AIOrderDetailsMapper aiOrderDetailsMapper;

    @Autowired
    private AIOrderMapper aiOrderMapper;

    @Autowired
    private AIProductMapper aiProductMapper;


    /**
     * 调用持久层的接口进行订单信息查询
     * @param orderQueryDTO 用户传入的查询信息
     * @return 返回查询到的订单详细信息列表 大模型会自动转换成语言告诉客户
     */
    @Override
    public List<OrderDetailsVO> getOrderDetails(OrderQueryDTO orderQueryDTO) {
        List<OrderDetailsVO> orderDetailsVOs = aiOrderDetailsMapper.getOrderDetails(orderQueryDTO);
        return orderDetailsVOs;

    }

    /**
     * 将订单信息分别插入主表和订单明细表
     * @param orderCreateDTO 包括用户ID和商品列表，列表中包括商品ID和数量
     * @return
     */
    @Transactional
    @Override
    public OrderVO createOrder(OrderCreateDTO orderCreateDTO) {
        // 1. 生成订单ID（使用UUID或雪花算法）
        String orderId = generateOrderId();

        // 2. 查询商品单价 计算总金额
        List<OrderItemDTO> orderCreateDTOItems = orderCreateDTO.getItems();
        for (OrderItemDTO orderCreateDTOItem : orderCreateDTOItems) {
            Long productId = orderCreateDTOItem.getProductId();
            BigDecimal price = aiProductMapper.queryPriceById(productId);
            orderCreateDTOItem.setPrice(price);
        }
        BigDecimal totalAmount = calculateTotal(orderCreateDTOItems);

        // 3. 创建订单实体 并保存
        Order order = new Order();
        order.setId(orderId);
        order.setUserId(orderCreateDTO.getUserId());
        order.setTotalAmount(totalAmount);
        order.setStatus(Constants.ORDER_STATUS_PENDING);
        order.setCreatedAt(LocalDateTime.now());
        aiOrderMapper.saveOrder(order);

        // 4. 创建订单明细 并保存
        List<OrderItem> orderItemList = new ArrayList<>();
        for (OrderItemDTO orderCreateDTOItem : orderCreateDTOItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(orderId);
            orderItem.setProductId(orderCreateDTOItem.getProductId());
            orderItem.setPrice(orderCreateDTOItem.getPrice());
            orderItem.setQuantity(orderCreateDTOItem.getQuantity());
            orderItemList.add(orderItem);
        }
        aiOrderDetailsMapper.saveOrderItems(orderItemList);

        //完成操作返回订单ID
        OrderVO orderVO = new OrderVO();
        orderVO.setOrderId(orderId);
        orderVO.setItems(orderItemList);
        orderVO.setTotalAmount(totalAmount);
        return orderVO;
    }

    private String generateOrderId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private BigDecimal calculateTotal(List<OrderItemDTO> items) {
        return items.stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
