package com.eramo.karpooler.activities;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.eramo.karpooler.R;
import com.eramo.karpooler.adapters.BehavioursRecyclerViewAdapter;
import com.eramo.karpooler.adapters.VerificationsRecyclerViewAdapter;
import com.eramo.karpooler.models.dtos.BehaviourDTO;
import com.eramo.karpooler.models.dtos.UserProfileDTO;
import com.eramo.karpooler.models.dtos.VerificationDTO;
import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends BaseActivity {

    private UserProfileDTO userProfileDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // setup tool bar
        setupToolBar();

        // enable home button
        enableUpButton();

        // create test user profile
        createUserProfileTestData();

        // view user info
        viewUserInfo();

        // prepare verification recycler view
        prepareVerificationsRecyclerView();

        // prepare behaviours recycler view
        prepareBehavioursRecyclerView();

    }

    private void viewUserInfo(){

        // view user image
        ImageView userImage = (ImageView) findViewById(R.id.imgv_user_image);
        userImage.setImageBitmap(userProfileDTO.getUserImage());

        // view user name
        TextView userName = (TextView) findViewById(R.id.tv_user_name);
        userName.setText(userProfileDTO.getUserName());

        // view user gender and age
        TextView userGenderAge = (TextView) findViewById(R.id.tv_user_gender_age);
        userGenderAge.setText(userProfileDTO.getUserGender() + ", " + userProfileDTO.getUserAge() + " " + getResources().getString(R.string.years_old));

        // view registration date
        TextView registrationDate = (TextView) findViewById(R.id.tv_Registration_date);
        registrationDate.setText(getResources().getString(R.string.registered_since) + " " + userProfileDTO.getRegistrationDate());

        // view user rate
        RatingBar userRate = (RatingBar) findViewById(R.id.rating_bar_user_rate);
        userRate.setNumStars(userProfileDTO.getUserRate());
        userRate.setRating(userProfileDTO.getUserRate());

        // view user Location
        TextView userLocation = (TextView) findViewById(R.id.tv_user_location);
        userLocation.setText(userProfileDTO.getUserLocation());

        // view user number of friends in common
        TextView userNumberOfFriendsInCommon = (TextView) findViewById(R.id.tv_person_number_of_friends_in_common);
        LinearLayout commonFriendsSocialMediaList = (LinearLayout) findViewById(R.id.layout_person_common_friends_social_medias);

        if (userProfileDTO.getNumberOfFriendsInCommon() == 0)
            userNumberOfFriendsInCommon.setText(getResources().getString(R.string.no_mutual_friends));
        else {

            userNumberOfFriendsInCommon.setText(userProfileDTO.getNumberOfFriendsInCommon() + " " + getResources().getString(R.string.friends_in_common));

            // set common friends social medias icons
            for (Bitmap bitmap : userProfileDTO.getCommonSocialMedias()){
                ImageView imageView = generateImageIcon(bitmap, R.dimen.imgv_social_media_icon_margin_right);
                commonFriendsSocialMediaList.addView(imageView);
            }
        }

        // setup call button
        Button callBtn = (Button) findViewById(R.id.btn_call);
        callBtn.setText(getResources().getString(R.string.call)+" "+userProfileDTO.getUserName());
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void prepareVerificationsRecyclerView(){

        RecyclerView verificationsRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_verifications);
        verificationsRecyclerView.setHasFixedSize(true);

        // get item height into px
        int itemHeightInPx = getResources().getDimensionPixelOffset(R.dimen.verification_item_height);

        // get recycler view margin
        int marginInPx = getResources().getDimensionPixelOffset(R.dimen.verifications_recycler_view_margin);

        // set recycler view width, height and margin
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, userProfileDTO.getVerificationList().size() * itemHeightInPx);
        layoutParams.setMargins(marginInPx, marginInPx, marginInPx, marginInPx);
        verificationsRecyclerView.setLayoutParams(layoutParams);

        // use a grid layout manager
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        verificationsRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        VerificationsRecyclerViewAdapter verificationsRecyclerViewAdapter = new VerificationsRecyclerViewAdapter(userProfileDTO.getVerificationList(), this);
        verificationsRecyclerView.setAdapter(verificationsRecyclerViewAdapter);

    }

    private void prepareBehavioursRecyclerView(){

        RecyclerView behavioursRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_behaviours);
        behavioursRecyclerView.setHasFixedSize(true);

        // get item height into px
        int itemHeightInPx = getResources().getDimensionPixelOffset(R.dimen.verification_item_height);

        // get recycler view margin
        int marginInPx = getResources().getDimensionPixelOffset(R.dimen.verifications_recycler_view_margin);

        // set recycler view width, height and margin
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, userProfileDTO.getBehavioursList().size() * itemHeightInPx);
        layoutParams.setMargins(marginInPx, marginInPx, marginInPx, marginInPx);
        behavioursRecyclerView.setLayoutParams(layoutParams);

        // use a grid layout manager
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        behavioursRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        BehavioursRecyclerViewAdapter behavioursRecyclerViewAdapter = new BehavioursRecyclerViewAdapter(userProfileDTO.getBehavioursList(), this);
        behavioursRecyclerView.setAdapter(behavioursRecyclerViewAdapter);

    }

    private ImageView generateImageIcon(Bitmap bitmap, int marginRightResource){

        ImageView imageView = new ImageView(this);

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

    private List<VerificationDTO> createVerificationsListTestData(){

        List<VerificationDTO> verificationDTOList = new ArrayList<>();

        verificationDTOList.add(new VerificationDTO(((BitmapDrawable) getResources().getDrawable(R.drawable.ic_facbook)).getBitmap(), "Facebook"));
        verificationDTOList.add(new VerificationDTO(((BitmapDrawable) getResources().getDrawable(R.drawable.ic_linked_in)).getBitmap(), "Linkedin"));
        verificationDTOList.add(new VerificationDTO(((BitmapDrawable) getResources().getDrawable(R.drawable.ic_twitter)).getBitmap(), "Twitter"));
        verificationDTOList.add(new VerificationDTO(((BitmapDrawable) getResources().getDrawable(R.drawable.ic_pay_pal)).getBitmap(), "Paypal"));
        verificationDTOList.add(new VerificationDTO(((BitmapDrawable) getResources().getDrawable(R.drawable.ic_gmail)).getBitmap(), "Google+"));
        verificationDTOList.add(new VerificationDTO(((BitmapDrawable) getResources().getDrawable(R.drawable.ic_id_card)).getBitmap(), "ID Card"));
        verificationDTOList.add(new VerificationDTO(((BitmapDrawable) getResources().getDrawable(R.drawable.ic_corp_mail)).getBitmap(), "Corporate Mail"));
        verificationDTOList.add(new VerificationDTO(((BitmapDrawable) getResources().getDrawable(R.drawable.ic_email)).getBitmap(), "Email"));
        verificationDTOList.add(new VerificationDTO(((BitmapDrawable) getResources().getDrawable(R.drawable.ic_mobile)).getBitmap(), "Mobile"));
        verificationDTOList.add(new VerificationDTO(((BitmapDrawable) getResources().getDrawable(R.drawable.ic_car_plates)).getBitmap(), "Car Plates"));

        return verificationDTOList;

    }

    private List<BehaviourDTO> createBehavioursListTestData(){

        List<BehaviourDTO> behavioursList = new ArrayList<>();

        behavioursList.add(new BehaviourDTO(((BitmapDrawable) getResources().getDrawable(R.drawable.ic_no_music)).getBitmap(), "No Music"));
        behavioursList.add(new BehaviourDTO(((BitmapDrawable) getResources().getDrawable(R.drawable.ic_no_smoking)).getBitmap(), "No Smoking"));

        return behavioursList;

    }

    private void createUserProfileTestData(){

        // set social medias images
        Bitmap[] socialMedias = new Bitmap[3];
        socialMedias[0] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_facbook)).getBitmap();
        socialMedias[1] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_linked_in)).getBitmap();
        socialMedias[2] = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_gmail)).getBitmap();

        userProfileDTO = new UserProfileDTO();

        userProfileDTO.setUserName("Jared Leto");
        userProfileDTO.setUserImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person3)).getBitmap());
        userProfileDTO.setUserGender("Male");
        userProfileDTO.setUserAge(25);
        userProfileDTO.setRegistrationDate("11 2015");
        userProfileDTO.setUserRate(3);
        userProfileDTO.setUserPhoneNumber("0123232323");
        userProfileDTO.setUserLocation("Cairo, Egypt");
        userProfileDTO.setNumberOfFriendsInCommon(20);
        userProfileDTO.setCommonSocialMedias(socialMedias);
        userProfileDTO.setVerificationList(createVerificationsListTestData());
        userProfileDTO.setBehavioursList(createBehavioursListTestData());

    }
}
