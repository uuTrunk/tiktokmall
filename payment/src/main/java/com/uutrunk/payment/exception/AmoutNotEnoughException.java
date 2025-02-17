package com.uutrunk.payment.exception;

/**
 * @author uuTrunk
 */
public class AmoutNotEnoughException extends RuntimeException{
    public AmoutNotEnoughException(String message) {
        super(message);
    }
}
