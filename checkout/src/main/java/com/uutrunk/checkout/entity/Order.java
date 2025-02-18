package com.uutrunk.checkout.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

/**
 * @author uuTrunk
 */
@Data
public class Order {
    @TableId
    private String orderId;
    private int userId;
    private String userCurrency;
    private String streetAddress;
    private String email;
    private int createdAt;
    private List<Integer> orderItems;
}
