package com.dudream.service.impl;

import com.dudream.dao.UserDao;
import com.dudream.model.User;
import com.dudream.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dudream on 2016/12/27.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(Long userId) {
        return userDao.getById(userId);
    }

}
