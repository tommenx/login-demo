package com.tommenx.controller;

import com.tommenx.dao.UserDao;
import com.tommenx.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("hello")
public class MainController {
    @Autowired
    private UserDao dao;
    @RequestMapping("say")
    public ModelAndView say() {
        ModelAndView mdv = new ModelAndView("hello");
        mdv.addObject("word","hello world");
        User user = new User();
        user.setLoginId("123");
        user.setName("tom");
        user.setSex("man");
        user.setAge(10);
        user.setUsed(true);
        user.setPwd("1234231");
        dao.add(user);
        return mdv;
    }
    @RequestMapping("check")
    public void check(HttpServletResponse res) {
        List<User> users = dao.findAll();
        String str = users.toString();
        try {
            res.getWriter().write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
