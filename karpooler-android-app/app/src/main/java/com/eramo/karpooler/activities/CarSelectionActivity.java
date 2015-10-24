package com.eramo.karpooler.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eramo.karpooler.R;
import com.eramo.karpooler.apis.CarSelectionAPI;
import com.eramo.karpooler.fragments.CarSelectionFragment;
import com.eramo.karpooler.fragments.SelectBrandFragment;

public class CarSelectionActivity extends AppCompatActivity {

    private CarSelectionAPI carSelectionAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_selection);

        // create car selection api
        carSelectionAPI = new CarSelectionAPI();

        // add car selection fragment
        addCarSelectionFragment();
    }


    private void addCarSelectionFragment(){
        CarSelectionFragment carSelectionFragment = new CarSelectionFragment();
        getFragmentManager().beginTransaction().add(R.id.layout_container, carSelectionFragment).addToBackStack(null).commit();
    }

    public void addSelectBrandFragment(){
        SelectBrandFragment selectBrandFragment = new SelectBrandFragment();
        getFragmentManager().beginTransaction().replace(R.id.layout_container, selectBrandFragment).addToBackStack(null).commit();
    }

    public CarSelectionAPI getCarSelectionAPI() {
        return carSelectionAPI;
    }
}
