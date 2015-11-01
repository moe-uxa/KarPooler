package com.eramo.karpooler.fragments;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

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

import org.apmem.tools.layouts.FlowLayout;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends BaseFragment {

    HomeActivity activity;
    private FeedsRecyclerViewAdapter feedsRecyclerViewAdapter;

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

        // prepare recycler view
        prepareFeedsRecycleView();

        // test
        createTripCreationFeedTest();
        createGroupCreationFeedTest();
        createUpdateStatusFeedTest();
        createGroupCreationFeedTest();
        createUpdateStatusFeedTest();
        createTripCreationFeedTest();
        createTripCreationFeedTest();
        createGroupCreationFeedTest();
        createUpdateStatusFeedTest();
        createGroupCreationFeedTest();
        createUpdateStatusFeedTest();
        createTripCreationFeedTest();

    }

    private void prepareFeedsRecycleView(){

        RecyclerView feedsRecyclerView = (RecyclerView) activity.findViewById(R.id.recycler_view_feeds);
        feedsRecyclerView.setHasFixedSize(true);


        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity);
        feedsRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        feedsRecyclerViewAdapter = new FeedsRecyclerViewAdapter(new ArrayList<FeedDTO>(), this);
        feedsRecyclerView.setAdapter(feedsRecyclerViewAdapter);

    }

    private void createTripCreationFeedTest(){

        TripCreationFeedDTO feedDTO = new TripCreationFeedDTO();

        // set main data
        feedDTO.setTripId(1);
        feedDTO.setOwnerName("Ahmed Mohamed");
        feedDTO.setFeedTitle("trip just created");
        feedDTO.setFeedTime("3 days ago");
        feedDTO.setNumberOfFriendsInCommon(10);
        feedDTO.setFeedDescription("Summer Vacation Trip To Alexandria");

        // set feed owner image
        BitmapDrawable drawable = (BitmapDrawable) getResources().getDrawable(R.drawable.person1);
        feedDTO.setOwnerImage(drawable.getBitmap());

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
        feedDTO.setTripPassengers(passengers);

        // set social medias images
        Bitmap [] socialMedias = new Bitmap[3];
        socialMedias[0] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_facbook)).getBitmap();
        socialMedias[1] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_linked_in)).getBitmap();
        socialMedias[2] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_gmail)).getBitmap();
        feedDTO.setSocialMediasList(socialMedias);

        feedsRecyclerViewAdapter.addFeed(feedDTO);

    }

    private void createGroupCreationFeedTest(){

        GroupCreationFeedDTO feedDTO = new GroupCreationFeedDTO();

        // set main data
        feedDTO.setOwnerName("Mohamed Ali");
        feedDTO.setFeedTitle("has created a group");
        feedDTO.setFeedTime("2 minutes ago");
        feedDTO.setNumberOfFriendsInCommon(5);
        feedDTO.setFeedDescription("Group for work");

        // set feed owner image
        BitmapDrawable drawable = (BitmapDrawable) getResources().getDrawable(R.drawable.person3);
        feedDTO.setOwnerImage(drawable.getBitmap());

        // set social medias images
        Bitmap [] socialMedias = new Bitmap[3];
        socialMedias[0] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_facbook)).getBitmap();
        socialMedias[1] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_linked_in)).getBitmap();
        socialMedias[2] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_gmail)).getBitmap();
        feedDTO.setSocialMediasList(socialMedias);

        feedsRecyclerViewAdapter.addFeed(feedDTO);

    }

    private void createUpdateStatusFeedTest(){

        UpdateStatusFeedDTO feedDTO = new UpdateStatusFeedDTO();

        // set feed main data
        feedDTO.setOwnerName("Samy Ali");
        feedDTO.setFeedTitle("has update status");
        feedDTO.setFeedTime("10 hourss ago");
        feedDTO.setNumberOfFriendsInCommon(3);
        feedDTO.setFeedDescription("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.");

        // set feed owner image
        BitmapDrawable drawable = (BitmapDrawable) getResources().getDrawable(R.drawable.person2);
        feedDTO.setOwnerImage(drawable.getBitmap());

        // set social medias images
        Bitmap [] socialMedias = new Bitmap[3];
        socialMedias[0] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_facbook)).getBitmap();
        socialMedias[1] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_linked_in)).getBitmap();
        socialMedias[2] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_gmail)).getBitmap();
        feedDTO.setSocialMediasList(socialMedias);

        feedsRecyclerViewAdapter.addFeed(feedDTO);

    }

}
