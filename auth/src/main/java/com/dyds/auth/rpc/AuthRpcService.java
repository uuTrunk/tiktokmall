package com.dyds.auth.rpc;

import com.dyds.proto.AuthProto;

public interface AuthRpcService {
    AuthProto.DeliveryResp deliverToken(AuthProto.DeliverTokenReq request);
    AuthProto.VerifyResp verifyToken(AuthProto.VerifyTokenReq request);
}