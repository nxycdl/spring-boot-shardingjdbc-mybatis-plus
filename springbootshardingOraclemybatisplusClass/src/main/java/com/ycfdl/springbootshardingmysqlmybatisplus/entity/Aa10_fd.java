package com.ycfdl.springbootshardingmysqlmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import groovy.transform.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Created by nxycdl on 2019/10/3 20:39.
 *
 * @author dl
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("aa10_fd")
public class Aa10_fd {
    private String aaa100;
    private String aaa103;
    private String aaa102;

}
