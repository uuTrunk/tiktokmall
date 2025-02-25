package com.uutrunk.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uutrunk.product.entity.Product;
import com.uutrunk.product.mapper.ProductMapper;
import com.uutrunk.product.service.ProductCatalogService;
import com.uutrunk.product.vo.ListProductsResp;
import com.uutrunk.product.vo.SearchProductsResp;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author uuTrunk
 */
@DubboService
public class ProductCatalogServiceImpl implements ProductCatalogService {
    private ProductMapper productMapper;
    public ProductCatalogServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
    @Override
    public List<Product> listProducts(int page, long pageSize, String categoryName) {
        // 创建分页对象
        Page<Product> productPage = new Page<>(page, pageSize);
        // 构建查询条件
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        if (categoryName != null && !categoryName.isEmpty()) {
            queryWrapper.eq("category_name", categoryName);
        }

        // 执行分页查询
        IPage<Product> resultPage = productMapper.selectPage(productPage, queryWrapper);

        // 封装响应结果
        return resultPage.getRecords();
    }


    @Override
    public Product getProducts(int id) {
        Product product = productMapper.selectById(id);
        return product;
    }

    @Override
    public List<Product> searchProducts(String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", query);
        List<Product> results = productMapper.selectByMap(map);
        return results;
    }
}
