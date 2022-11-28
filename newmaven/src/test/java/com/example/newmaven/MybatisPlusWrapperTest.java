package com.example.newmaven;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.newmaven.mapper.UserMapper;
import com.example.newmaven.pojo.Player;
import com.example.newmaven.service.UserService;
import lombok.val;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest

public class MybatisPlusWrapperTest {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    public  void  test01(){
        //使用wrapper封装查询条件，然后查询
        QueryWrapper<Player> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.like("name","xw")
                .between("age",1,5);
        List<Player> players = userMapper.selectList(objectQueryWrapper);
        players.forEach(player -> System.out.println(player));
    }


    @Test
    public  void  test02(){
        //使用wrapper封装查询条件，然后查询
        QueryWrapper<Player> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.like("name","xw0");
        int i = userMapper.delete(objectQueryWrapper);
        System.out.printf("shanchu", i);
    }
    @Test
    public   void test03() {

        //将(年龄大于20并且用户名中包含a)或邮箱为空的用户信息修改
        QueryWrapper<Player> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.gt("age", 20)
                .like("name", "a")
                .or()
                .isNotNull("email");
        Player player = new Player(1L, "xw", 88, "1@qq.com");
        int update = userMapper.update(player, objectQueryWrapper);
        System.out.printf("update", update);
    }

    @Test
    public  void test04(){
        //将(年龄大于20并且用户名中包含a)或邮箱为空的用户信息修改
        UpdateWrapper<Player> objectUpdateWrapper = new UpdateWrapper<>();
        objectUpdateWrapper.like("username","a")
                .and(i->i.gt("age",20).or().isNotNull("email"));
        objectUpdateWrapper.set("username","xww").set("email","aaa@qq.com");
        int update = userMapper.update(null,objectUpdateWrapper);
        System.out.printf("update", update);

    }
}
