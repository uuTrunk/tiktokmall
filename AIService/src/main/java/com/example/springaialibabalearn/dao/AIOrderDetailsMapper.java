package com.example.springaialibabalearn.dao;

import com.example.springaialibabalearn.data.OrderDetailsVO;
import com.example.springaialibabalearn.data.OrderQueryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @className: OrderQueryMapper
 * @author: bingjie_zou@163.com
 * @date: 2025/2/18 15:25
 * @version: 1.0
 * @description:
 */

@Mapper
public interface AIOrderDetailsMapper {


    /**
     * 根据信息查询订单详细信息
     * @param orderQueryDTO
     * @return 返回查询到的订单详细信息列表 大模型会自动转换成语言告诉客户
     */
    List<OrderDetailsVO> getOrderDetails(OrderQueryDTO orderQueryDTO);
}
