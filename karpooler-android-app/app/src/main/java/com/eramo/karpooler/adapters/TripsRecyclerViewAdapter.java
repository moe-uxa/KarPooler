package com.eramo.karpooler.adapters;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eramo.karpooler.R;
import com.eramo.karpooler.models.dtos.TripDTO;

import java.util.List;

/**
 * Created by Mohamed.Gaber on 11/1/2015.
 */
public class TripsRecyclerViewAdapter extends RecyclerView.Adapter <TripsRecyclerViewAdapter.ViewHolder>{

    private List<TripDTO> trips;
    private Fragment fragment;
    private static int NUMBER_OF_HEADERS = 3;

    public TripsRecyclerViewAdapter(List<TripDTO> trips, Fragment fragment) {
        this.trips = trips;
        this.fragment = fragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_trip, parent, false);

        if (viewType == 1)
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_trip_list_header, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    @Override
    public int getItemCount() {
        return trips.size() + NUMBER_OF_HEADERS;
    }

    class ViewHolder extends RecyclerView.ViewHolder{


        public ViewHolder(View view) {
            super(view);
        }
    }

    public void addTrip(TripDTO tripDTO){
        trips.add(tripDTO);
        notifyDataSetChanged();
    }

}
