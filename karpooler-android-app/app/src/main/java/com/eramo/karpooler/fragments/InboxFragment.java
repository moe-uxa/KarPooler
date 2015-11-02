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
import com.eramo.karpooler.adapters.BrandsRecyclerViewAdapter;
import com.eramo.karpooler.adapters.MessagesRecyclerViewAdapter;
import com.eramo.karpooler.models.dtos.BrandDTO;
import com.eramo.karpooler.models.dtos.MessageDTO;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;


public class InboxFragment extends BaseFragment {


    private HomeActivity activity;
    private MessagesRecyclerViewAdapter messagesRecyclerViewAdapter;

    public InboxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inbox, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // get activity instance
        activity = (HomeActivity) getActivity();

        // prepare messages recycler view
        prepareMessagesRecyclerView();

        // add test data
        addTestData();

    }

    private void prepareMessagesRecyclerView(){

        RecyclerView messagesRecyclerView = (RecyclerView) activity.findViewById(R.id.recycler_view_messages);
        messagesRecyclerView.setHasFixedSize(true);

        // set recycler view divider
        messagesRecyclerView.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(activity)
                        .drawable(R.drawable.divider)
                        .marginResId(R.dimen.messages_list_divider_margin_left, R.dimen.messages_list_divider_margin_right)
                        .build());

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity);
        messagesRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        messagesRecyclerViewAdapter = new MessagesRecyclerViewAdapter(new ArrayList<MessageDTO>(), this);
        messagesRecyclerView.setAdapter(messagesRecyclerViewAdapter);

    }


    private void addTestData() {

        List<MessageDTO> messageDTOs = new ArrayList<>();

        // message 1
        MessageDTO messageDTO1 = new MessageDTO();
        messageDTO1.setMessageOwner(((BitmapDrawable) getResources().getDrawable(R.drawable.person2)).getBitmap());
        messageDTO1.setMessage("Hi Alex, how’s it going? I hope everything is ok.");
        messageDTO1.setMessageTime("2h");
        messageDTO1.setMessageOwnerName("Jared Leto");
        messageDTOs.add(messageDTO1);

        // message 2
        MessageDTO messageDTO2 = new MessageDTO();
        messageDTO2.setMessageOwner(((BitmapDrawable) getResources().getDrawable(R.drawable.person6)).getBitmap());
        messageDTO2.setMessage("Hi Alex, how’s it going? I hope everything is ok.");
        messageDTO2.setMessageTime("10h");
        messageDTO2.setMessageOwnerName("Nick ziber");
        messageDTOs.add(messageDTO2);

        // message 3
        MessageDTO messageDTO3 = new MessageDTO();
        messageDTO3.setMessageOwner(((BitmapDrawable) getResources().getDrawable(R.drawable.person4)).getBitmap());
        messageDTO3.setMessage("Hi Alex, how’s it going? I hope everything is ok.");
        messageDTO3.setMessageTime("11h");
        messageDTO3.setMessageOwnerName("Mohamed Alim");
        messageDTOs.add(messageDTO3);

        // message 4
        MessageDTO messageDTO4 = new MessageDTO();
        messageDTO4.setMessageOwner(((BitmapDrawable) getResources().getDrawable(R.drawable.person3)).getBitmap());
        messageDTO4.setMessage("Hi Alex, how’s it going? I hope everything is ok.");
        messageDTO4.setMessageTime("yesterday");
        messageDTO4.setMessageOwnerName("Bill Kenny");
        messageDTOs.add(messageDTO4);

        messagesRecyclerViewAdapter.addMessages(messageDTOs);

    }
}
