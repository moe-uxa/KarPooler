package com.eramo.karpooler.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.eramo.karpooler.R;
import com.eramo.karpooler.activities.CarSelectionActivity;
import com.eramo.karpooler.adapters.BrandsRecyclerViewAdapter;
import com.eramo.karpooler.models.dtos.BrandDTO;
import com.eramo.karpooler.models.dtos.ErrorDTO;
import com.eramo.karpooler.services.callbacks.ServiceErrorCallback;
import com.eramo.karpooler.services.callbacks.ServiceSuccessCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectBrandFragment extends Fragment {

    private CarSelectionActivity activity;
    private BrandsRecyclerViewAdapter brandsRecyclerViewAdapter;

    public SelectBrandFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_brand, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // get activity reference
        activity = (CarSelectionActivity) getActivity();

        prepareUIControllers();

        // load brands
        loadBrands();



    }

    private void loadBrands(){

        activity.getCarSelectionAPI().loadBrands(new ServiceSuccessCallback<List<BrandDTO>>() {
            @Override
            public void onSuccess(List<BrandDTO> response) {

                brandsRecyclerViewAdapter.setBrands(response);
                brandsRecyclerViewAdapter.notifyDataSetChanged();
            }
        }, new ServiceErrorCallback<ErrorDTO>() {
            @Override
            public void onError(ErrorDTO errorResponse) {

            }
        });

    }

    private void prepareUIControllers(){

        RecyclerView brandRecyclerView = (RecyclerView) activity.findViewById(R.id.recycler_view_brands);
        //brandRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        brandRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        brandsRecyclerViewAdapter = new BrandsRecyclerViewAdapter(new ArrayList<BrandDTO>());
        brandRecyclerView.setAdapter(brandsRecyclerViewAdapter);

    }

}
