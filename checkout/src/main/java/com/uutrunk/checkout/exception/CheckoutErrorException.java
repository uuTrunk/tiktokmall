package com.uutrunk.checkout.exception;

/**
 * @author uuTrunk
 */
public class CheckoutErrorException extends RuntimeException{
    public CheckoutErrorException(String message) {
        super(message);
    }
}
