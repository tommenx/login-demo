package com.tommenx.dao;

import com.tommenx.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    int insert(User user) throws Exception;
    User selectById(@Param("id") Integer id);
    User selectByPhone(@Param("phone") String phone);
}
