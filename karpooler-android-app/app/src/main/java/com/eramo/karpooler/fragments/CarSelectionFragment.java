package com.eramo.karpooler.fragments;


import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.eramo.karpooler.R;
import com.eramo.karpooler.activities.CarSelectionActivity;
import com.eramo.karpooler.adapters.BrandSpinnerAdapter;
import com.eramo.karpooler.application.MyApplication;
import com.eramo.karpooler.models.dtos.BrandDTO;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        setRetainInstance(true);
    }

    private void prepareUIControllers(){

        prepareBrandSpinner();

        prepareModelsSpinner();

        prepareModelYearsSpinner();

        preparePlateTypesSpinner();

    }

    private void prepareBrandSpinner(){

        Spinner brandSpinner = (Spinner) activity.findViewById(R.id.spinner_brand);

        List<BrandDTO> brands = new ArrayList<>();

        if (activity.getSelectedBrand() !=null)
            brands.add(activity.getSelectedBrand());

        // set spinner adapter
        BrandSpinnerAdapter brandSpinnerAdapter = new BrandSpinnerAdapter(activity, android.R.layout.simple_spinner_item, brands);
        brandSpinner.setAdapter(brandSpinnerAdapter);

        // set spinner on touch listener
        brandSpinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                activity.addSelectBrandFragment();

                return false;
            }
        });

    }

    private void prepareModelsSpinner(){

        Spinner modelSpinner = (Spinner) activity.findViewById(R.id.spinner_model);

        String [] models = {"Captiva", "Cruze", "Aveo"};

        ArrayAdapter adapter = new ArrayAdapter(activity, android.R.layout.simple_spinner_item, models);
        modelSpinner.setAdapter(adapter);

    }

    private void prepareModelYearsSpinner(){

        Spinner modelYearsSpinner = (Spinner) activity.findViewById(R.id.spinner_model_year);

        String [] modelYears = {"2003", "2004", "2005"};

        ArrayAdapter adapter = new ArrayAdapter(activity, android.R.layout.simple_spinner_item, modelYears);
        modelYearsSpinner.setAdapter(adapter);


    }

    private void preparePlateTypesSpinner(){

        Spinner plateTypesSpinner = (Spinner) activity.findViewById(R.id.spinner_plate_type);

        String [] plateTypes = {"numbers"};

        ArrayAdapter adapter = new ArrayAdapter(activity, android.R.layout.simple_spinner_item, plateTypes);
        plateTypesSpinner.setAdapter(adapter);

    }

}
