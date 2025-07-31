package com.chlcn.service;

import com.chlcn.mapper.UserMapper;
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
