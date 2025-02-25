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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private float price;
    private List<String> categories;
}
