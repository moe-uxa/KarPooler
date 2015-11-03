package com.eramo.karpooler.viewHolders;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eramo.karpooler.R;
import com.eramo.karpooler.models.dtos.FeedDTO;

/**
 * Created by Mohamed.Gaber on 10/31/2015.
 */
public class FeedViewHolder extends RecyclerView.ViewHolder implements FeedCard {

    protected ImageView feedOwnerImage;
    protected TextView feedOwnerName;
    protected TextView feedTitle;
    protected TextView feedTime;
    protected TextView ownerCommonFriendsNumber;
    protected LinearLayout socialMediasIcons;
    protected TextView feedDescription;
    protected Fragment fragment;

    public FeedViewHolder(View view) {
        super(view);

        feedOwnerImage = (ImageView) view.findViewById(R.id.imgv_user_image);
        feedOwnerName = (TextView) view.findViewById(R.id.tv_user_name);
        feedTitle = (TextView) view.findViewById(R.id.tv_feed_title);
        feedTime = (TextView) view.findViewById(R.id.tv_feed_time);
        ownerCommonFriendsNumber = (TextView) view.findViewById(R.id.tv_feed_number_of_friends_in_common);
        socialMediasIcons = (LinearLayout) view.findViewById(R.id.layout_feed_owner_social_medias);
        feedDescription = (TextView) view.findViewById(R.id.tv_feed_description);

    }

    @Override
    public void onBindViewHolder(FeedDTO feedDTO) {

        // set feed owner image
        feedOwnerImage.setImageBitmap(feedDTO.getOwnerImage());

        // set feed owner name
        feedOwnerName.setText(feedDTO.getOwnerName());

        // set feed title
        feedTitle.setText(feedDTO.getFeedTitle());

        // set feed time
        feedTime.setText(feedDTO.getFeedTime());

        // set number of common friends
        ownerCommonFriendsNumber.setText(feedDTO.getNumberOfFriendsInCommon()+" "+fragment.getResources().getString(R.string.friends_in_common));

        // set feed description
        feedDescription.setText(feedDTO.getFeedDescription());

        // set social medias images
        for (Bitmap bitmap : feedDTO.getSocialMediasList()){
            ImageView imageView = generateSocialMediaImageView(bitmap);
            socialMediasIcons.addView(imageView);
        }

    }

    private ImageView generateSocialMediaImageView(Bitmap bitmap){

        ImageView imageView = new ImageView(fragment.getContext());

        // set src
        imageView.setImageBitmap(bitmap);

        // set layout params
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 30, 0);
        imageView.setLayoutParams(layoutParams);

        return imageView;
    }
}
