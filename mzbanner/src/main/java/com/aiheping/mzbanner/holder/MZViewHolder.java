package com.aiheping.mzbanner.holder;

import android.content.Context;
import android.view.View;

/**
 * Created by aiheping on 2020/5/20
 */

public interface MZViewHolder<T> {
    /**
     *  创建View
     * @param context
     * @return
     */
    View createView(Context context);

    /**
     * 绑定数据
     * @param context
     * @param position
     * @param data
     */
    void onBind(Context context, int position, T data);
}
