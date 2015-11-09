package com.eramo.karpooler.adapters;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.eramo.karpooler.R;
import com.eramo.karpooler.models.dtos.TripMatchDTO;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Mohamed.Gaber on 11/9/2015.
 */
public class TripMatchesRecyclerViewAdapter extends RecyclerView.Adapter<TripMatchesRecyclerViewAdapter.ViewHolder> {

    private List<TripMatchDTO> tripMatches;
    private Fragment fragment;

    public TripMatchesRecyclerViewAdapter(List<TripMatchDTO> tripMatches, Fragment fragment) {
        this.tripMatches = tripMatches;
        this.fragment = fragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_trip_match, parent, false);

        TripMatchesRecyclerViewAdapter.ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // get trip match dto
        TripMatchDTO tripMatchDTO = tripMatches.get(position);

        /* bind data */

        // set trip owner image, name and rating
        holder.tripOwnerImage.setImageBitmap(tripMatchDTO.getTripOwnerImage());
        holder.tripOwnerName.setText(tripMatchDTO.getTripOwnerName());
        holder.tripOwnerRate.setRating(tripMatchDTO.getTripOwnerRate());

        // set number of common friends
        if (tripMatchDTO.getNumberOfFriendsInCommon() == 0)
            holder.tripOwnerNumOfFriendsInCommon.setText(fragment.getResources().getString(R.string.no_mutual_friends));
        else{

            holder.tripOwnerNumOfFriendsInCommon.setText(tripMatchDTO.getNumberOfFriendsInCommon()+" "+fragment.getResources().getString(R.string.friends_in_common));

            // set common friends social medias icons
            for (Bitmap bitmap : tripMatchDTO.getCommonFriendsSocialMediasIcons()){
                ImageView imageView = generateImageIcon(bitmap, R.dimen.imgv_social_media_icon_margin_right);
                holder.commonFriendsSocialMediasIconsLayout.addView(imageView);
            }
        }


        // set verifications icons
        for (Bitmap bitmap : tripMatchDTO.getVerificationsIcons()){
            ImageView imageView = generateImageIcon(bitmap, R.dimen.imgv_verfication_icon_margin_right);
            holder.verificationIconLayout.addView(imageView);
        }

        // set join trip button onClickListener
        holder.joinTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // set invite button onClickListener
        holder.inviteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return tripMatches.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public CircleImageView tripOwnerImage;
        public TextView tripOwnerName;
        public RatingBar tripOwnerRate;
        public TextView tripOwnerNumOfFriendsInCommon;
        public LinearLayout commonFriendsSocialMediasIconsLayout;
        public LinearLayout verificationIconLayout;
        public Button joinTripBtn;
        public Button inviteBtn;

        public ViewHolder(View view) {
            super(view);

            // get views
            tripOwnerImage = (CircleImageView) view.findViewById(R.id.imgv_trip_owner_image);
            tripOwnerName = (TextView) view.findViewById(R.id.tv_trip_owner_name);
            tripOwnerNumOfFriendsInCommon = (TextView) view.findViewById(R.id.tv_trip_owner_num_of_friends_in_common);
            tripOwnerRate = (RatingBar) view.findViewById(R.id.rating_bar_user_rate);
            commonFriendsSocialMediasIconsLayout = (LinearLayout) view.findViewById(R.id.layout_trip_owner_common_social_medias);
            verificationIconLayout = (LinearLayout) view.findViewById(R.id.layout_user_verifications_list);
            joinTripBtn = (Button) view.findViewById(R.id.btn_join_trip);
            inviteBtn = (Button) view.findViewById(R.id.btn_invite);

        }
    }

    private ImageView generateImageIcon(Bitmap bitmap, int marginRightResource){

        ImageView imageView = new ImageView(fragment.getContext());

        // convert margin right to px
        int marginRightInPx = fragment.getResources().getDimensionPixelSize(marginRightResource);

        // set src
        imageView.setImageBitmap(bitmap);

        // set layout params
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, marginRightInPx, 0);
        imageView.setLayoutParams(layoutParams);

        return imageView;
    }

    public void addTripMatchesList(List<TripMatchDTO> tripMatchesList){
        tripMatches.addAll(tripMatchesList);
        notifyDataSetChanged();
    }

    public void addTripMatch(TripMatchDTO tripMatchDTO){
        tripMatches.add(tripMatchDTO);
        notifyDataSetChanged();
    }
}
