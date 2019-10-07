package com.ycfdl.springbootshardingmysqlmybatisplus;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication
@MapperScan("com.ycfdl.springbootshardingmysqlmybatisplus.mapper")
public class SpringbootshardingmysqlmybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootshardingmysqlmybatisplusApplication.class, args);
    }

}
