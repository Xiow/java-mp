package com.example.newmaven.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.example.newmaven.pojo.Player;
import org.springframework.stereotype.Repository;

import javax.xml.transform.sax.SAXResult;

//使用mybatis提供的通用的BaseMapper
@Repository
public interface UserMapper extends BaseMapper<Player> {


    Player xwSelectOne(long id);
}
