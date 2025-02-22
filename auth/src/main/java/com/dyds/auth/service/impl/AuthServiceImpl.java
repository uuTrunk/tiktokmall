package com.dyds.auth.service.impl;

import com.dyds.auth.entity.User;
import com.dyds.auth.mapper.UserMapper;
import com.dyds.auth.service.AuthService;
import com.dyds.auth.service.TokenService;
import jakarta.security.auth.message.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private TokenService tokenService;

    @Override
    public String deliverToken(int userId) {
        // 校验用户状态
        User user = userMapper.selectById(userId);
        if (user == null || "BANNED".equals(user.getStatus())) {
            throw new AuthException(1003, "用户状态异常", 403);
        }

        return tokenService.createToken(userId);
    }

    @Override
    public boolean verifyToken(String token) {
        return tokenService.verifyToken(token);
    }
}