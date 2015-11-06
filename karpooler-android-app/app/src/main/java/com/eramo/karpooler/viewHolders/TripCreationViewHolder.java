package com.eramo.karpooler.viewHolders;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eramo.karpooler.R;
import com.eramo.karpooler.activities.ViewTripActivity;
import com.eramo.karpooler.helpers.GeneratePeopleImageHelper;
import com.eramo.karpooler.models.dtos.FeedDTO;
import com.eramo.karpooler.models.dtos.TripCreationFeedDTO;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Mohamed.Gaber on 10/30/2015.
 */
public class TripCreationViewHolder extends FeedViewHolder{

    private LinearLayout tripPassengersList;
    private Button viewTripBtn;
    private ImageButton locationBtn;
    private View view;

    public TripCreationViewHolder(View view, Fragment fragment) {
        super(view);

        this.fragment = fragment;
        this.view = view;

        tripPassengersList  = (LinearLayout) view.findViewById(R.id.layout_people);
        viewTripBtn = (Button) view.findViewById(R.id.btn_feed_view_trip);
        locationBtn = (ImageButton) view.findViewById(R.id.btn_feed_trip_location);
    }

    @Override
    public void onBindViewHolder(FeedDTO feedDTO) {
        super.onBindViewHolder(feedDTO);

        // view passengers list
        viewTripPassengersList(feedDTO);

        // prepare View Trip Button
        prepareViewTripButton(feedDTO);
    }

    private void prepareViewTripButton(FeedDTO feedDTO){

        viewTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // go to view trip activity
                fragment.getActivity().startActivity(new Intent(fragment.getActivity(), ViewTripActivity.class));
            }
        });

    }

    private void viewTripPassengersList(FeedDTO feedDTO){

        // clear all images in passengers layout
        tripPassengersList.removeAllViews();

        TripCreationFeedDTO tripCreationFeedDTO = (TripCreationFeedDTO) feedDTO;

        // add passengers circle images
        List<Bitmap> passengers = tripCreationFeedDTO.getTripPassengers();
        int passengersSize = passengers.size();

        // if number of passengers > 6 just view 5 images
        if (passengersSize > 6)
            passengersSize = 5;

        for (int i = 0; i< passengersSize; i++){

            // get passenger bitmap
            Bitmap bitmap = passengers.get(i);

            // set ImageView src
            CircleImageView circleImageView = GeneratePeopleImageHelper.generateCircleImageView(bitmap, fragment, R.dimen.card_user_image_size, R.dimen.card_trip_passenger_image_margin_right);
            tripPassengersList.addView(circleImageView);
        }

        if (tripCreationFeedDTO.getTripPassengers().size() > 6){

            // view more button with number of more passengers to view
            RelativeLayout moreLayout = GeneratePeopleImageHelper.createMoreButton(passengers.get(5), passengers.size() - 5, fragment, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar snackbar = Snackbar.make(view, "more friends", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            });

            tripPassengersList.addView(moreLayout);
        }

    }

}
