package com.eramo.karpooler.viewHolders;

import android.support.v4.app.Fragment;
import android.view.View;

import com.eramo.karpooler.models.dtos.FeedDTO;

/**
 * Created by Mohamed.Gaber on 10/30/2015.
 */
public class UpdateStatusViewHolder extends FeedViewHolder{

    public UpdateStatusViewHolder(View view, Fragment fragment) {
        super(view);

        this.fragment = fragment;
    }

    @Override
    public void onBindViewHolder(FeedDTO feedDTO) {
        super.onBindViewHolder(feedDTO);

    }
}
