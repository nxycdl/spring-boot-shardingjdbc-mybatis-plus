package com.ycfdl.springbootshardingmysqlmybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ycfdl.springbootshardingmysqlmybatisplus.entity.Book;
import com.ycfdl.springbootshardingmysqlmybatisplus.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Macky
 * @Title class BookController
 * @Description: TODO
 * @date 2019/7/12 20:53
 */
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * 遍历所有的库，所有的表;
     * @return
     * Actual SQL: db0 ::: SELECT  id,name,count  FROM book_0
     * Actual SQL: db0 ::: SELECT  id,name,count  FROM book_1
     * Actual SQL: db0 ::: SELECT  id,name,count  FROM book_2
     * Actual SQL: db1 ::: SELECT  id,name,count  FROM book_0
     * Actual SQL: db1 ::: SELECT  id,name,count  FROM book_1
     * Actual SQL: db1 ::: SELECT  id,name,count  FROM book_2
     * Actual SQL: db2 ::: SELECT  id,name,count  FROM book_0
     * Actual SQL: db2 ::: SELECT  id,name,count  FROM book_1
     * Actual SQL: db2 ::: SELECT  id,name,count  FROM book_2
     */
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public List<Book> getItems(){
        return bookService.getBookList();
    }

    /**
     * 遍历单个库下面的所有表；
     * @param id
     * @return
     * Actual SQL: db2 ::: SELECT id,name,count FROM book_0 WHERE id=?  ::: [[8]]
     * Actual SQL: db2 ::: SELECT id,name,count FROM book_1 WHERE id=?  ::: [[8]]
     * Actual SQL: db2 ::: SELECT id,name,count FROM book_2 WHERE id=?  ::: [[8]]
     */
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public Book getItems(@PathVariable Integer id){
        return bookService.getById(id);
    };

    /**
     *
     * @param id
     * @param count
     * @return
     * 直接定位到单个数据下的，单个表；
     * Actual SQL: db2 ::: SELECT  id,name,count  FROM book_1  WHERE id = ? AND count = ? ::: [[8, 19]]
     */
    @RequestMapping(value = "/book/{id}/{count}", method = RequestMethod.GET)
    public Book getItems(@PathVariable Integer id, @PathVariable Integer count){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        queryWrapper.eq("count", count);

        return bookService.getOne(queryWrapper);
    };

    /**
     * 遍历所有数据库的 单个表；
     * @param count
     * @return
     */
    @RequestMapping(value = "/bookc/{count}", method = RequestMethod.GET)
    public Book getItemsCount(@PathVariable Integer count){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("count", count);
        return bookService.getOne(queryWrapper);
    };

    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public Boolean saveItem(Book book){
        return bookService.save(book);
    }

    @RequestMapping(value = "/book2",method = RequestMethod.GET)
    public Boolean save2Item(){
        List<Book> list = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i ++ ){
            Book book = new Book(i,"book" + i, i + 10);
            list.add(book);
        }

        return bookService.saveBatch(list);
    }
}
