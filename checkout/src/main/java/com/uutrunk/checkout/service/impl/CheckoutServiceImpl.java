package com.uutrunk.checkout.service.impl;

import com.uutrunk.checkout.entity.Address;
import com.uutrunk.checkout.mapper.AddressMapper;
import com.uutrunk.checkout.vo.CheckoutReq;
import com.uutrunk.checkout.vo.CheckoutResp;
import com.uutrunk.checkout.service.CheckoutService;
import com.uutrunk.payment.entity.CreditCardInfo;
import com.uutrunk.payment.service.PaymentService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.List;

/**
 * @author uuTrunk
 */
@DubboService
public class CheckoutServiceImpl implements CheckoutService {
    private final AddressMapper addressMapper;

    public CheckoutServiceImpl(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Override
    public List<String> checkout(int userId, String firstname, String lastname, String email, Address address, CreditCardInfo creditCardInfo) {
        //TODO
        return null;
    }


}

