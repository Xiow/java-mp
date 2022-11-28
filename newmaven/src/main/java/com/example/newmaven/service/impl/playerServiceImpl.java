package com.example.newmaven.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.newmaven.mapper.UserMapper;
import com.example.newmaven.pojo.Player;
import org.springframework.stereotype.Service;
import com.example.newmaven.service.UserService;
@Service
public class playerServiceImpl  extends ServiceImpl<UserMapper, Player> implements UserService {



}
