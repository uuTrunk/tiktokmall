package com.uutrunk.product.entity;

import lombok.Data;

import java.util.List;

/**
 * @author uuTrunk
 */
@Data
public class Product {
    private int id;
    private String name;
    private String description;
    private String picture;
    private float price;
    private List<String> categories;
}
