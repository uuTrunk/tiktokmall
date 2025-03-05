package com.dyds.auth.service;

public interface AuthService {
    /**
     * 生成访问令牌
     * @param userId 用户ID
     * @return JWT令牌
     */
    String deliverToken(int userId);

    /**
     * 验证令牌有效性
     * @param token 待验证令牌
     * @return 是否有效
     */
    boolean verifyToken(String token);
}