package com.ycfdl.springbootshardingmysqlmybatisplus.config;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

/**
 * Created by nxycdl on 2019/10/5 11:56.
 *
 * @author dl
 */
@Slf4j
public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm {
    @Override
    public String doSharding(Collection availableTargetNames, PreciseShardingValue shardingValue) {
        log.info("MyPreciseShardingAlgorithm,{} ,{} ,{}",shardingValue.getColumnName(),shardingValue.getLogicTableName(),shardingValue.getValue().toString());
        for (Object tableName : availableTargetNames) {

            String sTableName = tableName.toString();
            System.out.println(sTableName);
            if (sTableName.endsWith((int)shardingValue.getValue() % 3 + "")) {
                return sTableName;
            }
        }
        throw new IllegalArgumentException();
    }
}
