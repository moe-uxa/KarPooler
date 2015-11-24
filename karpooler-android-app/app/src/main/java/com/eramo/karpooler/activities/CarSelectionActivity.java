package com.eramo.karpooler.activities;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import com.eramo.karpooler.R;
import com.eramo.karpooler.adapters.BrandSpinnerAdapter;
import com.eramo.karpooler.helpers.Constants;
import com.eramo.karpooler.models.dtos.BrandDTO;
import java.util.ArrayList;

public class CarSelectionActivity extends BaseActivity  {

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

    /**
     * to show selected brand
     * @param brandDTO
     */
    private void setBrandSpinnerSelectedBrand(BrandDTO brandDTO){

        // clear all brands
        brandSpinnerAdapter.clear();

        // add just one brand
        brandSpinnerAdapter.add(brandDTO);

        // notify changes
        brandSpinnerAdapter.notifyDataSetChanged();
    }

    /**
     * set brand spinner data and set listeners
     */
    private void prepareBrandSpinner(){

        // get brand spinner by id
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

    /**
     * set model spinner data and set listeners
     */
    private void prepareModelsSpinner(){

        Spinner modelSpinner = (Spinner) this.findViewById(R.id.spinner_model);

        // test data
        String [] models = {"Captiva", "Cruze", "Aveo"};

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.simple_spinner_item, models);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        modelSpinner.setAdapter(adapter);

    }

    /**
     * set model spinner data and set listeners
     */
    private void prepareModelYearsSpinner(){

        Spinner modelYearsSpinner = (Spinner) this.findViewById(R.id.spinner_model_year);

        //test data
        String [] modelYears = {"2003", "2004", "2005"};

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.simple_spinner_item, modelYears);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        modelYearsSpinner.setAdapter(adapter);


    }

    /**
     * set plate type spinner data and set listeners
     */
    private void preparePlateTypesSpinner(){

        Spinner plateTypesSpinner = (Spinner) this.findViewById(R.id.spinner_plate_type);

        // test data
        String [] plateTypes = {"numbers"};

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.simple_spinner_item, plateTypes);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        plateTypesSpinner.setAdapter(adapter);

    }

    private void prepareSaveAndGoBtn(){

        Button saveAndContinueBtn = (Button) findViewById(R.id.btn_save_and_go);
        saveAndContinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveCarSelection();

            }
        });

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

    public void skip(){

        // go to create trip activity
        startActivity(new Intent(CarSelectionActivity.this, CreateTripActivity.class));
    }

    private void saveCarSelection(){

        // go to create trip activity
        startActivity(new Intent(CarSelectionActivity.this, CreateTripActivity.class));
    }
}
