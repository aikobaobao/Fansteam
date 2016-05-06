package com.fanspro.fansteam.frgDialog;

import java.lang.reflect.Field;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanspro.fansteam.common.GlobalArgument;
import com.lidroid.xutils.util.LogUtils;

import de.greenrobot.event.EventBus;

/**
 * 基础的FragmentDialog
 * @author hjw
 * @date 2015-5-29
 */
public class FrgDlgBase extends DialogFragment {

    protected Activity mActivity;
    

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LogUtils.e("<<<<<<<<<<<<<<<<初始化" + this.getClass().getSimpleName()
                + " onCreate()>>>>>>>>>>>>>>");
//        mActivity = getActivity();
        EventBus.getDefault().register(this);
    }
    
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState)
    {
        if (GlobalArgument.isDebugFrgLife)
        {
            LogUtils.e(this.getClass().getSimpleName() + "  --> onCreateView()");
        }
        return super.onCreateView(inflater, container, savedInstanceState);
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
        EventBus.getDefault().unregister(this);
        super.onDestroy();
        if (GlobalArgument.isDebugFrgLife)
        {
            LogUtils.e(this.getClass().getSimpleName() + "被销毁 onDestroy()");
        }
    }
    
    

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        if (GlobalArgument.isDebugFrgLife)
        {
            LogUtils.e(this.getClass().getSimpleName() + "  -->onCreateDialog()");
        }
        return super.onCreateDialog(savedInstanceState);
    }

    public void addFragment(Fragment fragment, int containerId)
    {
        getFragmentManager().beginTransaction().add(containerId, fragment)
                .commitAllowingStateLoss();
    }

    public void replaceFragment(Fragment fragment, int containerId)
    {
        getFragmentManager().beginTransaction()
                .replace(containerId, fragment).commitAllowingStateLoss();
    }

    public void showFragment(Fragment fragment)
    {
        getFragmentManager().beginTransaction().show(fragment)
                .commitAllowingStateLoss();
    }

    public void hideFragment(Fragment fragment)
    {
        getFragmentManager().beginTransaction().hide(fragment)
                .commitAllowingStateLoss();
    }

   

   
}
