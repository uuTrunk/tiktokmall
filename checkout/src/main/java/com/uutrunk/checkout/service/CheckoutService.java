package com.uutrunk.checkout.service;

import com.uutrunk.checkout.entity.Address;
import com.uutrunk.checkout.vo.CheckoutReq;
import com.uutrunk.checkout.vo.CheckoutResp;
import com.uutrunk.payment.entity.CreditCardInfo;

import java.util.List;

/**
 * @author uuTrunk
 */
public interface CheckoutService {
    /**
     * 结账服务接口，用于处理用户的结账请求。
     *
     * @param userId 用户ID，用于标识进行结账的用户。
     * @param firstname 用户名，用于在结账过程中显示或记录。
     * @param lastname 用户姓氏，与用户名一起用于完整地标识用户。
     * @param email 用户邮箱，用于结账后的确认邮件发送或其他通信用途。
     * @param address 用户的送货地址，用于确认送货位置。
     * @param creditCardInfo 用户的信用卡信息，用于支付处理。
     * @return 返回一个CheckoutResp对象，包含结账结果和相关信息。
     *
     * 此接口定义了结账过程中的必要参数和预期返回值，实现了用户结账请求的标准化处理。
     */
    public List<String> checkout(int userId, String firstname, String lastname, String email, Address address, CreditCardInfo creditCardInfo);
}

