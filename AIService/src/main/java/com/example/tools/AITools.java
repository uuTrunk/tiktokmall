package com.example.tools;

import com.example.data.OrderCreateDTO;
import com.example.data.OrderDetailsVO;
import com.example.data.OrderQueryDTO;
import com.example.entity.OrderVO;
import com.example.service.AIOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.core.NestedExceptionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @className: AITools
 * @author: bingjie_zou@163.com
 * @date: 2025/2/16 0:19
 * @version: 1.0
 * @description:
 */


@Configuration
public class AITools {

    private static final Logger logger = LoggerFactory.getLogger(AITools.class);

    private AIOrderService aiOrderService;

    public AITools(AIOrderService aiOrderService) {
        this.aiOrderService = aiOrderService;
    }


    //注册callFunction的接口 并为函数添加描述信息 便于AI更好地识别用户意图并出发函数
    @Bean
    @Description("根据用户给出的信息获取对应订单详细信息")
    public Function<OrderQueryDTO, List<OrderDetailsVO>> getOrderDetails(){
        //实现Function函数式接口流式编程输出结果
        return request -> {
            try {
                List<OrderDetailsVO> response = aiOrderService.getOrderDetails(request);
                return response;
            }
            catch (Exception e){
                logger.warn("Order details: {}", NestedExceptionUtils.getMostSpecificCause(e).getMessage());
                ArrayList<OrderDetailsVO> response = new ArrayList<>();
                OrderDetailsVO orderDetailsVO = new OrderDetailsVO(request.getOrderId(), request.getUserId(), null, request.getStatus(), null, null, null, null);
                response.add(orderDetailsVO);
                return response;
            }
        };
    }


    //注册callFunction的接口 并为函数添加描述信息 便于AI更好地识别用户意图并出发函数
    @Bean
    @Description("代替用户进行下单，需要获得用户ID以及用户想要下单的商品id及其数量")
    public Function<OrderCreateDTO, OrderVO> simulationOrder(){
        //实现Function函数式接口流式编程输出结果
        return request -> {
            try {
                OrderVO response = aiOrderService.createOrder(request);
                return response;
            }
            catch (Exception e){
                logger.warn("fail to create order: {}", NestedExceptionUtils.getMostSpecificCause(e).getMessage());
                OrderVO orderVO = new OrderVO();
                orderVO.setErrorMsg("下单失败");
                OrderVO response = orderVO;
                return response;
            }
        };
    }




}

