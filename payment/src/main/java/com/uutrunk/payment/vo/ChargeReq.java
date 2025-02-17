package com.uutrunk.payment.vo;

import com.uutrunk.payment.entity.CreditCardInfo;
import lombok.Data;

/**
 * @author uuTrunk
 */
@Data
public class ChargeReq {
    private float amount;
    private CreditCardInfo creditCard;
    private String orderId;
    private int userId;
}
