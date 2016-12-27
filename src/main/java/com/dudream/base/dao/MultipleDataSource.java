package com.dudream.base.dao;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultipleDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> DATA_SOURCE_TYPE_KEY = new ThreadLocal<>();

    public static void setDataSourceKey(String dataSource) {
        DATA_SOURCE_TYPE_KEY.set(dataSource);
    }

    public static String getDataSourceKey() {
        return DATA_SOURCE_TYPE_KEY.get().toString();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DATA_SOURCE_TYPE_KEY.get();
    }
}
