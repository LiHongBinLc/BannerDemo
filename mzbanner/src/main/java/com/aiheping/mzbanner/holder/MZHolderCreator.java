package com.aiheping.mzbanner.holder;

/**
 * Created by aiheping on 20/5/20.
 */

public interface MZHolderCreator<VH extends MZViewHolder> {
    /**
     * 创建ViewHolder
     * @return
     */
    public VH createViewHolder();
}
