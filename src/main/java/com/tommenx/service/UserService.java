package com.tommenx.service;

import com.tommenx.dao.UserDao;
import com.tommenx.entity.User;
import com.tommenx.exception.UserAireadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    @Autowired
    private UserDao userDao;
    public void addUser(User user) throws UserAireadyExistException {
        int result = 0; //受影响的行数默认为0
        try {
            result = userDao.insert(user);
        } catch (Exception e) {
            System.out.println("添加用户失败,用户已经存在");
            //其他用户添加失败异常
            throw new UserAireadyExistException(e);
        }
        if (result > 0)
            System.out.println("添加用户成功");
    }

    public User findUser(User user) {
        return userDao.selectByPhone(user.getPhone());
    }
}
