package com.eramo.karpooler.fragments;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eramo.karpooler.R;
import com.eramo.karpooler.activities.TripMatchesActivity;
import com.eramo.karpooler.adapters.TripMatchesRecyclerViewAdapter;
import com.eramo.karpooler.adapters.TripsRecyclerViewAdapter;
import com.eramo.karpooler.models.dtos.TripDTO;
import com.eramo.karpooler.models.dtos.TripMatchDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TripMatchesFragment extends Fragment {

    private TripMatchesActivity activity;
    private TripMatchesRecyclerViewAdapter tripMatchesRecyclerViewAdapter;
    private RecyclerView tripMatchesRecyclerView;
    private int dayOffset;

    public TripMatchesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trip_matches, container, false);

        tripMatchesRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_trip_matches);


        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // get activity instance
        activity = (TripMatchesActivity) getActivity();

        // prepare recycler view
        prepareTripMatchesRecycleView();

        // add test data
        addTestData();
    }

    private void prepareTripMatchesRecycleView(){

        tripMatchesRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(activity);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        tripMatchesRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        tripMatchesRecyclerViewAdapter = new TripMatchesRecyclerViewAdapter(new ArrayList<TripMatchDTO>(), this);
        tripMatchesRecyclerView.setAdapter(tripMatchesRecyclerViewAdapter);

    }

    private void addTestData(){

        // set social medias images
        Bitmap[] socialMedias = new Bitmap[3];
        socialMedias[0] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_facbook)).getBitmap();
        socialMedias[1] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_linked_in)).getBitmap();
        socialMedias[2] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_gmail)).getBitmap();

        // verifications list
        Bitmap[] verifications = new Bitmap[5];
        verifications[0] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_twitter)).getBitmap();
        verifications[1] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_linked_in)).getBitmap();
        verifications[2] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_car_plates)).getBitmap();
        verifications[3] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_no_smoking)).getBitmap();
        verifications[4] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_id_card)).getBitmap();

        ArrayList<TripMatchDTO> tripMatchDTOs = new ArrayList<>();

        // trip match 1
        TripMatchDTO tripMatchDTO1 = new TripMatchDTO();
        tripMatchDTO1.setTripOwnerImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person2)).getBitmap());
        tripMatchDTO1.setTripOwnerName("Mohamed Ahmed");
        tripMatchDTO1.setTripOwnerRate(4);
        tripMatchDTO1.setNumberOfFriendsInCommon(0);
        tripMatchDTO1.setVerificationsIcons(verifications);

        // trip match 2
        TripMatchDTO tripMatchDTO2 = new TripMatchDTO();
        tripMatchDTO2.setTripOwnerImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person3)).getBitmap());
        tripMatchDTO2.setTripOwnerName("Ali");
        tripMatchDTO2.setTripOwnerRate(1);
        tripMatchDTO2.setNumberOfFriendsInCommon(5);
        tripMatchDTO2.setCommonFriendsSocialMediasIcons(socialMedias);
        tripMatchDTO2.setVerificationsIcons(verifications);

        // trip match 3
        TripMatchDTO tripMatchDTO3 = new TripMatchDTO();
        tripMatchDTO3.setTripOwnerImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person5)).getBitmap());
        tripMatchDTO3.setTripOwnerName("Mahmoud");
        tripMatchDTO3.setTripOwnerRate(5);
        tripMatchDTO3.setNumberOfFriendsInCommon(10);
        tripMatchDTO3.setCommonFriendsSocialMediasIcons(socialMedias);
        tripMatchDTO3.setVerificationsIcons(verifications);


        tripMatchDTOs.add(tripMatchDTO1);
        tripMatchDTOs.add(tripMatchDTO2);
        tripMatchDTOs.add(tripMatchDTO3);

        tripMatchesRecyclerViewAdapter.addTripMatchesList(tripMatchDTOs);

    }

    public void setDayOffset(int dayOffset) {
        this.dayOffset = dayOffset;
    }
}
