package com.ycfdl.springbootshardingmysqlmybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ycfdl.springbootshardingmysqlmybatisplus.entity.Book;

import java.util.List;

/**
 * @author Macky
 * @Title interface BookService
 * @Description: TODO
 * @date 2019/7/12 20:47
 */
public interface BookService extends IService<Book> {

    /**
     * 保存书籍信息
     *
     * @param book
     * @return
     */
    @Override
    boolean save(Book book);

    /**
     * 查询全部书籍信息
     *
     * @return
     */
    List<Book> getBookList();


}
