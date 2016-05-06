package com.fanspro.fansteam.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.fanspro.fansteam.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * 自定义导航按钮
 * @author hjw
 * @date 2015-8-3
 */
public class CVNavButton extends FrameLayout {

    @ViewInject(R.id.tv_num_cvNavButton)
    private TextView tvNum;
    @ViewInject(R.id.tv_text_cvNavButton)
    private TextView tvText;
    @ViewInject(R.id.iv_icon_cvNavButton)
    private ImageView ivIcon;
    
    

    public CVNavButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.view_nav_button, this);
        ViewUtils.inject(this, view);
    }
    
    

    public void setText(CharSequence text)
    {
        tvText.setText(text);
    }
    
    public void setText(int resId){
    	tvText.setText(resId);
    }

    public void setIcon(int resId)
    {
        Drawable drawable = getContext().getResources().getDrawable(resId);
        ivIcon.setImageDrawable(drawable);
    }
    
    public void setNum(int num){
        if(num > 0){
            tvNum.setText(String.valueOf(num));
            tvNum.setVisibility(VISIBLE);
        }else{
            tvNum.setVisibility(GONE);
        }
    }

    public void setSelected(boolean isSelected){
        tvText.setSelected(isSelected);
        ivIcon.setSelected(isSelected);
    }
    

}
