package com.ycfdl.springbootshardingmysqlmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ycfdl.springbootshardingmysqlmybatisplus.mapper")
public class SpringbootshardingmysqlmybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootshardingmysqlmybatisplusApplication.class, args);
    }

}
