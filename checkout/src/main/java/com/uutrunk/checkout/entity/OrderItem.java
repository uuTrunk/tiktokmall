package com.uutrunk.checkout.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author uuTrunk
 */
@Data
public class OrderItem {
    @TableId
    private int productId;
    private float cost;
}
