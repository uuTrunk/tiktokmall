package com.uutrunk.product.vo;

import com.uutrunk.product.entity.Product;
import lombok.Data;

import java.util.List;

/**
 * @author uuTrunk
 */
@Data
public class ListProductsResp {
    private List<Product> products;
}
