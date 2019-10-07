package com.ycfdl.springbootshardingmysqlmybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ycfdl.springbootshardingmysqlmybatisplus.entity.Aa10_fd;
import com.ycfdl.springbootshardingmysqlmybatisplus.entity.Book;

import java.util.List;

/**
 * @author Macky
 * @Title interface BookService
 * @Description: TODO
 * @date 2019/7/12 20:47
 */
public interface Aa10_fdService extends IService<Aa10_fd> {

    /**
     * 查询全部书籍信息
     *
     * @return
     */
    List<Aa10_fd> getList();

}
