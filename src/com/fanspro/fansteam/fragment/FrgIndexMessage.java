package com.fanspro.fansteam.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanspro.fansteam.R;
import com.lidroid.xutils.ViewUtils;

/**
 * 首页-消息Fragment
 * 
 * @author hjw
 */
public class FrgIndexMessage extends FrgBase {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.frg_index_message, null);
		ViewUtils.inject(this, view);
		return view;
	}
}
