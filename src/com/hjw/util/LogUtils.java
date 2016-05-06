/***
This is free and unencumbered software released into the public domain.

Anyone is free to copy, modify, publish, use, compile, sell, or
distribute this software, either in source code form or as a compiled
binary, for any purpose, commercial or non-commercial, and by any
means.

For more information, please refer to <http://unlicense.org/>
 */

package com.hjw.util;

import android.text.TextUtils;
import android.util.Log;

/**
 * @date 21.06.2012
 * @author Mustafa Ferhan Akman
 * 
 *         Create a simple and more understandable Android logs.
 * */

public class LogUtils {
	
	private static final int ELEMENTS_INDEX = 1;
	
	public static boolean isDebug = true;
	
	/**
	 * 是否在tag里添加自定义的后缀
	 */
	public static boolean isAddTagPostfix = true;
	
	private static final String TAG_POSTFIX = "HJW";
	
	static String className;
	static String methodName;
	static int lineNumber;
	
	private LogUtils() {
		/* Protect from instantiations */
	}
	
	private static String createLog(String log)
	{
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(log);
		buffer.append("[");
		buffer.append(methodName);
		buffer.append(":");
		buffer.append(lineNumber);
		buffer.append("]");
		
		return buffer.toString();
	}
	
	private static void getMethodNames(StackTraceElement[] sElements)
	{
		if (isAddTagPostfix)
		{
			className = sElements[ELEMENTS_INDEX].getFileName() + " " + TAG_POSTFIX;
		} else
		{
			className = sElements[ELEMENTS_INDEX].getFileName();
		}
		methodName = sElements[ELEMENTS_INDEX].getMethodName();
		lineNumber = sElements[ELEMENTS_INDEX].getLineNumber();
	}
	
	public static void e(String message)
	{
		e(null, message);
	}
	
	public static void e(String tag, String message)
	{
		if (!isDebug)
			return;
		
		// Throwable instance must be created before any methods
		getMethodNames(new Throwable().getStackTrace());
		if (!TextUtils.isEmpty(tag))
		{
			className = tag + " " + className;
		}
		Log.e(className, createLog(message));
	}
	
	public static void i(String message)
	{
		i(null, message);
	}
	
	public static void i(String tag, String message)
	{
		if (!isDebug)
			return;
		
		getMethodNames(new Throwable().getStackTrace());
		if (!TextUtils.isEmpty(tag))
		{
			className = tag + " " + className;
		}
		Log.i(className, createLog(message));
	}
	
	public static void d(String message)
	{
		d(null, message);
	}
	
	public static void d(String tag, String message)
	{
		if (!isDebug)
			return;
		
		getMethodNames(new Throwable().getStackTrace());
		if (!TextUtils.isEmpty(tag))
		{
			className = tag + " " + className;
		}
		Log.d(className, createLog(message));
	}
	
	public static void v(String message)
	{
		v(null, message);
	}
	
	public static void v(String tag, String message)
	{
		if (!isDebug)
			return;
		
		getMethodNames(new Throwable().getStackTrace());
		if (!TextUtils.isEmpty(tag))
		{
			className = tag + " " + className;
		}
		Log.v(className, createLog(message));
	}
	
	public static void w(String message)
	{
		w(null, message);
	}
	
	public static void w(String tag, String message)
	{
		if (!isDebug)
			return;
		
		getMethodNames(new Throwable().getStackTrace());
		if (!TextUtils.isEmpty(tag))
		{
			className = tag + " " + className;
		}
		Log.w(className, createLog(message));
	}
	
	public static void wtf(String message)
	{
		wtf(null, message);
	}
	
	public static void wtf(String tag, String message)
	{
		if (!isDebug)
			return;
		
		getMethodNames(new Throwable().getStackTrace());
		if (!TextUtils.isEmpty(tag))
		{
			className = tag + " " + className;
		}
		Log.wtf(className, createLog(message));
	}
	
}
