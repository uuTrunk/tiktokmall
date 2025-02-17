package com.uutrunk.payment.service;

import com.uutrunk.payment.entity.CreditCardInfo;
import com.uutrunk.payment.vo.ChargeReq;
import com.uutrunk.payment.vo.ChargeResp;

/**
 * PaymentService接口定义了支付服务的标准接口
 * 它提供了一个方法来处理支付请求，包括必要的参数和返回类型
 * @author uuTrunk
 */
public interface PaymentService {
    /**
     * 执行支付操作
     *
     * @param amount 支付金额，表示需要收取的金额数目
     * @param creditCardInfo 信用卡信息，包含进行支付所需的信用卡详情
     * @param orderId 订单ID，唯一标识一次支付请求的订单
     * @param userId 用户ID，表示发起支付请求的用户标识
     * @return ChargeResp 支付响应对象，包含支付结果和相关信息
     *
     * 此方法负责处理支付流程，包括验证信用卡信息、处理支付交易，并返回支付结果
     * 它是PaymentService接口的核心方法，为外部系统提供了支付服务的接入点
     */
    public String charge(float amount, CreditCardInfo creditCardInfo, String orderId, int userId);
}

