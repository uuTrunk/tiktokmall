package com.uutrunk.product.service;

import com.uutrunk.product.entity.Product;
import com.uutrunk.product.vo.GetProductResp;
import com.uutrunk.product.vo.ListProductsReq;
import com.uutrunk.product.vo.ListProductsResp;
import com.uutrunk.product.vo.SearchProductsResp;

import java.util.List;

/**
 * @author uuTrunk
 */
public interface ProductCatalogService {
    /**
     * 根据类别名称和分页信息列出产品
     *
     * @param page        页码，表示请求的产品列表的页码
     * @param pageSize    每页的产品数量
     * @param categoryName    产品所属的类别名称
     * @return ListProductsResp   包含产品列表的响应对象
     */
    public List<Product> listProducts(int page, long pageSize, String categoryName);

    /**
     * 获取指定产品的详细信息
     *
     * @param product     需要获取详细信息的产品对象
     * @return GetProductResp    包含产品详细信息的响应对象
     */
    public Product getProducts(int id);

    /**
     * 搜索符合特定条件的产品
     *
     * @param results     一组产品对象，作为搜索的结果集
     * @return SearchProductsResp   包含搜索结果的响应对象
     */
    public List<Product> searchProducts(String query);

}
