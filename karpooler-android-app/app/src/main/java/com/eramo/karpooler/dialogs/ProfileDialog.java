package com.eramo.karpooler.dialogs;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eramo.karpooler.R;
import com.eramo.karpooler.activities.MessageActivity;
import com.eramo.karpooler.activities.ProfileActivity;
import com.eramo.karpooler.helpers.BlurBuilder;
import com.eramo.karpooler.models.dtos.ShortUserProfileDTO;

import java.io.ByteArrayOutputStream;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.MaskTransformation;

/**
 * Created by Mohamed.Gaber on 11/12/2015.
 */
public class ProfileDialog extends DialogFragment{

    private ImageView userProfileCover;
    private ImageView userImage;
    private TextView userName;
    private TextView userGenderAge;
    private TextView numberOfFriendsInCommon;
    private LinearLayout commonSocialMediasList;
    private TextView registerDate;
    private Button messageButton;
    private Button profileButton;

    private ShortUserProfileDTO shortUserProfileDTO;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_profile, container, false);

        // find views
        userProfileCover = (ImageView) view.findViewById(R.id.imgv_profile_cover);
        userImage = (ImageView) view.findViewById(R.id.imgv_user_image);
        userName = (TextView) view.findViewById(R.id.tv_user_name);
        userGenderAge = (TextView) view.findViewById(R.id.tv_user_gender_age);
        numberOfFriendsInCommon = (TextView) view.findViewById(R.id.tv_person_number_of_friends_in_common);
        registerDate = (TextView) view.findViewById(R.id.tv_Registration_date);
        commonSocialMediasList = (LinearLayout) view.findViewById(R.id.layout_person_common_friends_social_medias);
        messageButton = (Button) view.findViewById(R.id.btn_message);
        profileButton = (Button) view.findViewById(R.id.btn_profile);

        return view;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();

        // create test data
        createTestData();

        // 1. prepare cover image
        prepareCoverImage();

        // 2. prepare and view user profile info
        prepareAndViewUserInfo();

        // 3. prepare dialog buttons
        prepareDialogButtons();

    }

    private void prepareCoverImage(){

        // set user image as cover
        Bitmap bmp = BlurBuilder.blur(getContext(), shortUserProfileDTO.getUserImage());
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        Glide.with(this).load(byteArray)
                .bitmapTransform(new CropTransformation(getContext(), 1010, 300, CropTransformation.CropType.BOTTOM))
                .into(userProfileCover);



    }

    private void prepareAndViewUserInfo(){

        // bind user data
        userImage.setImageBitmap(shortUserProfileDTO.getUserImage());
        userName.setText(shortUserProfileDTO.getUserName());
        userGenderAge.setText(shortUserProfileDTO.getUserGender()+", "+shortUserProfileDTO.getUserAge() + " " + getResources().getString(R.string.years_old));
        registerDate.setText(getResources().getString(R.string.registered_since) + " " + shortUserProfileDTO.getRegistrationDate());

        if (shortUserProfileDTO.getNumberOfFriendsInCommon() == 0)
            numberOfFriendsInCommon.setText(getResources().getString(R.string.no_mutual_friends));
        else {

            numberOfFriendsInCommon.setText(shortUserProfileDTO.getNumberOfFriendsInCommon() + " " + getResources().getString(R.string.friends_in_common));

            // set common friends social medias icons
            for (Bitmap bitmap : shortUserProfileDTO.getCommonSocialMedias()){
                ImageView imageView = generateImageIcon(bitmap, R.dimen.imgv_social_media_icon_margin_right);
                commonSocialMediasList.addView(imageView);
            }
        }
    }

    private void prepareDialogButtons(){

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // open message activity
                startActivity(new Intent(getActivity(), MessageActivity.class));
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // open profile activity
                startActivity(new Intent(getActivity(), ProfileActivity.class));
            }
        });

    }

    private ImageView generateImageIcon(Bitmap bitmap, int marginRightResource){

        ImageView imageView = new ImageView(getContext());

        // convert margin right to px
        int marginRightInPx = getResources().getDimensionPixelSize(marginRightResource);

        // set src
        imageView.setImageBitmap(bitmap);

        // set layout params
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, marginRightInPx, 0);
        imageView.setLayoutParams(layoutParams);

        return imageView;
    }

    private  void createTestData(){

        // set social medias images
        Bitmap[] socialMedias = new Bitmap[3];
        socialMedias[0] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_facbook)).getBitmap();
        socialMedias[1] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_linked_in)).getBitmap();
        socialMedias[2] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_gmail)).getBitmap();

        // prepare user info dto
        shortUserProfileDTO = new ShortUserProfileDTO();
        shortUserProfileDTO.setUserImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person1)).getBitmap());
        shortUserProfileDTO.setUserName("Johnatan Web");
        shortUserProfileDTO.setUserGender("Male");
        shortUserProfileDTO.setUserAge(20);
        shortUserProfileDTO.setUserId(1);
        shortUserProfileDTO.setNumberOfFriendsInCommon(9);
        shortUserProfileDTO.setCommonSocialMedias(socialMedias);
        shortUserProfileDTO.setRegistrationDate("2-2013");

    }

}
