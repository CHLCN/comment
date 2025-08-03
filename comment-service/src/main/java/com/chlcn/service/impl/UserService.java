package com.chlcn.service.impl;

import com.chlcn.mapper.UserMapper;
import com.chlcn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int countUserTotal() {
        return userMapper.countUserTotal();
    }
}
