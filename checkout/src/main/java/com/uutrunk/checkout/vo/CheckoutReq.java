package com.uutrunk.checkout.vo;

import com.uutrunk.checkout.entity.Address;
import com.uutrunk.payment.entity.CreditCardInfo;
import lombok.Data;

/**
 * @author uuTrunk
 */
@Data
public class CheckoutReq {
    private int userId;
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
    private CreditCardInfo creditCard;
}
