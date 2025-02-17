package com.dyds.controller;

import com.dyds.entity.User;
import com.dyds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 创建用户
     * @param user 用户信息
     * @return 用户 ID
     */
    @PostMapping("/user/createUser")
    public long createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 用户 ID，登录失败返回 -1
     */
    @PostMapping("/user/loginUser")
    public long login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

    /**
     * 用户登出
     * @param id 用户 ID
     * @return 是否登出成功
     */
    @PostMapping("/user/logoutUser")
    public boolean logout(@RequestParam long id) {
        return userService.logout(id);
    }

    /**
     * 删除用户
     * @param id 用户 ID
     * @return 是否删除成功
     */
    @DeleteMapping("/user/deleteUser")
    public boolean deleteUser(@RequestParam long id) {
        return userService.deleteUser(id);
    }

    /**
     * 更新用户信息
     * @param id 用户 ID
     * @param user 用户信息
     * @return 是否更新成功
     */
    @PutMapping("/updateUser/{id}")
    public boolean updateUser(@PathVariable long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    /**
     * 获取用户身份信息
     * @param id 用户 ID
     * @return 用户信息
     */
    @GetMapping("/getUserinfo/{id}")
    public User getUserInfo(@PathVariable long id) {
        return userService.getUserInfo(id);
    }
}
