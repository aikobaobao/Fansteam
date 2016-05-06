package com.hjw.lib_utils.eventbus;

import de.greenrobot.event.EventBus;

/**
 * EventBus管理器
 * @author hjw
 * @date 2015-5-22
 */
public class EventBusManager
{


	/**
	 * 获取EventBus对象实例
	 * @return
	 */
	public static EventBus getEventBus()
	{
		return EventBus.getDefault();
	}

	/**
	 * 注册订阅者
	 * @param subscriber
	 */
	public static void register(Object subscriber)
	{
		getEventBus().register(subscriber);
	}

	/**
	 * 注销订阅者
	 * @param subscriber
	 */
	public static void unregister(Object subscriber)
	{
		getEventBus().unregister(subscriber);
	}

	/**
	 * 投递Event
	 * @param event
	 */
	public static void post(ModelEvent event)
	{
		EventBus.getDefault().post(event);
	}

	/**
	 *  投递Event
	 * @param eventTag
	 */
	public static void post(EventTag eventTag)
	{
		post(eventTag, null);
	}

	/**
	 *  投递Event
	 * @param eventTag
	 * @param eventData
	 */
	public static void post(EventTag eventTag, Object eventData)
	{
		post(new ModelEvent(eventTag, eventData));
	}

}
