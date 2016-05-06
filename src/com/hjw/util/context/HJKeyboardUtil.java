package com.hjw.util.context;

import android.app.Activity;
import android.content.Context;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.hjw.core.HJLibrary;

/**
 * 键盘工具类
 * @author hjw
 * @date 2015-2-11
 */
public class HJKeyboardUtil {

    /**
     * InputMethodManager.HIDE_NOT_ALWAYS  软输入窗口通常应该隐藏起来,除非它与SHOW_FORCED最初显示
     * InputMethodManager.HIDE_IMPLICIT_ONLY 软输入窗口应该只被隐藏,如果不是由用户显式地显示
     */

    /**
     * 强制显示键盘
     * @param view view为接受软键盘输入的视图
     */
    public static final void showKeyboard(View view)
    {
        InputMethodManager imm = (InputMethodManager) HJLibrary.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view,InputMethodManager.SHOW_FORCED); //SHOW_FORCED表示强制显示
    }


    /**
     * 判断键盘是否处于活动状态  
     * @return true 键盘处于打开状态   false 关闭状态  
     */
    public static boolean isActiveKeyboard()
    {
        InputMethodManager imm = (InputMethodManager) HJLibrary.getContext().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        return imm.isActive();
    }

    /**
     * 隐藏键盘
     * @param view view为接受软键盘输入的视图
     */
    public static void hideKeyboard(View view)
    {
        if (view == null)
        {
            throw new NullPointerException("view 不能为空");
        }

        InputMethodManager imm = (InputMethodManager) HJLibrary.getContext().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        boolean isOpen = imm.isActive();
        if (isOpen)
        {
            imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

            // 软输入窗口应该只被隐藏,如果不是由用户显式地显示
            // imm.hideSoftInputFromWindow(view.getWindowToken(),
            // InputMethodManager.HIDE_IMPLICIT_ONLY);
        }
    }

    /**
     * 切换键盘 [隐藏->显示, 显示->隐藏]
     * @param context
     */
    public static final void toggleKeyboard()
    {
        InputMethodManager imm = (InputMethodManager) HJLibrary.getContext().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        if (imm.isActive())
        {
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 禁用键盘[设置键盘为禁用]
     * @param activity
     */
    public static void disableKeyboard(Activity activity)
    {
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
    }

    /**
     * 启用键盘[设置键盘为可用]
     * @param activity
     */
    public static void enableKeyboard(Activity activity)
    {
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
    }

    /**
     * 禁用EditText的键盘和输入
     * @param editText
     */
    public static void disableEditTextKeyboardAndInput(EditText editText)
    {
        InputMethodManager imm = (InputMethodManager) HJLibrary.getContext().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);// 这个0是代表什么呢
        editText.setInputType(InputType.TYPE_NULL); // 设置为不能输入
    }
}
