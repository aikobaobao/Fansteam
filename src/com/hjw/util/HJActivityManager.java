package com.hjw.util;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

/**
 * Activity管理器
 * @author hjw
 * @date 2015-5-29
 */
public class HJActivityManager {

    private static List<Activity> listAty = new ArrayList<Activity>();

    /**
     * APP中顶层的Aty,即当前Aty
     */
    private static Activity topAtyInApp = null;

    private HJActivityManager() {
    }

    // ======================需要在Aty对应的生命周期调用================================
    public static void onCreate(Activity activity)
    {
        listAty.add(activity);
    }

    public static void onResume(Activity activity)
    {
        topAtyInApp = activity;
    }

    public static void onDestroy(Activity activity)
    {
        listAty.remove(activity);
        if (activity == topAtyInApp)
        {
            topAtyInApp = null;
        }
    }
    
    //=====================================================================
    
    /**
     * 判断Activity是否为顶层Activity[当前APP内]
     * @param activity
     * @return
     */
    public static boolean isTopActivity(Activity activity){
        return activity != null && activity == topAtyInApp;
    }

    /**
     * 判断Activity对象是否存在
     * @param activity
     * @return
     */
    public static boolean isExistActivity(Activity activity)
    {
        return listAty.contains(activity);
    }

    /**
     * finish当前Aty
     */
    public static void finishLastActivity()
    {
        if (topAtyInApp != null)
        {
            listAty.remove(topAtyInApp);
            topAtyInApp.finish();
        }
    }

    /**
     * 结束指定的Activity
     */
    public static void finishActivity(Activity activity)
    {
        if (activity == null)
        {
            return;
        }

        if (activity == topAtyInApp)
        {
            topAtyInApp = null;
        }
        listAty.remove(activity);
        activity.finish();
    }

    /**
     * finish所有Activity
     */
    public static void finishAllActivity()
    {
        for (Activity activity : listAty)
        {
            if (activity != null)
            {
                activity.finish();
            }
        }
        topAtyInApp = null;
        listAty.clear();
    }

}