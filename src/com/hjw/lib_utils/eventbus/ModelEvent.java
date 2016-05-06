package com.hjw.lib_utils.eventbus;

/**
 * 自定义的EventBus事件模型
 * @author hjw
 * @date 2015-5-22
 */
public class ModelEvent
{
	
	
	/**
	 * 事件标记
	 */
	private EventTag eventTag;
	
	/**
	 * 事件附带的数据
	 */
	protected Object eventData = null;

	public ModelEvent(EventTag eventTag, Object eventData)
	{
		this.eventTag = eventTag;
		this.eventData = eventData;
	}


	public EventTag getEventTagInt()
	{
		return eventTag;
	}

	public void setEventTagInt(EventTag eventTag)
	{
		this.eventTag = eventTag;
	}

	public Object getEventData()
	{
		return eventData;
	}

	public void setEventData(Object eventData)
	{
		this.eventData = eventData;
	}


}
