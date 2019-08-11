package com.tobeng.example.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * 自定义分片算法
 */
public class MyPreciseAlgorithm implements PreciseShardingAlgorithm<Long> {

    /**
     * 分片算法
     *
     * @param collection 数据源或表的名称
     * @param preciseShardingValue 分片值
     * @return 数据源或表名的分片结果
     */
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        for (String tableName : collection) {
            if (tableName.endsWith(preciseShardingValue.getValue() % 4 + "")) {
                System.out.println("数据库表名：" + tableName);
                return tableName;
            }
        }
        throw new IllegalArgumentException();
    }
}
