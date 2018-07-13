package com.reunitefamilies.reunitefamilies.adapter.models;

import android.view.View;

import com.airbnb.epoxy.EpoxyHolder;

import butterknife.ButterKnife;

public class EpoxyButterKnifeHolder extends EpoxyHolder{
    @Override
    protected void bindView(View itemView) {
        ButterKnife.bind(this, itemView);
    }
}
