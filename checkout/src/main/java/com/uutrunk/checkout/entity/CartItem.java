package com.uutrunk.checkout.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author uuTrunk
 */
@Data
public class CartItem {
    @TableId
    private int productId;
    private int quantity;
}
