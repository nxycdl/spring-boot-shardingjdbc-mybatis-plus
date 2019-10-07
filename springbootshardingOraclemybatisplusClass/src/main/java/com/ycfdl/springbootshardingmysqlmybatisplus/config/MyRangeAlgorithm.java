package com.ycfdl.springbootshardingmysqlmybatisplus.config;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Range;
import io.shardingsphere.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.RangeShardingAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by nxycdl on 2019/10/5 14:41.
 *
 * @author dl
 */
@Slf4j
public class MyRangeAlgorithm implements RangeShardingAlgorithm<Integer>{
    @Override
    public Collection<String> doSharding(Collection collection, RangeShardingValue rangeShardingValue) {

        log.info("MyRangeAlgorithm,{} ,{} ,{}",rangeShardingValue.getColumnName(),rangeShardingValue.getLogicTableName(),rangeShardingValue.getValueRange().toString());
        log.info("Range collection:" + JSON.toJSONString(collection) + ",rangeShardingValue:" + JSON.toJSONString(rangeShardingValue));
        Collection<String> collect = new ArrayList<>();
        Range<Integer> valueRange = rangeShardingValue.getValueRange();
        for (Integer i = valueRange.lowerEndpoint(); i <= valueRange.upperEndpoint(); i++) {

            for (Object sEach : collection) {

                String each = sEach.toString();
                if (each.endsWith(i % collection.size() + "")) {
                    collect.add(each);
                }
            }
        }
        return collect;
    }
}

