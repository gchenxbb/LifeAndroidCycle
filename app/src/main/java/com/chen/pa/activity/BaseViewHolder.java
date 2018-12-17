package com.chen.pa.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chen.pa.R;

public class BaseViewHolder extends RecyclerView.ViewHolder {
    protected Context mContext;
    protected TextView mTextView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        mTextView = (TextView) itemView.findViewById(R.id.tv_rcl_item);
    }

}
