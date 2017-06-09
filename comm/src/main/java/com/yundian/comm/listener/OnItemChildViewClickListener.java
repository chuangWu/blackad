package com.yundian.comm.listener;

import android.view.View;

/**
 * @author : Created by 180
 * @version : 0.01
 * @email : yaobanglin@163.com
 * @created time : 2015-06-16 08:11
 * @describe : OnItemChildViewClickListener
 * @for your attention : none
 * @revise : none
 */
public interface OnItemChildViewClickListener {

    /**
     * item 内子控件点击事件监听回调
     * @param childView  子控件
     * @param position 索引
     * @param action 活动类型
     * @param obj  额外数据
     */
   void onItemChildViewClick(View childView, int position, int action, Object obj);
}
