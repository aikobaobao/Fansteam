package com.fanspro.fansteam.business;

import com.fanspro.fansteam.model.ModelUser;
import com.fanspro.fansteam.model.param.ParamLogin;

/**
 * 业务类:用户
 * @author hjw
 */
public class BizUser {
	
	private static ModelUser curUser = null;
	
	
	
	/**
	 * 获取当前用户
	 * @return
	 */
	public static ModelUser getCurrentUser()
	{
		return curUser;
	}
	
	public boolean isLogined(){
		return curUser != null;
	}

	/**
	 * 自动登录
	 */
	public static void autoLogin(){
		
	}
	
	/**
	 * 登录
	 * @param paramLogin
	 */
	public static void login(ParamLogin paramLogin){
		
	}
	
	/**
	 * 注销
	 */
	public static void logout(){
		//TODO 
		curUser = null;
	}
	
}
