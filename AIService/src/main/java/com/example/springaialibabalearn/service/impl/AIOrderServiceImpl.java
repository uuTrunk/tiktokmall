package com.example.springaialibabalearn.service.impl;

import com.example.springaialibabalearn.dao.AIOrderDetailsMapper;
import com.example.springaialibabalearn.data.OrderDetailsVO;
import com.example.springaialibabalearn.data.OrderQueryDTO;
import com.example.springaialibabalearn.service.AIOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
