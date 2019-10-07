package com.ycfdl.springbootshardingmysqlmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import groovy.transform.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Macky
 * @Title class Book
 * @Description: 书籍是实体类
 * @date 2019/7/13 15:23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("book")
public class Book extends Model<Book> {
    private int id;
    private String name;
    private int cnt;
}
