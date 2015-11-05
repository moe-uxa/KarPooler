package com.eramo.karpooler.adapters;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eramo.karpooler.R;
import com.eramo.karpooler.helpers.Constants;
import com.eramo.karpooler.helpers.GeneratePeopleImageHelper;
import com.eramo.karpooler.models.dtos.TripDTO;

import java.util.Collections;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Mohamed.Gaber on 11/1/2015.
 */
public class TripsRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<TripDTO> trips;
    private Fragment fragment;
    private static int NUMBER_OF_HEADERS = 3;

    private int onGoingHeaderPosition;
    private int upComingHeaderPosition;
    private int expiredHeaderPosition;

    public TripsRecyclerViewAdapter(List<TripDTO> trips, Fragment fragment) {

        this.trips = trips;
        this.fragment = fragment;

        // get header position
        onGoingHeaderPosition = 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;

        if (viewType == Constants.TRIP_EXPIRED_STATE || viewType == Constants.TRIP_ONGOING_STATE || viewType == Constants.TRIP_UPCOMING_STATE) {

            // inflate header view
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_trip_list_header, parent, false);

            viewHolder = new HeaderViewHolder(view);

        } else {

            // inflate card view
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_trip, parent, false);

            viewHolder = new ViewHolder(view);
        }


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (position == onGoingHeaderPosition){

            HeaderViewHolder header = (HeaderViewHolder) holder;
            header.headerTitle.setText(fragment.getResources().getString(R.string.on_going));
            header.headerIcon.setImageResource(R.drawable.ic_ongoing);

        }else if (position == upComingHeaderPosition){

            HeaderViewHolder header = (HeaderViewHolder) holder;
            header.headerTitle.setText(fragment.getResources().getString(R.string.up_coming));
            header.headerIcon.setImageResource(R.drawable.ic_upcoming);

        }else if (position == expiredHeaderPosition){

            HeaderViewHolder header = (HeaderViewHolder) holder;
            header.headerTitle.setText(fragment.getResources().getString(R.string.expired));
            header.headerIcon.setImageResource(R.drawable.ic_expired);

        }else{

            // normalize position
            int normalizePositionNumber = 1;

            if (position > upComingHeaderPosition && position <expiredHeaderPosition)
                normalizePositionNumber = 2;
            else if(position > expiredHeaderPosition)
                normalizePositionNumber = 3;

            // get trip dto
            TripDTO tripDTO =trips.get(position - normalizePositionNumber);

            // set view holder data
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.tripName.setText(tripDTO.getTripName());
            viewHolder.tripDate.setText(tripDTO.getTripDate());
            viewHolder.tripFromTo.setText(tripDTO.getTripFromTo());
            addPassengersToViewHolder(viewHolder, tripDTO);

        }

    }

    @Override
    public int getItemViewType(int position) {

        if (position == onGoingHeaderPosition)
            return Constants.TRIP_ONGOING_STATE;
        else if (position == upComingHeaderPosition)
            return Constants.TRIP_UPCOMING_STATE;
        else if (position == expiredHeaderPosition)
            return Constants.TRIP_EXPIRED_STATE;
        else
            return 0;
    }

    @Override
    public int getItemCount() {
        return trips.size() + NUMBER_OF_HEADERS;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tripName;
        public TextView tripDate;
        public TextView tripFromTo;
        public LinearLayout tripPassengersList;


        public ViewHolder(View view) {
            super(view);

            // get views
            tripName = (TextView) view.findViewById(R.id.tv_trip_name);
            tripDate = (TextView) view.findViewById(R.id.tv_user_gender_age);
            tripFromTo = (TextView) view.findViewById(R.id.btn_view_profile);
            tripPassengersList = (LinearLayout) view.findViewById(R.id.layout_people);

        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        public TextView headerTitle;
        public ImageView headerIcon;

        public HeaderViewHolder(View view) {
            super(view);

            headerTitle = (TextView) view.findViewById(R.id.tv_header_title);
            headerIcon = (ImageView) view.findViewById(R.id.imgv_header_icon);
        }
    }

    private void addPassengersToViewHolder(ViewHolder viewHolder, TripDTO tripDTO){

        // clear all images in passengers layout
        viewHolder.tripPassengersList.removeAllViews();

        // add passengers circle images
        List<Bitmap> passengers = tripDTO.getPassengers();
        int passengersSize = passengers.size();

        // if number of passengers > 6 just view 5 images
        if (passengersSize > 6)
            passengersSize = 5;

        for (int i = 0; i< passengersSize; i++){

            // get passenger bitmap
            Bitmap bitmap = passengers.get(i);

            // set ImageView src
            CircleImageView circleImageView = GeneratePeopleImageHelper.generateCircleImageView(bitmap, fragment, R.dimen.card_user_image_size, R.dimen.card_trip_passenger_image_margin_right);
            viewHolder.tripPassengersList.addView(circleImageView);
        }

        if (tripDTO.getPassengers().size() > 6){

            // view more button with number of more passengers to view
            RelativeLayout moreLayout = GeneratePeopleImageHelper.createMoreButton(passengers.get(5), passengers.size() - 5, fragment, new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            viewHolder.tripPassengersList.addView(moreLayout);
        }

    }

    public void addTrip(TripDTO tripDTO) {
        trips.add(tripDTO);

        sort();
        calculateHeadersPositions();
        notifyDataSetChanged();
    }

    private int getNumberOfOnGoingTrips() {

        int count = 0;

        for (TripDTO tripDTO : trips) {

            if (tripDTO.getTripState() == Constants.TRIP_ONGOING_STATE)
                count++;
        }

        return count;
    }

    private int getNumberOfUpcomingTrips() {

        int count = 0;

        for (TripDTO tripDTO : trips) {

            if (tripDTO.getTripState() == Constants.TRIP_UPCOMING_STATE)
                count++;
        }

        return count;
    }

    private int getNumberOfExpiredTrips() {

        int count = 0;

        for (TripDTO tripDTO : trips) {

            if (tripDTO.getTripState() == Constants.TRIP_EXPIRED_STATE)
                count++;
        }

        return count;
    }

    public void addTrips(List<TripDTO> addedTrips){

        trips.addAll(addedTrips);

        sort();
        calculateHeadersPositions();
        notifyDataSetChanged();
    }

    private void sort(){

        // sort trip based on state ONGOING -> UPCOMING -> EXPIRED
        Collections.sort(trips);
    }

    private void calculateHeadersPositions(){

        upComingHeaderPosition = getNumberOfOnGoingTrips() + 1;
        expiredHeaderPosition = upComingHeaderPosition + getNumberOfUpcomingTrips() + 1;
    }

}
