package com.tommenx.controller;

import com.tommenx.entity.User;
import com.tommenx.exception.UserAireadyExistException;
import com.tommenx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Map register(@RequestParam Map<String, Object> param) {
        System.out.println(param);
        Map<String, Object> status = new HashMap<>();
        int statusCode = 1;
        User user = new User();
        user.setUsername((String) param.get("username"));
        user.setPhone((String)param.get("phone"));
        user.setPassword((String)param.get("password"));
        try {
            userService.addUser(user);
        } catch (UserAireadyExistException e) {
            statusCode = 0;
        }
        status.put("code",statusCode);
        return status;
    }


    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map login(@RequestParam Map<String,Object>param) {
        Map<String,Object> status = new HashMap<>();
        int statusCode = 1;
        User user = new User();
        user.setPhone((String)param.get("phone"));
        user.setPassword((String)param.get("password"));
        User store = userService.findUser(user);
        if(store == null) {
            statusCode =  0;
        }else if (!store.getPassword().equals(user.getPassword())) {
            statusCode = 2;
        }
        status.put("code",statusCode);
        return status;
    }
}
