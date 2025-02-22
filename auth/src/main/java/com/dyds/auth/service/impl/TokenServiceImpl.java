package com.dyds.auth.service.impl;

import com.dyds.auth.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;
import java.util.UUID;

@Service
public class TokenServiceImpl implements TokenService {
    
    private static final String TOKEN_KEY_PREFIX = "auth:token:";
    private static final Duration TOKEN_TTL = Duration.ofDays(30);
    
    @Autowired
    private RedisTemplate<String, Integer> redisTemplate;  // 存储token-userId映射

    @Override
    public String createToken(int userId) {
        // 生成UUID令牌
        String token = UUID.randomUUID().toString().replace("-", "");
        
        // 存储双关联关系
        redisTemplate.opsForValue().set(
            TOKEN_KEY_PREFIX + token, 
            userId,
            TOKEN_TTL
        );
        
        return token;
    }

    @Override
    public boolean verifyToken(String token) {
        return redisTemplate.hasKey(TOKEN_KEY_PREFIX + token);
    }

    @Override
    public Optional<Integer> getUserIdByToken(String token) {
        try {
            Integer userId = redisTemplate.opsForValue().get(TOKEN_KEY_PREFIX + token);
            return Optional.ofNullable(userId);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}