package com.springbootpro.ssm.com.springbootssm.config.dataSourceConfig;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
    /**
     * 继承过来的方法，通过返回ds的key实现ds的切换（内部实现）
     * @return
     */
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}
