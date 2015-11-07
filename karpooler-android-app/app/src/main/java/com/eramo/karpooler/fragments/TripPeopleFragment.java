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
import com.eramo.karpooler.activities.ViewTripActivity;
import com.eramo.karpooler.adapters.MessagesRecyclerViewAdapter;
import com.eramo.karpooler.adapters.TripPeopleRecyclerViewAdapter;
import com.eramo.karpooler.models.dtos.MessageDTO;
import com.eramo.karpooler.models.dtos.TripPersonDTO;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TripPeopleFragment extends Fragment {

    private ViewTripActivity activity;
    private TripPeopleRecyclerViewAdapter tripPeopleRecyclerViewAdapter;

    public TripPeopleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trip_people, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // get activity instance
        activity = (ViewTripActivity) getActivity();

        // prepare recycler view
        prepareMessagesRecyclerView();

        // add test data
        addTestData();

    }

    private void prepareMessagesRecyclerView(){

        RecyclerView tripPeopleRecyclerView = (RecyclerView) activity.findViewById(R.id.recycler_view_trip_people);
        tripPeopleRecyclerView.setHasFixedSize(true);

        // set recycler view divider
        tripPeopleRecyclerView.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(activity)
                        .drawable(R.drawable.divider)
                        .marginResId(R.dimen.messages_list_divider_margin_left, R.dimen.messages_list_divider_margin_right)
                        .build());

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity);
        tripPeopleRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        tripPeopleRecyclerViewAdapter = new TripPeopleRecyclerViewAdapter(this, new ArrayList<TripPersonDTO>());
        tripPeopleRecyclerView.setAdapter(tripPeopleRecyclerViewAdapter);

    }

    private void addTestData() {

        // set social medias images
        Bitmap[] socialMedias = new Bitmap[3];
        socialMedias[0] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_facbook)).getBitmap();
        socialMedias[1] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_linked_in)).getBitmap();
        socialMedias[2] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_gmail)).getBitmap();

        List<TripPersonDTO> personDTOs = new ArrayList<>();

        // person 1
        TripPersonDTO tripPersonDTO1 = new TripPersonDTO();
        tripPersonDTO1.setPersonName("Jared Leto");
        tripPersonDTO1.setPersonImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person2)).getBitmap());
        tripPersonDTO1.setNumberOfFriendsInCommon(3);
        tripPersonDTO1.setFriendsInCommonSocialMedias(socialMedias);
        tripPersonDTO1.setDriver(true);

        // person 2
        TripPersonDTO tripPersonDTO2 = new TripPersonDTO();
        tripPersonDTO2.setPersonName("Noccalo Mark");
        tripPersonDTO2.setPersonImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person1)).getBitmap());
        tripPersonDTO2.setNumberOfFriendsInCommon(10);
        tripPersonDTO2.setFriendsInCommonSocialMedias(socialMedias);
        tripPersonDTO2.setDriver(false);

        // person 3
        TripPersonDTO tripPersonDTO3 = new TripPersonDTO();
        tripPersonDTO3.setPersonName("Nick Zieber");
        tripPersonDTO3.setPersonImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person5)).getBitmap());
        tripPersonDTO3.setNumberOfFriendsInCommon(1);
        tripPersonDTO3.setFriendsInCommonSocialMedias(socialMedias);
        tripPersonDTO3.setDriver(false);

        // person 4
        TripPersonDTO tripPersonDTO4 = new TripPersonDTO();
        tripPersonDTO4.setPersonName("Damina");
        tripPersonDTO4.setPersonImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person3)).getBitmap());
        tripPersonDTO4.setNumberOfFriendsInCommon(2);
        tripPersonDTO4.setFriendsInCommonSocialMedias(socialMedias);
        tripPersonDTO4.setDriver(false);

        // person 5
        TripPersonDTO tripPersonDTO5 = new TripPersonDTO();
        tripPersonDTO5.setPersonName("Jennifer Dunn");
        tripPersonDTO5.setPersonImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person4)).getBitmap());
        tripPersonDTO5.setNumberOfFriendsInCommon(7);
        tripPersonDTO5.setFriendsInCommonSocialMedias(socialMedias);
        tripPersonDTO5.setDriver(false);

        personDTOs.add(tripPersonDTO1);
        personDTOs.add(tripPersonDTO2);
        personDTOs.add(tripPersonDTO3);
        personDTOs.add(tripPersonDTO4);
        personDTOs.add(tripPersonDTO5);

        tripPeopleRecyclerViewAdapter.addPersons(personDTOs);

    }


}
