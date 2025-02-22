package com.dyds.auth.service;

import java.util.Optional;

public interface TokenService {
    String createToken(int userId);
    boolean verifyToken(String token);
    Optional<Integer> getUserIdByToken(String token);
}