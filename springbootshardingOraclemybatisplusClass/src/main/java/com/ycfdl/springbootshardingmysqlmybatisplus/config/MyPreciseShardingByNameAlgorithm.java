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
public class MyPreciseShardingByNameAlgorithm implements PreciseShardingAlgorithm {
    @Override
    public String doSharding(Collection availableTargetNames, PreciseShardingValue shardingValue) {
        log.info("MyPreciseShardingAlgorithm,{} ,{} ,{}",shardingValue.getColumnName(),shardingValue.getLogicTableName(),shardingValue.getValue().toString());

        for (Object tableName : availableTargetNames) {
            String sTableName = tableName.toString();
            String sValue =shardingValue.getValue().toString();
            sValue= sValue.replace(shardingValue.getLogicTableName() +"_","");
            if (sTableName.endsWith(getTableTag(sValue))){
                return sTableName;
            }

        }
        throw new IllegalArgumentException();
    }

    private String getTableTag(String sValue){
        Integer tag = Integer.parseInt(sValue.substring(sValue.length()-1,sValue.length()));
        if (tag >=0 && tag <=3){
            tag = 0;
        }else if (tag >=4 && tag <=6) {
            tag = 1;
        }else if (tag >=7  && tag <=9){
            tag = 2;
        }
        return tag + "";
    }

    public static void main(String[] args) {
        String sValue = "name020";
        Integer tag = Integer.parseInt(sValue.substring(sValue.length()-1,sValue.length()));
        System.out.println(tag);
    }
}
