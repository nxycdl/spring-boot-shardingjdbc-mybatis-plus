package com.ycfdl.springbootshardingmysqlmybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ycfdl.springbootshardingmysqlmybatisplus.entity.Aa10_fd;
import com.ycfdl.springbootshardingmysqlmybatisplus.entity.Book;
import com.ycfdl.springbootshardingmysqlmybatisplus.service.Aa10_fdService;
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

    @Autowired
    Aa10_fdService aa10_fdService;

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

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Book getByName(@PathVariable String name){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        return bookService.getOne(queryWrapper);
    };

    @RequestMapping(value = "/name/in", method = RequestMethod.GET)
    public List<Book> getByNameIn(){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("name","book1","book2","book9");
        return bookService.list(queryWrapper);
    };

    @RequestMapping(value = "/name/in2", method = RequestMethod.GET)
    public List<Book> getByNameIn2(){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < 15; i++){
            list.add("book" + i);
        }
        queryWrapper.in("name",list);
        return bookService.list(queryWrapper);
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
        queryWrapper.eq("cnt", count);

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
        queryWrapper.eq("cnt", count);
        return bookService.getOne(queryWrapper);
    };

    @RequestMapping(value = "/bookc/{count1}/{count2}", method = RequestMethod.GET)
    public List<Book> getItemsCount(@PathVariable Integer count1,@PathVariable Integer count2){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("cnt",count1,count2);
        return bookService.list(queryWrapper);
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

    @RequestMapping(value = "/aa10", method = RequestMethod.GET)
    public List<Aa10_fd> getAa10List(){
        return aa10_fdService.getList();
    }
}
