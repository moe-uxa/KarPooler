package com.eramo.karpooler.viewHolders;

import android.graphics.Bitmap;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eramo.karpooler.R;
import com.eramo.karpooler.models.dtos.FeedDTO;
import com.eramo.karpooler.models.dtos.TripCreationFeedDTO;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Mohamed.Gaber on 10/30/2015.
 */
public class TripCreationViewHolder extends FeedViewHolder{

    private LinearLayout tripPassengersList;
    private View view;

    public TripCreationViewHolder(View view, Fragment fragment) {
        super(view);

        this.fragment = fragment;
        this.view = view;

        tripPassengersList  = (LinearLayout) view.findViewById(R.id.layout_people);
    }

    @Override
    public void onBindViewHolder(FeedDTO feedDTO) {
        super.onBindViewHolder(feedDTO);


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
            CircleImageView circleImageView = generateCircleImageView(bitmap);
            tripPassengersList.addView(circleImageView);
        }

        if (tripCreationFeedDTO.getTripPassengers().size() > 6){

            // view more button with number of more passengers to view
            RelativeLayout moreLayout = createMoreButton(passengers.get(5), passengers.size()-5);
            tripPassengersList.addView(moreLayout);
        }
        
    }

    private CircleImageView generateCircleImageView(Bitmap bitmap){

        CircleImageView circleImageView = new CircleImageView(fragment.getContext());

        // set src
        circleImageView.setImageBitmap(bitmap);

        // convert width and height from dp to px
        int width_height_px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, fragment.getResources().getDisplayMetrics());

        // set layout params
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width_height_px, width_height_px);
        layoutParams.setMargins(0, 0, 30, 0);
        circleImageView.setLayoutParams(layoutParams);

        return circleImageView;
    }

    private RelativeLayout createMoreButton(Bitmap lastImage, int numberOfMorePassengers){


        RelativeLayout layout = (RelativeLayout) fragment.getLayoutInflater(null).inflate(R.layout.layout_more_passengers, null);

        // set layout params
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 10, 0);
        layout.setLayoutParams(layoutParams);

        // set last image
        CircleImageView circleImageView = (CircleImageView) layout.findViewById(R.id.imgv_last_image);
        circleImageView.setImageBitmap(lastImage);

        // set number of more friends
        Button moreButton = (Button) layout.findViewById(R.id.btn_more_passengers);
        moreButton.setText(numberOfMorePassengers+"+");

        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(view, "more friends", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        return layout;
    }
}
