package com.springbootpro.ssm.com.springbootssm.config.dataSourceConfig;

import java.util.ArrayList;
import java.util.List;

public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static List<String> dataSourceIds = new ArrayList<String>();

    /**
     * 使用setDataSourceType设置当前的
     * @param dataSourceType
     */

    public static void setDataSourceType(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }



    public static String getDataSourceType() {
        return contextHolder.get();
    }



    public static void clearDataSourceType() {
        contextHolder.remove();
    }



    /**
     * 判断指定DataSrouce当前是否存在
     *
     * @param dataSourceId
     * @return
     * @author
     * @create

     */

    public static boolean containsDataSource(String dataSourceId){
        return dataSourceIds.contains(dataSourceId);
    }
}
