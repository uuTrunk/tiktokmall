package com.uutrunk.payment.service.impl;

import com.uutrunk.payment.entity.ChargeRecord;
import com.uutrunk.payment.exception.AmoutNotEnoughException;
import com.uutrunk.payment.mapper.ChargeRecordMapper;
import com.uutrunk.payment.mapper.CreditCardInfoMapper;
import com.uutrunk.payment.vo.ChargeReq;
import com.uutrunk.payment.vo.ChargeResp;
import com.uutrunk.payment.entity.CreditCardInfo;
import com.uutrunk.payment.service.PaymentService;
import org.apache.dubbo.config.annotation.DubboService;

import java.sql.Wrapper;
import java.util.UUID;

/**
 * @author uuTrunk
 */
@DubboService
public class PaymentServiceImpl implements PaymentService {

    private final CreditCardInfoMapper creditCardInfoMapper;
    private final ChargeRecordMapper chargeRecordMapper;
    public PaymentServiceImpl(CreditCardInfoMapper creditCardInfoMapper, ChargeRecordMapper chargeRecordMapper) {
        this.creditCardInfoMapper = creditCardInfoMapper;
        this.chargeRecordMapper = chargeRecordMapper;
    }
    @Override
    public String charge(float amount, CreditCardInfo creditCardInfo, String orderId, int userId) {
        try {
            if(isAmountEnough(amount, creditCardInfo)) {
                creditCardInfo.setCreditCardAmount(creditCardInfo.getCreditCardAmount() - amount);
                creditCardInfoMapper.updateById(creditCardInfo);
                ChargeRecord chargeRecord = new ChargeRecord();
                chargeRecord.setTransactionId(generateTransactionId());
                chargeRecord.setCreditCard(creditCardInfo);
                chargeRecord.setOrderId(orderId);
                chargeRecord.setUserId(userId);
                chargeRecord.setAmount(amount);
                chargeRecordMapper.insert(chargeRecord);
                return chargeRecord.getTransactionId();
            }

        }
        catch (AmoutNotEnoughException e) {
            System.err.println(e.getMessage());

        }
        return "FAILURE";
    }
    public boolean isAmountEnough(float amount, CreditCardInfo creditCardInfo) {
        if(creditCardInfo.getCreditCardAmount() < amount) {
            throw new AmoutNotEnoughException("Amount is not enough");
        }
        return true;
    }
    /**
     * 生成一个唯一的 transactionId
     * @return 生成的 transactionId
     */
    private String generateTransactionId() {
        return UUID.randomUUID().toString();
    }
}

