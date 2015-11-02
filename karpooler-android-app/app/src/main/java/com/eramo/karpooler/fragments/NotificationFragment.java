package com.eramo.karpooler.fragments;


import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eramo.karpooler.R;
import com.eramo.karpooler.activities.HomeActivity;
import com.eramo.karpooler.adapters.MessagesRecyclerViewAdapter;
import com.eramo.karpooler.adapters.NotificationsRecyclerViewAdapter;
import com.eramo.karpooler.models.dtos.MessageDTO;
import com.eramo.karpooler.models.dtos.NotificationDTO;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends BaseFragment {


    private HomeActivity activity;
    private NotificationsRecyclerViewAdapter notificationsRecyclerViewAdapter;

    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // get activity instance
        activity = (HomeActivity) getActivity();

        // prepare notification recycler view
        prepareNotificationsRecyclerView();

        // add test data
        addTestData();

    }

    private void prepareNotificationsRecyclerView(){

        RecyclerView notificationsRecyclerView = (RecyclerView) activity.findViewById(R.id.recycler_view_notifications);
        notificationsRecyclerView.setHasFixedSize(true);

        // set recycler view divider
        notificationsRecyclerView.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(activity)
                        .drawable(R.drawable.divider)
                        .marginResId(R.dimen.messages_list_divider_margin_left, R.dimen.messages_list_divider_margin_right)
                        .build());

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity);
        notificationsRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        notificationsRecyclerViewAdapter = new NotificationsRecyclerViewAdapter(new ArrayList<NotificationDTO>(), this);
        notificationsRecyclerView.setAdapter(notificationsRecyclerViewAdapter);

    }


    private void addTestData() {

        List<NotificationDTO> notificationDTOList = new ArrayList<>();

        // notify 1
        NotificationDTO notificationDTO1 = new NotificationDTO();
        notificationDTO1.setNotifyOwnerImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person2)).getBitmap());
        notificationDTO1.setNotifyOwnerName("Jared Leto");
        notificationDTO1.setNotifyText("just accepted your invitation ");
        notificationDTO1.setNotifyTime("2 hours ago");

        // notify 2
        NotificationDTO notificationDTO2 = new NotificationDTO();
        notificationDTO2.setNotifyOwnerImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person3)).getBitmap());
        notificationDTO2.setNotifyOwnerName("Mike Davidson");
        notificationDTO2.setNotifyText("wants to be your friend");
        notificationDTO2.setNotifyTime("4 hours ago");

        // notify 3
        NotificationDTO notificationDTO3 = new NotificationDTO();
        notificationDTO3.setNotifyOwnerImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person4)).getBitmap());
        notificationDTO3.setNotifyOwnerName("Mika Loka");
        notificationDTO3.setNotifyText("rejected your invitation");
        notificationDTO3.setNotifyTime("10 hours ago");

        // notify 4
        NotificationDTO notificationDTO4 = new NotificationDTO();
        notificationDTO4.setNotifyOwnerImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person5)).getBitmap());
        notificationDTO4.setNotifyOwnerName("Ahmed Mahmoud");
        notificationDTO4.setNotifyText("likes your post");
        notificationDTO4.setNotifyTime("1 day ago");

        notificationDTOList.add(notificationDTO1);
        notificationDTOList.add(notificationDTO2);
        notificationDTOList.add(notificationDTO3);
        notificationDTOList.add(notificationDTO4);

        notificationsRecyclerViewAdapter.addNotifications(notificationDTOList);


    }

}
