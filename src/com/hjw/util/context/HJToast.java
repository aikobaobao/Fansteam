package com.hjw.util.context;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.hjw.core.HJLibrary;
import com.hjw.util.LogUtils;

/**
 * Toast工具类[可以直接在各个线程调用]
 * 
 * @author hjw
 * @date 2015-5-22
 */
public class HJToast {

	private static Handler mHandler = new Handler(Looper.getMainLooper());

	public static void showLong(CharSequence content)
	{
		showToast(HJLibrary.getContext(), content, Toast.LENGTH_LONG);
	}

	public static void showShort(CharSequence content)
	{
		showToast(HJLibrary.getContext(), content, Toast.LENGTH_SHORT);
	}

	public static void showLong(Context context, CharSequence content)
	{
		showToast(context, content, Toast.LENGTH_LONG);
	}

	public static void showShort(Context context, CharSequence content)
	{
		showToast(context, content, Toast.LENGTH_SHORT);
	}

	private static void showToast(final Context context,
			final CharSequence text, final int duration)
	{
		LogUtils.e("showToast: " + text);
		if (Looper.myLooper() == Looper.getMainLooper())
		{
			Toast.makeText(context, text, duration).show();
		} else
		{
			mHandler.post(new Runnable() {
				@Override
				public void run()
				{
					Toast.makeText(context, text, duration).show();
				}
			});
		}
	}

}
