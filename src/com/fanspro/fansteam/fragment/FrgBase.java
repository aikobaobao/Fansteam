package com.fanspro.fansteam.fragment;

import java.lang.reflect.Field;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.fanspro.fansteam.common.GlobalArgument;
import com.hjw.core.HJLibrary;
import com.hjw.util.LogUtils;

import de.greenrobot.event.EventBus;

/**
 * 基础的Fragment
 * @author hjw
 * @date 2015-5-29
 */
public class FrgBase extends Fragment {

    protected Activity mActivity;

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        LogUtils.e(this.getClass().getSimpleName() + " onAttach()>>>>>>>>>>>>>>");
        mActivity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LogUtils.e("<<<<<<<<<<<<<<<<初始化" + this.getClass().getSimpleName() + " onCreate()>>>>>>>>>>>>>>");
//        EventBus.getDefault().register(this);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        if (GlobalArgument.isDebugFrgLife)
        {
            LogUtils.e(this.getClass().getSimpleName() + "转到前台onResume()");
        }
    }

    @Override
    public void onDestroy()
    {
//        EventBus.getDefault().unregister(this);
        super.onDestroy();
        if (GlobalArgument.isDebugFrgLife)
        {
            LogUtils.e(this.getClass().getSimpleName() + "被销毁 onDestroy()");
        }
    }

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

    

   

  

    /**
     * 将Frg内容与标题栏进行组合
     * @param contentView
     * @param titleView
     * @return
     */
    public static View wrapperTitle(View contentView, View titleView)
    {
        LinearLayout llytRoot = new LinearLayout(HJLibrary.getContext());
        llytRoot.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams paramsTitle = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams paramsContent = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        llytRoot.addView(titleView, paramsTitle);
        llytRoot.addView(contentView, paramsContent);
        return llytRoot;
    }

  
}
