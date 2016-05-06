package com.fanspro.fansteam.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;

import com.fanspro.fansteam.R;
import com.fanspro.fansteam.fragment.FrgBase;
import com.fanspro.fansteam.fragment.FrgIndexAnnunciate;
import com.fanspro.fansteam.fragment.FrgIndexMain;
import com.fanspro.fansteam.fragment.FrgIndexMe;
import com.fanspro.fansteam.fragment.FrgIndexMessage;
import com.fanspro.fansteam.view.CVNavButton;
import com.hjw.util.HJActivityManager;
import com.hjw.util.context.HJExitAppUtil;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * 首页
 * 
 * @author hjw
 * @date 2015年6月2日
 */
public class AtyIndex extends AtyBase {
	
	@ViewInject(R.id.cv_index_atyMain)
	private CVNavButton cvIndex;
	@ViewInject(R.id.cv_annunciate_atyMain)
	private CVNavButton cvAnnunciate;
	@ViewInject(R.id.cv_message_atyMain)
	private CVNavButton cvMessage;
	@ViewInject(R.id.cv_me_atyMain)
	private CVNavButton cvMe;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aty_index);
		init();
	}
	
	private void init()
	{
		cvIndex.setText(R.string.index);
		cvIndex.setIcon(R.drawable.sel_ic_index_tab_home);
		
		cvAnnunciate.setText(R.string.annunciate);
		cvAnnunciate.setIcon(R.drawable.sel_ic_index_tab_annunciate);
		
		cvMessage.setText(R.string.message);
		cvMessage.setIcon(R.drawable.sel_ic_index_tab_message);
		
		cvMe.setText(R.string.me);
		cvMe.setIcon(R.drawable.sel_ic_index_tab_me);
		
		// 默认选择首页
		onIndexClicked(cvIndex);
		
		// 友盟检测更新
		// int minVersion =
		// HJSharedPreferenceUtil.getInt(SPKey.SP_ALLOW_MIN_VERSION_CODE, 1);
		// int curVersion = HJDeviceInfoUtil.getVersionCode();
		// boolean isForce = curVersion < minVersion;
		// UmengUpdateUtils.checkUpdate(isForce, isForce);
		
	}
	
	private FrgIndexMain frgMain;
	private FrgIndexAnnunciate frgAnnunciate;
	private FrgIndexMessage frgMessage;
	private FrgIndexMe frgMe;
	
	
	
	@OnClick(R.id.cv_index_atyMain)
	private void onIndexClicked(View v)
	{
		toggleNavButtonStatus(v.getId());
		if (frgMain == null)
		{
			frgMain = new FrgIndexMain();
			listFrg.add(frgMain);
			addFragment(frgMain, R.id.flyt_content_atyIndex);
		}
		toggleFrg(frgMain);
//		setTitleBarType(TypeTitleBar.TYPE_NONE);
	}
	
	@OnClick(R.id.cv_annunciate_atyMain)
	private void onClickFriendStreet(View v)
	{
		toggleNavButtonStatus(v.getId());
		if (frgAnnunciate == null)
		{
			frgAnnunciate = new FrgIndexAnnunciate();
			listFrg.add(frgAnnunciate);
			addFragment(frgAnnunciate, R.id.flyt_content2_atyIndex);
		}
		toggleFrg(frgAnnunciate);
		
	}
	
	@OnClick(R.id.cv_message_atyMain)
	private void onClickShopCart(View v)
	{
		toggleNavButtonStatus(v.getId());
		if (frgMessage == null)
		{
			frgMessage = new FrgIndexMessage();
			listFrg.add(frgMessage);
			addFragment(frgMessage, R.id.flyt_content2_atyIndex);
		}
		toggleFrg(frgMessage);
	}
	
	private List<FrgBase> listFrg = new ArrayList<FrgBase>();
	
	@OnClick(R.id.cv_me_atyMain)
	private void onClickUserCenter(View v)
	{
		toggleNavButtonStatus(v.getId());
		if (frgMe == null)
		{
			frgMe = new FrgIndexMe();
			listFrg.add(frgMe);
			addFragment(frgMe, R.id.flyt_content2_atyIndex);
		}
		toggleFrg(frgMe);
	}
	
	private void toggleFrg(FrgBase frgSelected)
	{
		for (FrgBase frgBase : listFrg)
		{
			if (frgSelected != frgBase && frgBase.isVisible())
			{
				hideFragment(frgBase);
			}
		}
		
		if (!frgSelected.isVisible())
		{
			showFragment(frgSelected);
		}
	}
	
	private void toggleNavButtonStatus(int curNavResId)
	{
		cvAnnunciate.setSelected(cvAnnunciate.getId() == curNavResId);
		cvIndex.setSelected(cvIndex.getId() == curNavResId);
		cvMessage.setSelected(cvMessage.getId() == curNavResId);
		cvMe.setSelected(cvMe.getId() == curNavResId);
	}
	
	
	@Override
	public void onBackPressed()
	{
		HJExitAppUtil.exitAppNeedIntervalTime(false);
	}
	
}
