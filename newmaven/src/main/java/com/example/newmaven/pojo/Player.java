package com.example.newmaven.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//设置类对应数据库的表明
@TableName("player")
@AllArgsConstructor
public class Player {
    //设置IdType.AUTO的时候，必须同时要将数据库里面的id字段设置为自动递增
    @TableId(value = "id",type = IdType.AUTO)
    private  Long id;
    private  String name;
    private Integer age;
    private String email;
}
