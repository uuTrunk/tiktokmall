package com.uutrunk.payment.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author uuTrunk
 */
@Data
public class CreditCardInfo {
    @TableId
    private String creditCardNumber;
    private String creditCardCvv;
    private double creditCardAmount;
    private int creditCardExpirationYear;
    private int creditCardExpirationMonth;
}
