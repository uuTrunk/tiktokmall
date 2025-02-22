package com.dyds.auth.rpc.impl;

import com.dyds.auth.rpc.AuthRpcService;
import org.apache.dubbo.config.annotation.DubboService;
import com.dyds.proto.AuthProto.*;
import com.dyds.auth.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService(version = "1.0.0")
public class AuthRpcServiceImpl implements AuthRpcService {

    @Autowired
    private TokenService tokenService;

    @Override
    public DeliveryResp deliverToken(DeliverTokenReq request) {
        return DeliveryResp.newBuilder()
                .setToken(tokenService.createToken(request.getUserId()))
                .build();
    }

    @Override
    public VerifyResp verifyToken(VerifyTokenReq request) {
        return VerifyResp.newBuilder()
                .setRes(tokenService.verifyToken(request.getToken()))
                .build();
    }
}