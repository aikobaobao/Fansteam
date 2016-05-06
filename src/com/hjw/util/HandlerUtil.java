package com.hjw.util;

import android.os.Handler;
import android.os.Looper;

/**
 * handler工具 (主线程)
 * @author hjw
 * @date 2015年3月8日
 */
public class HandlerUtil
{

	private static Handler mHandler = new Handler(Looper.getMainLooper());

	/**
	 * 将Runnable投递到主线程的消息队列中
	 * @param runnable
	 */
	public synchronized static void runOnUiThread(Runnable runnable)
	{
		mHandler.post(runnable);
	}

	/**
     * 将Runnable投递到主线程的消息队列中[位于队列头部]
     * @param runnable
     */
	public synchronized static void runOnUiThreadFrontOfQueue(Runnable runnable)
	{
		mHandler.postAtFrontOfQueue(runnable);
	}

	/**
     * 在指定时间将Runnable投递到主线程的消息队列中
     * @param runnable
     */
	public synchronized static void runOnUiThreadAtTime(Runnable runnable, long uptimeMillis)
	{
		mHandler.postAtTime(runnable, uptimeMillis);
	}

	/**
	 * 在指定时间将Runnable投递到主线程的消息队列中
	 * @param runnable
	 * @param msgObj Message对象中的obj
	 * @param uptimeMillis
	 */
	public synchronized static void runOnUiThreadAtTime(Runnable runnable, Object msgObj, long uptimeMillis)
	{
		mHandler.postAtTime(runnable, msgObj, uptimeMillis);
	}

	/**
	 * 延迟指定时间将Runnable投递到主线程的消息队列中
	 * @param runnable
	 * @param delayMillis
	 */
	public synchronized static void runOnUiThreadDelayed(Runnable runnable, long delayMillis)
	{
		mHandler.postDelayed(runnable, delayMillis);
	}

}
