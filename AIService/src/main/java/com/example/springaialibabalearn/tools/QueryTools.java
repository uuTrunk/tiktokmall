package com.example.springaialibabalearn.tools;

import com.example.springaialibabalearn.data.OrderDetailsVO;
import com.example.springaialibabalearn.data.OrderQueryDTO;
import com.example.springaialibabalearn.service.AIOrderService;
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
 * @className: QueryTools
 * @author: bingjie_zou@163.com
 * @date: 2025/2/16 0:19
 * @version: 1.0
 * @description:
 */


@Configuration
public class QueryTools {

    private static final Logger logger = LoggerFactory.getLogger(QueryTools.class);

    private AIOrderService aiOrderService;

    public QueryTools(AIOrderService aiOrderService) {
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




}

