package com.hjw.lib_utils.eventbus;

/**
 * 与自定义的EventBus事件模型相对应的订阅函数接口
 * @author hjw
 * @date 2015-5-22
 */
public interface IEventObserver
{
	
	/**
	 * 在对应的线程回调
	 * @param event
	 */
	public void onEvent(ModelEvent event);

	/**
	 * 在主线程回调
	 * @param event
	 */
	public void onEventMainThread(ModelEvent event);

	/**
	 * 在子线程回调
	 * @param event
	 */
	public void onEventBackgroundThread(ModelEvent event);

	/**
	 * 始终在新建的子线程回调
	 * @param event
	 */
	public void onEventAsync(ModelEvent event);
}
