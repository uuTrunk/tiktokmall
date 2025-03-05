package com.example.dao;

import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

/**
 * @className: AIProductMapper
 * @author: bingjie_zou@163.com
 * @date: 2025/2/27 20:58
 * @version: 1.0
 * @description:
 */

@Mapper
public interface AIProductMapper {


    /**
     * 根据商品ID 查询商品价格
     * @param productId
     * @return
     */
    BigDecimal queryPriceById(Long productId);
}
