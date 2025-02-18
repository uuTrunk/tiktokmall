package com.uutrunk.checkout.controller;

import com.uutrunk.checkout.service.CheckoutService;
import com.uutrunk.checkout.vo.CheckoutReq;
import com.uutrunk.checkout.vo.CheckoutResp;
import com.uutrunk.payment.entity.CreditCardInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author uuTrunk
 */
@RestController
public class CheckoutController {
    private final CheckoutService checkoutService;
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @RequestMapping("/checkout")
    public CheckoutResp checkout(CheckoutReq checkoutReq) {
        int userId = checkoutReq.getUserId();
        String firstname = checkoutReq.getFirstname();
        String lastname = checkoutReq.getLastname();
        String email = checkoutReq.getEmail();
        CreditCardInfo creditCard = checkoutReq.getCreditCard();
        String transactionId = checkoutService.checkout(userId, firstname, lastname, email, checkoutReq.getAddress(), creditCard);
        CheckoutResp resp = new CheckoutResp();
        resp.setTransactionId(transactionId);
        return resp;
    }

}
