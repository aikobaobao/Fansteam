package com.fanspro.fansteam.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.hjw.util.HJActivityManager;
import com.hjw.util.LogUtils;
import com.lidroid.xutils.ViewUtils;

import de.greenrobot.event.EventBus;

/**
 * 基础的Activity
 * @author hjw
 * @date 2015-5-22
 */
public abstract class AtyBase extends Activity {

    protected Activity mActivity;


    public AtyBase() {
        super();
        mActivity = this;
        LogUtils.e("<<<<<<<<<<<<<<<<初始化" + this.getClass().getSimpleName() + " ("
                + this.getClass().getPackage().getName() + ")" + ">>>>>>>>>>>>>>");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        LogUtils.e(this.getClass().getSimpleName() + " -->  onCreate()");
        super.onCreate(savedInstanceState);
        HJActivityManager.onCreate(this);

//        EventBus.getDefault().register(this);

    }



    @Override
    public void setContentView(int layoutResID)
    {
        super.setContentView(layoutResID);
        // xutils反射注入view与事件
        ViewUtils.inject(this);
    }

    

    @Override
    protected void onStart()
    {
        super.onStart();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        HJActivityManager.onResume(this);
        LogUtils.e(this.getClass().getSimpleName() + " -->  onResume()");
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        LogUtils.e(this.getClass().getSimpleName() + " -->  onPause()");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        LogUtils.e(this.getClass().getSimpleName() + " -->  onStop()");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        HJActivityManager.onDestroy(this);
//        EventBus.getDefault().unregister(this);
        LogUtils.e(this.getClass().getSimpleName() + " -->  onDestroy()");
    }

    

    /**
     * 点击"刷新"按钮 时的回调
     */
    protected void onRefreshBtnClicked()
    {
        // 默认调用onLoadData()
        onLoadData();
    }

    /**
     * "404/没有网络"时点击 重新加载时的回调
     */
    protected void onLoadData()
    {
    }

 

    // =========================Frg操作=================
    public void addFragment(Fragment fragment, int containerId)
    {
        getFragmentManager().beginTransaction().add(containerId, fragment).commitAllowingStateLoss();
    }

    public void replaceFragment(Fragment fragment, int containerId)
    {
        getFragmentManager().beginTransaction().replace(containerId, fragment).commitAllowingStateLoss();
    }

    public void showFragment(Fragment fragment)
    {
        getFragmentManager().beginTransaction().show(fragment).commitAllowingStateLoss();
    }

    public void hideFragment(Fragment fragment)
    {
        getFragmentManager().beginTransaction().hide(fragment).commitAllowingStateLoss();
    }

    public void attachFragment(Fragment fragment)
    {
        getFragmentManager().beginTransaction().attach(fragment).commitAllowingStateLoss();
    }

   

   

   
}
