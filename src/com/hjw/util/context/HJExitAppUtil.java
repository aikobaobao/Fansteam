package com.hjw.util.context;

import com.hjw.core.HJLibrary;
import com.hjw.util.HJActivityManager;

import android.content.Intent;

/**
 * 退出APP的逻辑
 * @author hjw
 * @date 2015年3月16日
 */
public class HJExitAppUtil {

    /**
     * 标记上次点击离开App的时间
     */
    private static long timeLastClickExit = -1;

    /**
     * 离开APP[需要2秒的间隔时间]
     * @param isBackground true: 转为后台  false:结束APP进程
     */
    public static void exitAppNeedIntervalTime(boolean isBackground)
    {
        if (timeLastClickExit == -1 || System.currentTimeMillis() - timeLastClickExit > 2000)
        {
            HJToast.showShort("再按一次退出!");
        } else
        {
            exitApp(isBackground);
        }
        timeLastClickExit = System.currentTimeMillis();
    }

    /**
     * 立即离开App
     *  @param isBackground true: 转为后台  false:结束APP进程
     */
    public static void exitAppAtOnce(boolean isBackground)
    {
        exitApp(isBackground);
    }

    /**
     * 退出APP
     * @param isBackground 是否结束app的虚拟机
     */
    private static void exitApp(boolean isBackground)
    {

        if (isBackground)
        {
            // 转到后台
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                    | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            HJLibrary.getContext().startActivity(intent);
        } else
        {
            // TODO finish所以Activity
            HJActivityManager.finishAllActivity();
            System.exit(0);
        }
    }

}
