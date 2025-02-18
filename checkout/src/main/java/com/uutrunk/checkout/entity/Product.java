package com.uutrunk.checkout.entity;

import lombok.Data;

/**
 * @author uuTrunk
 */
@Data
public class Product {
    private int id;
    private String name;
    private float price;
    private String description;
    private String picture;
}
