package com.dyds.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dyds.dao.UserDAO;
import com.dyds.entity.User;
import com.dyds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO = new UserDAO();

    //创建用户
    @Override
    public int createUser(User user) {
        return userDAO.createUser(user);
    }

    //用户登录
    @Override
    public int login(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        //密码验证成功，登录成功
        if (user != null && user.getPasswordHash().equals(password)) {
            return 1;
        }
        //密码输入错误，未登录
        return -1;
    }

    //用户登出???
    @Override
    public boolean logout(long id) {
        return false;
    }

    //删除用户
    @Override
    public boolean deleteUser(long id) {
        return userDAO.deleteUser(id);
    }

    //更新用户
    @Override
    public boolean updateUser(long id, User user) {
        return userDAO.updateUser(id, user);
    }

    //获取用户身份信息
    @Override
    public User getUserInfo(long id) {
        User user = userDAO.getUserById(id);
        return user;
    }
}
