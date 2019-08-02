package com.example.datatablesserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.datatablesserver.entity.User;
import com.example.datatablesserver.mapper.UserMapper;
import com.example.datatablesserver.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Eddy
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
