package com.eramo.karpooler.activities;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.eramo.karpooler.R;
import com.eramo.karpooler.adapters.BrandSpinnerAdapter;
import com.eramo.karpooler.apis.CarSelectionAPI;
import com.eramo.karpooler.helpers.Constants;
import com.eramo.karpooler.models.dtos.BrandDTO;

import java.util.ArrayList;
import java.util.List;

public class CarSelectionActivity extends BaseActivity  {

    private CarSelectionAPI carSelectionAPI;
    private boolean brandSelectionActivityOpened;
    private Spinner brandSpinner;
    private BrandSpinnerAdapter brandSpinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_selection);

        // setup tool bar
        setupToolBar();

        // enable home button
        enableUpButton();

        // set toolbar title
        getSupportActionBar().setTitle(getResources().getString(R.string.your_car));

        // create car selection api
        carSelectionAPI = new CarSelectionAPI();

        // prepare ui controller
        prepareUIControllers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_car_selection, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.action_skip){

            skip();
        }

        if (id == android.R.id.home){

            NavUtils.navigateUpFromSameTask(this);

        }

        return super.onOptionsItemSelected(item);
    }


    private void prepareUIControllers(){

        prepareBrandSpinner();

        prepareModelsSpinner();

        prepareModelYearsSpinner();

        preparePlateTypesSpinner();

        prepareSaveAndGoBtn();

    }

    private void setBrandSpinnerSelectedBrand(BrandDTO brandDTO){
        brandSpinnerAdapter.clear();
        brandSpinnerAdapter.add(brandDTO);
        brandSpinnerAdapter.notifyDataSetChanged();
    }

    private void prepareBrandSpinner(){

        brandSpinner = (Spinner) findViewById(R.id.spinner_brand);

        // set spinner adapter
        brandSpinnerAdapter = new BrandSpinnerAdapter(this, android.R.layout.simple_spinner_item, new ArrayList<BrandDTO>());
        brandSpinner.setAdapter(brandSpinnerAdapter);

        // set spinner on touch listener
        brandSpinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (!brandSelectionActivityOpened) {
                    brandSelectionActivityOpened = true;
                    startActivityForResult(new Intent(CarSelectionActivity.this, SelectBrandActivity.class), Constants.SELECT_BRAND_REQUEST);
                }

                return false;
            }
        });

    }

    private void prepareModelsSpinner(){

        Spinner modelSpinner = (Spinner) this.findViewById(R.id.spinner_model);

        // test data
        String [] models = {"Captiva", "Cruze", "Aveo"};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, models);
        modelSpinner.setAdapter(adapter);

    }

    private void prepareModelYearsSpinner(){

        Spinner modelYearsSpinner = (Spinner) this.findViewById(R.id.spinner_model_year);

        //test data
        String [] modelYears = {"2003", "2004", "2005"};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, modelYears);
        modelYearsSpinner.setAdapter(adapter);


    }

    private void preparePlateTypesSpinner(){

        Spinner plateTypesSpinner = (Spinner) this.findViewById(R.id.spinner_plate_type);

        // test data
        String [] plateTypes = {"numbers"};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, plateTypes);
        plateTypesSpinner.setAdapter(adapter);

    }

    private void prepareSaveAndGoBtn(){

        Button saveAndContinueBtn = (Button) findViewById(R.id.btn_save_and_go);
        saveAndContinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // go to create trip activity
                startActivity(new Intent(CarSelectionActivity.this, CreateTripActivity.class));
            }
        });

    }

    public void skip(){

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        brandSelectionActivityOpened = false;

        if (requestCode == Constants.SELECT_BRAND_REQUEST && resultCode == RESULT_OK){

            BrandDTO brandDTO = data.getExtras().getParcelable(Constants.SELECTED_BRAND_EXTRA_KEY);

            setBrandSpinnerSelectedBrand(brandDTO);
        }
    }
}
