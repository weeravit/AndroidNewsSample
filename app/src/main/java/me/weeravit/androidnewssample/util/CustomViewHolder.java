package me.weeravit.androidnewssample.util;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by weeravit on 2/3/2017 AD.
 */

public class CustomViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding mViewDataBinding;

    public CustomViewHolder(ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
        mViewDataBinding = viewDataBinding;
    }

    public ViewDataBinding getViewDataBinding() {
        return mViewDataBinding;
    }

}
