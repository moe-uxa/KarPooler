package com.eramo.karpooler.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eramo.karpooler.R;
import com.eramo.karpooler.activities.HomeActivity;
import com.eramo.karpooler.adapters.FeedsRecyclerViewAdapter;
import com.eramo.karpooler.adapters.TripsRecyclerViewAdapter;
import com.eramo.karpooler.models.dtos.FeedDTO;
import com.eramo.karpooler.models.dtos.TripDTO;

import java.util.ArrayList;

public class MyTripFragment extends BaseFragment {


    private HomeActivity activity;
    private TripsRecyclerViewAdapter tripsRecyclerViewAdapter;

    public MyTripFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_trip, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // get activity instance
        activity = (HomeActivity) getActivity();

        // prepare recycler view
        prepareFeedsRecycleView();

        // test data
        tripsRecyclerViewAdapter.addTrip(new TripDTO());
        tripsRecyclerViewAdapter.addTrip(new TripDTO());
        tripsRecyclerViewAdapter.addTrip(new TripDTO());
        tripsRecyclerViewAdapter.addTrip(new TripDTO());
        tripsRecyclerViewAdapter.addTrip(new TripDTO());
        tripsRecyclerViewAdapter.addTrip(new TripDTO());

    }

    private void prepareFeedsRecycleView(){

        RecyclerView tripsRecyclerView = (RecyclerView) activity.findViewById(R.id.recycler_view_trips);
        tripsRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity);
        tripsRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        tripsRecyclerViewAdapter = new TripsRecyclerViewAdapter(new ArrayList<TripDTO>(), this);
        tripsRecyclerView.setAdapter(tripsRecyclerViewAdapter);

    }

}
