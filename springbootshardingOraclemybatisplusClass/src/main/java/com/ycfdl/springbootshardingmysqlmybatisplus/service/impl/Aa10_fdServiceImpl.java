package com.ycfdl.springbootshardingmysqlmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycfdl.springbootshardingmysqlmybatisplus.entity.Aa10_fd;
import com.ycfdl.springbootshardingmysqlmybatisplus.entity.Book;
import com.ycfdl.springbootshardingmysqlmybatisplus.mapper.Aa10_fdMapper;
import com.ycfdl.springbootshardingmysqlmybatisplus.mapper.BookMapper;
import com.ycfdl.springbootshardingmysqlmybatisplus.service.Aa10_fdService;
import com.ycfdl.springbootshardingmysqlmybatisplus.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Macky
 * @Title class BookServiceImpl
 * @Description: TODO
 * @date 2019/7/12 20:47
 */
@Service
public class Aa10_fdServiceImpl extends ServiceImpl<Aa10_fdMapper, Aa10_fd> implements Aa10_fdService {

    @Override
    public List<Aa10_fd> getList() {
        return baseMapper.selectList(Wrappers.<Aa10_fd>lambdaQuery());
    }



}
