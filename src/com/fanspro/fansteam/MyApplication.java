package com.fanspro.fansteam;

import com.hjw.core.HJLibrary;
import com.hjw.util.CrashHandler;

import android.app.Application;

/**
 * 自定义的Application
 * @author hjw
 * @date 2015-5-22
 */
public class MyApplication extends Application{

    private static MyApplication instance = null;
    
    @Override
    public void onCreate()
    {
        super.onCreate();
        instance = this;
        CrashHandler.getInstance().init(this);
        HJLibrary.init(this);
    }

    /**
     * 获取Application实例
     * @return
     */
    public static MyApplication getInstance()
    {
        return instance;
    }

    
    
}
