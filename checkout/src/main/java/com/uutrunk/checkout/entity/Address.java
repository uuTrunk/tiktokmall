package com.uutrunk.checkout.entity;

import lombok.Data;

/**
 * @author uuTrunk
 */
@Data
public class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}
