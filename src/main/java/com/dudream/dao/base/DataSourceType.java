package com.dudream.dao.base;

public enum DataSourceType {

    Demo("demo", true);

    private String value;
    private boolean isDefault;

    DataSourceType(String value) {
        this.value = value;
        this.isDefault = false;
    }

    DataSourceType(String value, boolean isDefault) {
        this.value = value;
        this.isDefault = isDefault;
    }

    public String getValue() {
        return value;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public static DataSourceType getDefault() {
        for (DataSourceType dataSourceType : DataSourceType.values()) {
            if (dataSourceType.isDefault()) {
                return dataSourceType;
            }
        }
        return null;
    }

}
