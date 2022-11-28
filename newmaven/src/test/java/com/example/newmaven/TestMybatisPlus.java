package com.example.newmaven;


import com.example.newmaven.mapper.UserMapper;
import com.example.newmaven.pojo.Player;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.newmaven.service.UserService;

import java.util.*;

@SpringBootTest
public class TestMybatisPlus {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;


    //批量添加数据
    @Test
    public void  TestMybatisServiceSaveBatch(){
        ArrayList<Player> objects = new ArrayList<>();
        for(int i=0;i<8;i++){
            Player player=new Player(null,"xw"+i,i,"qq@com");
            objects.add(player);
        }
        boolean b = userService.saveBatch(objects);
        System.out.println(b);
    }

    @Test
    public void   mybatisServicetest(){
        long count = userService.count();
        System.out.println(count);
    }

    //CRUD返回都是受影响的行数
    @Test
    public  void  TestSelectList(){
        List<Player> players = userMapper.selectList(null);
        players.forEach(player -> System.out.println(player));
    }
    @Test
    public  void TestInsertPlayer(){
        Player player=new Player(null,"大卫",999,"dawei@sina.com");
        int insert = userMapper.insert(player);
        System.out.println(insert);
    }
    @Test
    public void TestDeletePlayerById() {
//        val i = userMapper.deleteById(1);
//        System.out.println(i);

        //根据map删除数据
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Tom");
        map.put("age", 28);
        int i1 = userMapper.deleteByMap(map);
        System.out.println(i1);
    }
    @Test
    public void TestDeletePlayByBatch(){
        //id批量删除数据
        List<Long> longs = Arrays.asList(10L, 20L, 30L);
        int i = userMapper.deleteBatchIds(longs);
        System.out.println(i);
    }

    //根据Id 修改数据
    @Test
    public  void   TestUpdatePlayById(){
        Player player=new Player(40L,"SandyFather",999,"SandyFather@qqcom.com");
        val i = userMapper.updateById(player);
        System.out.printf("受影响的行数:", i);
    }
    //SelectPlayer

    @Test
    public void TestSelectPlayer(){
        Player player = userMapper.selectById(50L);
        System.out.println(player);
        //根据Id批量查询数据
        List<Long> longs = Arrays.asList(4L, 5L, 40L, 50L);
        List<Player> players = userMapper.selectBatchIds(longs);
        players.forEach(player1 -> System.out.println(player1));

        //根据map查找数据
      Map<String,Object> map=new HashMap<>();
      map.put("name","Billie");
        val players1 = userMapper.selectByMap(map);
        players1.forEach(player1 -> System.out.println(player1));
    }
    @Test
    public void  Testxw(){
        val player = userMapper.xwSelectOne(4L);
        System.out.println(player);
    }




}
