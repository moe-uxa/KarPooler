package com.eramo.karpooler.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.eramo.karpooler.R;
import com.eramo.karpooler.activities.CarSelectionActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarSelectionFragment extends Fragment {

    CarSelectionActivity activity;

    public CarSelectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_car_selection, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // get activity reference
        activity = (CarSelectionActivity) getActivity();

        prepareUIControllers();

    }


    private void prepareUIControllers(){

        Spinner brandSpinner = (Spinner) activity.findViewById(R.id.spinner_brand);
        brandSpinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                activity.addSelectBrandFragment();

                return false;
            }
        });


    }

}
