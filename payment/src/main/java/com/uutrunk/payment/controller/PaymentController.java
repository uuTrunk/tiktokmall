package com.uutrunk.payment.controller;

import com.uutrunk.payment.entity.CreditCardInfo;
import com.uutrunk.payment.vo.ChargeReq;
import com.uutrunk.payment.vo.ChargeResp;
import com.uutrunk.payment.service.PaymentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author uuTrunk
 */
@RestController
public class PaymentController {

    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    /**
     * 处理充值请求
     *
     * 该方法通过@RequestMapping注解映射到/charge路径，用于处理HTTP请求中的充值操作
     * 它接收一个ChargeReq对象作为参数，该对象包含了充值所需的必要信息
     *
     * @param chargeReq 充值请求对象，包含充值的详细信息，如用户ID、金额等
     * @return 返回ChargeResp对象，包含充值操作的结果信息
     */
    @RequestMapping("/charge")
    public ChargeResp charge(ChargeReq chargeReq) {
        float amount = chargeReq.getAmount();
        CreditCardInfo creditCardInfo = chargeReq.getCreditCard();
        String orderId = chargeReq.getOrderId();
        int userId = chargeReq.getUserId();
        String transactionId = paymentService.charge(amount, creditCardInfo, orderId, userId);
        ChargeResp resp = new ChargeResp();
        resp.setTransactionId(transactionId);
        return resp;
    }
}
