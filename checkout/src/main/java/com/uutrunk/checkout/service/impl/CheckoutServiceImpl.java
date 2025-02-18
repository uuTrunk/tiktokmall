package com.uutrunk.checkout.service.impl;

import com.uutrunk.checkout.entity.Address;
import com.uutrunk.checkout.entity.Order;
import com.uutrunk.checkout.entity.OrderItem;
import com.uutrunk.checkout.entity.Product;
import com.uutrunk.checkout.mapper.AddressMapper;
import com.uutrunk.checkout.mapper.OrderItemMapper;
import com.uutrunk.checkout.mapper.OrderMapper;
import com.uutrunk.checkout.service.CheckoutService;
import com.uutrunk.checkout.service.OrderService;
import com.uutrunk.checkout.service.ProductService;
import com.uutrunk.payment.entity.CreditCardInfo;
import com.uutrunk.payment.exception.InformationNotMatchedException;
import com.uutrunk.payment.service.PaymentService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.List;

/**
 * @author uuTrunk
 */
@DubboService
public class CheckoutServiceImpl implements CheckoutService {
    private final AddressMapper addressMapper;
    private final OrderItemMapper orderItemMapper;
    @DubboReference
    private final OrderService orderService;
    @DubboReference
    private final ProductService productService;
    @DubboReference
    private final PaymentService paymentService;

    public CheckoutServiceImpl(AddressMapper addressMapper, OrderService orderService, ProductService productService, OrderItemMapper orderItemMapper, PaymentService paymentService) {
        this.addressMapper = addressMapper;
        this.orderItemMapper = orderItemMapper;
        this.orderService = orderService;
        this.productService = productService;
        this.paymentService = paymentService;
    }

    @Override
    public String checkout(int userId, String firstname, String lastname, String email, Address address, CreditCardInfo creditCardInfo) {
        List<Order> orders = orderService.listOrder(userId);
        String transactionId = "";
        for(Order order : orders) {
            String orderId = order.getOrderId();
            if(!order.getEmail().equals(email)||!order.getStreetAddress().equals(address.getStreetAddress())) {
                throw new InformationNotMatchedException("订单信息错误");
            }
            float amount = 0;
            for(int productId : order.getOrderItems()) {
                OrderItem orderItem = orderItemMapper.selectById(productId);
                amount+=orderItem.getCost();
            }
            transactionId = paymentService.charge(amount, creditCardInfo, orderId, userId);
            if(transactionId.equals("FAILURE")) {
                throw new InformationNotMatchedException("支付失败");
            }
            orderService.markOrderPaid(userId, orderId);
        }
        return transactionId;
    }


}

