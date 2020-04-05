package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller

public class registerController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @RequestMapping
    public String register(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String userphone = request.getParameter("userphone");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setUserphone(userphone);
        userMapper.save(user);
        return "register";
    }
}
