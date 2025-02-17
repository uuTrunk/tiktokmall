package com.uutrunk.checkout.entity;

import com.uutrunk.payment.entity.CreditCardInfo;
import lombok.Data;

/**
 * @author uuTrunk
 */
@Data
public class CheckoutRecord {
    private int userId;
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
    private CreditCardInfo creditCard;
    private String orderId;
    private String transactionId;
}
