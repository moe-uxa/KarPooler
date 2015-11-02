package com.eramo.karpooler.fragments;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eramo.karpooler.R;
import com.eramo.karpooler.activities.HomeActivity;
import com.eramo.karpooler.adapters.TripsRecyclerViewAdapter;
import com.eramo.karpooler.helpers.Constants;
import com.eramo.karpooler.models.dtos.TripDTO;


import java.util.ArrayList;
import java.util.List;

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
        List<TripDTO> trips = new ArrayList<>();
        trips.add(createTestTrip("Trip1", "4/2015", "cairo - alex", Constants.TRIP_EXPIRED_STATE));
        trips.add(createTestTrip("Trip2", "9/2015", "aswan - alex", Constants.TRIP_UPCOMING_STATE));
        trips.add(createTestTrip("Trip3", "10/2015", "mansora - alex", Constants.TRIP_EXPIRED_STATE));
        trips.add(createTestTrip("Trip4", "7/2015", "port said - alex", Constants.TRIP_ONGOING_STATE));
        trips.add(createTestTrip("Trip5", "12/2015", "fayoum - alex", Constants.TRIP_UPCOMING_STATE));
        trips.add(createTestTrip("Trip6", "1/2015", "ismalia - alex", Constants.TRIP_UPCOMING_STATE));
        tripsRecyclerViewAdapter.addTrips(trips);

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

    private TripDTO createTestTrip(String name, String date, String fromTo, int state){

        TripDTO tripDTO1 = new TripDTO();
        tripDTO1.setTripName(name);
        tripDTO1.setTripDate(date);
        tripDTO1.setTripFromTo(fromTo);
        tripDTO1.setTripState(state);

        // set passengers images
        List<Bitmap> passengers = new ArrayList<>();
        passengers.add(((BitmapDrawable) getResources().getDrawable(R.drawable.person2)).getBitmap());
        passengers.add(((BitmapDrawable) getResources().getDrawable(R.drawable.person3)).getBitmap());
        passengers.add(((BitmapDrawable) getResources().getDrawable(R.drawable.person4)).getBitmap());
        passengers.add(((BitmapDrawable) getResources().getDrawable(R.drawable.person5)).getBitmap());
        passengers.add(((BitmapDrawable) getResources().getDrawable(R.drawable.person6)).getBitmap());
        passengers.add(((BitmapDrawable) getResources().getDrawable(R.drawable.person6)).getBitmap());
        passengers.add(((BitmapDrawable) getResources().getDrawable(R.drawable.person1)).getBitmap());
        passengers.add(((BitmapDrawable) getResources().getDrawable(R.drawable.person3)).getBitmap());
        passengers.add(((BitmapDrawable) getResources().getDrawable(R.drawable.person4)).getBitmap());
        tripDTO1.setPassengers(passengers);

        return tripDTO1;
    }

}
