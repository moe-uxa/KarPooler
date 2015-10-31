package com.eramo.karpooler.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eramo.karpooler.R;
import com.eramo.karpooler.activities.HomeActivity;
import com.eramo.karpooler.adapters.BrandsRecyclerViewAdapter;
import com.eramo.karpooler.adapters.FeedsRecyclerViewAdapter;
import com.eramo.karpooler.models.dtos.BrandDTO;
import com.eramo.karpooler.models.dtos.FeedDTO;
import com.eramo.karpooler.models.dtos.GroupCreationFeedDTO;
import com.eramo.karpooler.models.dtos.TripCreationFeedDTO;
import com.eramo.karpooler.models.dtos.UpdateStatusFeedDTO;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends BaseFragment {

    HomeActivity activity;

    public FeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // get activity instance
        activity = (HomeActivity) getActivity();

        prepareFeedsRecycleView();

    }

    private void prepareFeedsRecycleView(){

        RecyclerView feedsRecyclerView = (RecyclerView) activity.findViewById(R.id.recycler_view_feeds);
        feedsRecyclerView.setHasFixedSize(true);


        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity);
        feedsRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        FeedsRecyclerViewAdapter feedsRecyclerViewAdapter = new FeedsRecyclerViewAdapter(new ArrayList<FeedDTO>());
        feedsRecyclerView.setAdapter(feedsRecyclerViewAdapter);

        feedsRecyclerViewAdapter.addFeed(new TripCreationFeedDTO());
        feedsRecyclerViewAdapter.addFeed(new TripCreationFeedDTO());
        feedsRecyclerViewAdapter.addFeed(new GroupCreationFeedDTO());
        feedsRecyclerViewAdapter.addFeed(new GroupCreationFeedDTO());
        feedsRecyclerViewAdapter.addFeed(new GroupCreationFeedDTO());
        feedsRecyclerViewAdapter.addFeed(new UpdateStatusFeedDTO());

    }

}
