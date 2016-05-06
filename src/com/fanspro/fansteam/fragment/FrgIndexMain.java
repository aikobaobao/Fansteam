package com.fanspro.fansteam.fragment;

import com.fanspro.fansteam.R;
import com.lidroid.xutils.ViewUtils;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 首页-主Fragment
 * @author hjw
 */
public class FrgIndexMain extends FrgBase{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.frg_index_main, null);
		ViewUtils.inject(this, view);
		return view;
	}
	
	
}
