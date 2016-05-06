package com.hjw.core;

import android.app.Application;
import android.content.Context;

/**
 * HJ库的核心类
 * 1.用于给Context相关的一系列工具类提供Context对象
 * @author hjw
 * @date 2015-5-22
 */
public class HJLibrary {

    /**
     * HJLibrary实例
     */
    private static HJLibrary mInstance = new HJLibrary();

    /**
     * HJ库全局的context[为了保证全局性,必须使用Application对象来初始化该值]
     */
    private static Context context;

    private HJLibrary() {
    }

    /**
     * 获取HJLibrary实例
     * @return
     */
    public static HJLibrary getInstance()
    {
        return mInstance;
    }

    /**
     * 初始化HJ库
     * @param application
     */
    public static void init(Application application)
    {
        context = application;
    }
    
    

    /**
     * 获取Context对象
     * @return
     */
    public static Context getContext()
    {
        return context;
    }

}
