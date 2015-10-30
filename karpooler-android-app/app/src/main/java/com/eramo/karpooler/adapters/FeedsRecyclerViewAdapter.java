package com.eramo.karpooler.adapters;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eramo.karpooler.R;
import com.eramo.karpooler.models.dtos.FeedDTO;
import com.eramo.karpooler.models.dtos.GroupCreationFeedDTO;
import com.eramo.karpooler.models.dtos.TripCreationFeedDTO;
import com.eramo.karpooler.models.dtos.UpdateStatusFeedDTO;
import com.eramo.karpooler.viewHolders.GroupCreationViewHolder;
import com.eramo.karpooler.viewHolders.TripCreationViewHolder;
import com.eramo.karpooler.viewHolders.UpdateStatusViewHolder;

import java.util.List;

/**
 * Created by Mohamed.Gaber on 10/30/2015.
 */
public class FeedsRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<FeedDTO> feeds;

    // Feeds Types
    private final int NO_FEED_TYPE = 0;
    private final int TRIP_CREATION_FEED_TYPE = 1;
    private final int UPDATE_STATUS_FEED_TYPE = 2;
    private final int GROUP_CREATION_FEED_TYPE = 3;


    public FeedsRecyclerViewAdapter(List<FeedDTO> feeds) {
        this.feeds = feeds;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewHolder viewHolder= null;

        switch (viewType){

            case TRIP_CREATION_FEED_TYPE:
                View view1 = inflater.inflate(R.layout.card_trip_creation_feed, parent, false);
                viewHolder = new TripCreationViewHolder(view1);
                break;

            case UPDATE_STATUS_FEED_TYPE:
                View view2 = inflater.inflate(R.layout.card_update_status_feed, parent, false);
                viewHolder = new UpdateStatusViewHolder(view2);
                break;

            case GROUP_CREATION_FEED_TYPE:
                View view3 = inflater.inflate(R.layout.card_group_creation_feed, parent, false);
                viewHolder = new GroupCreationViewHolder(view3);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (feeds.get(position) instanceof TripCreationFeedDTO){

            return TRIP_CREATION_FEED_TYPE;

        }else if (feeds.get(position) instanceof UpdateStatusFeedDTO){

            return UPDATE_STATUS_FEED_TYPE;

        }else if (feeds.get(position) instanceof GroupCreationFeedDTO){

            return GROUP_CREATION_FEED_TYPE;
        }

        return NO_FEED_TYPE;
    }

    public void addFeed(FeedDTO feedDTO){
        feeds.add(feedDTO);
    }
}
