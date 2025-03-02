package com.example.dao;

import com.example.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: AIOrderMapper
 * @author: bingjie_zou@163.com
 * @date: 2025/2/27 20:24
 * @version: 1.0
 * @description:
 */

@Mapper
public interface AIOrderMapper {


    /**
     * 将订单信息存入订单表
     * @param order
     */
    void saveOrder(Order order);
}
