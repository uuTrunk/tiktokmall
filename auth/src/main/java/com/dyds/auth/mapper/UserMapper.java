package com.dyds.auth.mapper;

import com.dyds.auth.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT * FROM sys_user WHERE id = #{userId}")
    User selectById(Integer userId);

    @Select("SELECT * FROM sys_user WHERE username = #{username}")
    User selectByUsername(String username);
}