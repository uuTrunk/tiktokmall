package com.uutrunk.product.vo;

import lombok.Data;

/**
 * @author uuTrunk
 */
@Data
public class ListProductsReq {
    private int page;
    private long pageSize;
    private String categoryName;
}
