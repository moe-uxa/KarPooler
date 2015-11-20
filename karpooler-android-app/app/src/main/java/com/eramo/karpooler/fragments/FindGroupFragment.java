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
import com.eramo.karpooler.activities.FindGroupActivity;
import com.eramo.karpooler.adapters.GroupsRecyclerViewAdapter;
import com.eramo.karpooler.models.dtos.GroupCreationFeedDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindGroupFragment extends Fragment {

    private FindGroupActivity activity;
    private GroupsRecyclerViewAdapter groupsRecyclerViewAdapter;

    public FindGroupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_find_group, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        activity = (FindGroupActivity) getActivity();

        // prepare groups recycler view
        prepareFeedsRecycleView();

        // create test data
        createTestData();
    }

    private void prepareFeedsRecycleView(){

        RecyclerView groupsRecyclerView = (RecyclerView) activity.findViewById(R.id.recycler_view_groups);
        groupsRecyclerView.setHasFixedSize(true);


        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity);
        groupsRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        groupsRecyclerViewAdapter = new GroupsRecyclerViewAdapter(new ArrayList<GroupCreationFeedDTO>(), this);
        groupsRecyclerView.setAdapter(groupsRecyclerViewAdapter);

    }

    private void createTestData(){

        // set social medias images
        Bitmap[] socialMedias = new Bitmap[3];
        socialMedias[0] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_facbook)).getBitmap();
        socialMedias[1] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_linked_in)).getBitmap();
        socialMedias[2] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_gmail)).getBitmap();

        // group1
        GroupCreationFeedDTO feedDTO1 = new GroupCreationFeedDTO();
        // set main data
        feedDTO1.setOwnerName("Mohamed Ali");
        feedDTO1.setFeedTitle("has created a group");
        feedDTO1.setFeedTime("2 minutes ago");
        feedDTO1.setNumberOfFriendsInCommon(5);
        feedDTO1.setFeedDescription("Group for work");
        // set feed owner image
        feedDTO1.setOwnerImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person3)).getBitmap());
        feedDTO1.setSocialMediasList(socialMedias);

        // group2
        GroupCreationFeedDTO feedDTO2 = new GroupCreationFeedDTO();
        // set main data
        feedDTO2.setOwnerName("Mohamed Mokhtar");
        feedDTO2.setFeedTitle("has created a group");
        feedDTO2.setFeedTime("2 hours ago");
        feedDTO2.setNumberOfFriendsInCommon(10);
        feedDTO2.setFeedDescription("Group for school");
        // set feed owner image
        feedDTO2.setOwnerImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person5)).getBitmap());
        feedDTO2.setSocialMediasList(socialMedias);

        // group3
        GroupCreationFeedDTO feedDTO3 = new GroupCreationFeedDTO();
        // set main data
        feedDTO3.setOwnerName("Mohamed zaki");
        feedDTO3.setFeedTitle("has created a group");
        feedDTO3.setFeedTime("10 hours ago");
        feedDTO3.setNumberOfFriendsInCommon(1);
        feedDTO3.setFeedDescription("Group for vacation");
        // set feed owner image
        feedDTO3.setOwnerImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person1)).getBitmap());
        feedDTO3.setSocialMediasList(socialMedias);

        // group4
        GroupCreationFeedDTO feedDTO4 = new GroupCreationFeedDTO();
        // set main data
        feedDTO4.setOwnerName("Ali");
        feedDTO4.setFeedTitle("has created a group");
        feedDTO4.setFeedTime("1 hours ago");
        feedDTO4.setNumberOfFriendsInCommon(3);
        feedDTO4.setFeedDescription("Group for family");
        // set feed owner image
        feedDTO4.setOwnerImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person2)).getBitmap());
        feedDTO4.setSocialMediasList(socialMedias);

        List<GroupCreationFeedDTO> groupCreationFeedsList = new ArrayList<>();
        groupCreationFeedsList.add(feedDTO1);
        groupCreationFeedsList.add(feedDTO2);
        groupCreationFeedsList.add(feedDTO3);
        groupCreationFeedsList.add(feedDTO4);

        groupsRecyclerViewAdapter.addAllGroups(groupCreationFeedsList);

    }

}
