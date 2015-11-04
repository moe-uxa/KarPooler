package com.eramo.karpooler.fragments;


import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.eramo.karpooler.R;
import com.eramo.karpooler.activities.HomeActivity;
import com.eramo.karpooler.adapters.BrandsRecyclerViewAdapter;
import com.eramo.karpooler.adapters.MoreMenuRecyclerViewAdapter;
import com.eramo.karpooler.models.dtos.BrandDTO;
import com.eramo.karpooler.models.dtos.MenuItemDTO;
import com.eramo.karpooler.models.dtos.MenuUserInfoDTO;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MoreFragment extends BaseFragment {


    private HomeActivity activity;
    private MoreMenuRecyclerViewAdapter moreMenuRecyclerViewAdapter;

    // Menu items constants
    private final int MY_ROUTE_ITEM = 0;
    private final int MY_RATING_ITEM = 1;
    private final int MY_VERIFICATION_LIST_ITEM = 2;
    private final int INVITE_FRIENDS_ITEM = 3;
    private final int CONTACT_US_ITEM = 4;
    private final int LOGOUT_ITEM = 5;
    private final int DELETE_ACCOUNT_ITEM = 6;

    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // get activity instance
        activity = (HomeActivity) getActivity();

        // prepare user info layout
        //prepareUserInfoLayout();

        // prepare recycler view
        prepareRecyclerView();

        // create test data
        createTestData();

    }


    private void createTestData(){

        MenuUserInfoDTO userInfoDTO = new MenuUserInfoDTO();
        userInfoDTO.setUserAge(23);
        userInfoDTO.setUserGender("Male");
        userInfoDTO.setUserName("Alex Mazovski");
        userInfoDTO.setUserImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person5)).getBitmap());

        viewUserInfo(userInfoDTO);

    }

    private void prepareUserInfoLayout(){

//        userImage = (ImageView) activity.findViewById(R.id.imgv_user_image);
//        userName = (TextView) activity.findViewById(R.id.tv_user_name);
//        userGenderAge = (TextView) activity.findViewById(R.id.tv_user_gender_age);
        Button viewProfile = (Button) activity.findViewById(R.id.btn_view_user_profile);
        viewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void viewUserInfo(MenuUserInfoDTO userInfoDTO){

        ImageView userImage = (ImageView) activity.findViewById(R.id.imgv_user_image);
        TextView userName = (TextView) activity.findViewById(R.id.tv_user_name);
        TextView userGenderAge = (TextView) activity.findViewById(R.id.tv_user_gender_age);

        userImage.setImageBitmap(userInfoDTO.getUserImage());
        userName.setText(userInfoDTO.getUserName());
        userGenderAge.setText((userInfoDTO.getUserGender()+", "+userInfoDTO.getUserAge()+" years old"));

    }

    private void prepareRecyclerView(){

        RecyclerView menuRecyclerView = (RecyclerView) activity.findViewById(R.id.recycler_view_menu);
        menuRecyclerView.setHasFixedSize(true);

        // set recycler view divider
        menuRecyclerView.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(activity)
                        .drawable(R.drawable.divider)
                        .build());

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity);
        menuRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        moreMenuRecyclerViewAdapter = new MoreMenuRecyclerViewAdapter(getMenuItems(), this);
        menuRecyclerView.setAdapter(moreMenuRecyclerViewAdapter);

    }

    private List<MenuItemDTO> getMenuItems(){

        List<MenuItemDTO> menuItems = new ArrayList<>();

        String [] menuStrings = getResources().getStringArray(R.array.menu_items);

        for (int index = 0; index < menuStrings.length; index++){

            MenuItemDTO menuItemDTO = null;

            switch (index){

                case MY_ROUTE_ITEM:

                    menuItemDTO = new MenuItemDTO(R.drawable.ic_route, menuStrings[index], new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });

                    break;

                case MY_RATING_ITEM:

                    menuItemDTO = new MenuItemDTO(R.drawable.ic_rating, menuStrings[index], new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });

                    break;

                case MY_VERIFICATION_LIST_ITEM:

                    menuItemDTO = new MenuItemDTO(R.drawable.ic_varify, menuStrings[index], new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });

                    break;

                case INVITE_FRIENDS_ITEM:

                    menuItemDTO = new MenuItemDTO(R.drawable.ic_invite, menuStrings[index], new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });

                    break;

                case CONTACT_US_ITEM:

                    menuItemDTO = new MenuItemDTO(R.drawable.ic_contact, menuStrings[index], new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });

                    break;

                case LOGOUT_ITEM:

                    menuItemDTO = new MenuItemDTO(R.drawable.ic_logout, menuStrings[index], new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });

                    break;

                case DELETE_ACCOUNT_ITEM:

                    menuItemDTO = new MenuItemDTO(R.drawable.ic_delete, menuStrings[index], new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });

                    break;

            }

            menuItems.add(menuItemDTO);
        }

        return menuItems;
    }

}
