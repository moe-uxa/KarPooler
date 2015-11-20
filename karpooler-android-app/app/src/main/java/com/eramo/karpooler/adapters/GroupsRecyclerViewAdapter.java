package com.eramo.karpooler.adapters;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.eramo.karpooler.R;
import com.eramo.karpooler.models.dtos.GroupCreationFeedDTO;
import com.eramo.karpooler.viewHolders.GroupCreationViewHolder;
import java.util.List;

/**
 * Created by Mohamed.Gaber on 11/20/2015.
 */
public class GroupsRecyclerViewAdapter extends RecyclerView.Adapter<GroupCreationViewHolder> {

    private List<GroupCreationFeedDTO> groupCreationFeedsList;
    private Fragment fragment;

    public GroupsRecyclerViewAdapter(List<GroupCreationFeedDTO> groupCreationFeedsList, Fragment fragment) {
        this.groupCreationFeedsList = groupCreationFeedsList;
        this.fragment = fragment;
    }

    @Override
    public GroupCreationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_group_creation_feed, parent, false);

        GroupCreationViewHolder groupCreationViewHolder = new GroupCreationViewHolder(view, fragment);

        return groupCreationViewHolder;

    }

    @Override
    public void onBindViewHolder(GroupCreationViewHolder holder, int position) {

        // get FeedDTO
        GroupCreationFeedDTO groupCreationFeedDTO = groupCreationFeedsList.get(position);

        holder.onBindViewHolder(groupCreationFeedDTO);

    }

    @Override
    public int getItemCount() {
        return groupCreationFeedsList.size();
    }

    public void addGroup(GroupCreationFeedDTO newGroup){
        groupCreationFeedsList.add(newGroup);
        notifyDataSetChanged();
    }

    public void addAllGroups(List<GroupCreationFeedDTO> newGroups){
        groupCreationFeedsList.addAll(newGroups);
        notifyDataSetChanged();
    }
}
