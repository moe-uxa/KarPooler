package com.eramo.karpooler.activities;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.eramo.karpooler.R;
import com.eramo.karpooler.dialogs.DistanceDialog;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;


public class RideNowActivity extends BaseActivity {

    private final int PLACE_PICKER_FROM_REQUEST = 1;
    private final int PLACE_PICKER_TO_REQUEST = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_now);

        // setup tool bar
        setupToolBar();

        // enable home button
        enableUpButton();

        // set toolbar title
        getSupportActionBar().setTitle(getResources().getString(R.string.ride_now));

        // prepare ui controller
        prepareUIControllers();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {

            NavUtils.navigateUpFromSameTask(this);

        }

        return super.onOptionsItemSelected(item);
    }

    private void prepareUIControllers() {

        prepareTypesToggleGroup();

        prepareFromLocationBtn();

        prepareToLocationBtn();

        prepareDistanceBtn();

    }

    private void prepareTypesToggleGroup() {

        final RadioGroup typesRadioGroup = (RadioGroup) findViewById(R.id.radio_group_types);
        typesRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                for (int j = 0; j < typesRadioGroup.getChildCount(); j++) {
                    final ToggleButton view = (ToggleButton) typesRadioGroup.getChildAt(j);
                    view.setChecked(view.getId() == checkedId);

                    // set toggle button text color based on state
                    ToggleButton toggleButton = (ToggleButton) view;
                    if (toggleButton.isChecked()) {
                        toggleButton.setTextColor(getResources().getColor(R.color.colorAccent));
                        toggleButton.setEnabled(false);
                    } else {
                        toggleButton.setTextColor(getResources().getColor(R.color.toggle_normal_text_color));
                        toggleButton.setEnabled(true);
                    }

                }
            }
        });

    }

    public void onToggle(View view) {

        ((RadioGroup) view.getParent()).check(view.getId());
    }

    private void prepareFromLocationBtn() {

        Button fromLocationBtn = (Button) findViewById(R.id.btn_pickup_location);
        fromLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openPlacePicker(PLACE_PICKER_FROM_REQUEST);
            }
        });

    }

    private void prepareToLocationBtn() {

        Button fromLocationBtn = (Button) findViewById(R.id.btn_drop_off);
        fromLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openPlacePicker(PLACE_PICKER_TO_REQUEST);
            }
        });

    }

    private void openPlacePicker(int requestId) {

        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

        try {
            startActivityForResult(builder.build(RideNowActivity.this), requestId);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }

    }

    private void prepareDistanceBtn(){

        Button distance = (Button) findViewById(R.id.btn_distance);
        distance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // open distance dialog
                DistanceDialog distanceDialog = new DistanceDialog();
                distanceDialog.show(getSupportFragmentManager(), null);

            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // pickup from location
        if (requestCode == PLACE_PICKER_FROM_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                String toastMsg = String.format("Place: %s", place.getName());
                Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
            }
        }

        // Drop off to location
        if (requestCode == PLACE_PICKER_TO_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                String toastMsg = String.format("Place: %s", place.getName());
                Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
            }
        }

    }

}
