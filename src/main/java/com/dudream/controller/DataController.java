package com.dudream.controller;

import com.dudream.model.User;
import com.dudream.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dudream on 2016/12/27.
 */
@RestController
@RequestMapping(path = "/data")
public class DataController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/user")
    public String get(@RequestParam("userId") Long userId) {
        User user = userService.getUser(userId);

        return user.getUserName();
    }

}
