package com.fanspro.fansteam.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hjw.core.HJLibrary;
import com.hjw.util.LogUtils;

/**
 * 基础的适配器   TODO 通过继承写一个动态布局适配器
 * @author hjw
 * @date 2015-5-7
 * @param <T>
 * 
 * 有header的情况, 使用getItem(int position)就行了,position就不会出现1的偏差
 */
public abstract class AdapterBaseForHjw<T> extends BaseAdapter {

    /**
     * 数据源[列表的Item实体]
     */
    protected List<T> listItemModel = null;
    protected LayoutInflater inflater;
    protected Context context;

    /**
     * Item的布局ID
     */
    protected final int itemLayoutId;

    /**
     * 默认的展示Item的数量限制 : 没有限制
     */
    private static final int NUM_DEFAULT_DIAPLAY_NO_LIMIT = -1;

    /**
     * 展示Item的数量限制
     */
    protected int maxDisplayNum = NUM_DEFAULT_DIAPLAY_NO_LIMIT;

    /**
     * 不需要Activity对象时适合使用该适配器
     * @param itemLayoutId
     */
    public AdapterBaseForHjw(int itemLayoutId) {
        this(HJLibrary.getContext(), itemLayoutId);
    }

    /**
     * 不需要Activity对象时适合使用该适配器
     * @param listItemModel
     * @param itemLayoutId
     */
    public AdapterBaseForHjw(List<T> listItemModel, int itemLayoutId) {
        this(HJLibrary.getContext(), listItemModel, itemLayoutId);
    }

    public AdapterBaseForHjw(Context context, int itemLayoutId) {
        this(context, null, itemLayoutId);
    }

    public AdapterBaseForHjw(Context context, List<T> listItemModel, int itemLayoutId) {
        if (listItemModel == null)
        {
            LogUtils.e(this.getClass().getSimpleName() + " listItemModel 为null");
            this.listItemModel = new ArrayList<T>();
        } else
        {
            this.listItemModel = listItemModel;
        }
        this.context = context;
        this.itemLayoutId = itemLayoutId;
        this.inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount()
    {
        if (maxDisplayNum != NUM_DEFAULT_DIAPLAY_NO_LIMIT && listItemModel.size() > maxDisplayNum)
        {
            // 有数量限制
            return maxDisplayNum;
        } else
        {
            // 无数量限制
            return listItemModel.size();
        }
    }

    @Override
    public T getItem(int position)
    {

        if (position < 0 || position >= listItemModel.size())
        {
            throw new IllegalArgumentException("position 错误  pos: " + position);
        }

        return listItemModel.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            convertView = inflater.inflate(itemLayoutId, null);
        }
        itemViewOpt(convertView, getItem(position), position);
        return convertView;
    }

    /**
     * 获取对应位置的View [非setAdapter用法,即没有view缓存]
     * @param position
     * @return
     */
    public View getView(int position)
    {
        return getView(position, null, null);
    }

    public List<T> getListItemModel()
    {
        return listItemModel;
    }

    // ======================================================================

    /**
     * 对Item的View进行相关操作[数据展示]
     * @param convertView
     * @param model
     * @param position TODO
     */
    protected abstract void itemViewOpt(View convertView, T model, int position);

    // ==============================工具方法=======================================

    /**
     * ViewHolder极简写法
     * @param convertView
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
    protected static <T extends View> T getAdapterView(View convertView, int id)
    {
        // android提供的SparseArray这个类，和Map类似，但是比Map效率，不过键只能为Integer.
        SparseArray<View> viewHolder = (SparseArray<View>) convertView.getTag();
        if (viewHolder == null)
        {
            viewHolder = new SparseArray<View>();
            convertView.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (childView == null)
        {
            childView = convertView.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }

    /**
     * 移除实体并刷新适配器数据
     * @param model
     * @return
     */
    public boolean removeModelAndRefresh(T model)
    {
        boolean isRemoveSuccess = listItemModel.remove(model);
        notifyDataSetChanged();
        return isRemoveSuccess;
    }

    /**
     * 通知更新数据
     * @param listNewData
     * @param isClearOldData
     */
    public <K extends T> void notifyDataRefresh(List<K> listNewData, boolean isClearOldData)
    {
        if (isClearOldData)
        {
            listItemModel.clear();
        }
        if (listNewData != null && listNewData.size() > 0)
        {
            listItemModel.addAll(listNewData);
        }
        notifyDataSetChanged();
    }

    /**
     * 通知更新数据 [会清空原有列表数据]
     * @param listNewData
     */
    public <K extends T> void notifyDataRefresh(List<K> listNewData)
    {
        notifyDataRefresh(listNewData, true);
    }
    
    /**
     * 清空数据并刷新
     */
    public void clear(){
        if(listItemModel != null){
            listItemModel.clear();
            notifyDataSetChanged();
        }
    }

}
