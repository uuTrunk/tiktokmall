package com.uutrunk.payment.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author uuTrunk
 */
@Data
public class ChargeRecord {
    @TableId
    private String transactionId;
    private float amount;
    private CreditCardInfo creditCard;
    private String orderId;
    private int userId;
}
