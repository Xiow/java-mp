package com.example.newmaven;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//
@MapperScan(value ="com.example.newmaven.mapper" )
public class NewmavenApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewmavenApplication.class, args);
    }

}
