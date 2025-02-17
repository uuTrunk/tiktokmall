package com.dyds.service;

import com.dyds.entity.User;

public interface UserService {
    int createUser(User user);
    int login(String email, String password);
    boolean logout(long id);
    boolean deleteUser(long id);
    boolean updateUser(long id, User user);
    User getUserInfo(long id);
}
