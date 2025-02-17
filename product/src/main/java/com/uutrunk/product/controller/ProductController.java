package com.uutrunk.product.controller;

import com.uutrunk.product.entity.Product;
import com.uutrunk.product.service.impl.ProductCatalogServiceImpl;
import com.uutrunk.product.vo.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author uuTrunk
 */
@RestController
public class ProductController {
    private ProductCatalogServiceImpl productCatalogService;
    public ProductController(ProductCatalogServiceImpl productCatalogService)
    {
        this.productCatalogService = productCatalogService;
    }

    @RequestMapping("/listProducts")
    public ListProductsResp listProducts(ListProductsReq req)
    {
        int page = req.getPage();
        long pageSize = req.getPageSize();
        String categoryName = req.getCategoryName();
        List<Product> products = productCatalogService.listProducts(page, pageSize, categoryName);
        ListProductsResp resp = new ListProductsResp();
        resp.setProducts(products);
        return resp;
    }

    @RequestMapping("/getProduct")
    public GetProductResp getProduct(GetProductReq req)
    {
        Product product = productCatalogService.getProducts(req.getId());
        GetProductResp resp = new GetProductResp();
        resp.setProduct(product);
        return resp;
    }

    @RequestMapping("/searchProducts")
    public SearchProductsResp searchProducts(SearchProductsReq req)
    {
        List<Product> results = productCatalogService.searchProducts(req.getQuery());
        SearchProductsResp resp = new SearchProductsResp();
        resp.setResults(results);
        return resp;
    }
}
