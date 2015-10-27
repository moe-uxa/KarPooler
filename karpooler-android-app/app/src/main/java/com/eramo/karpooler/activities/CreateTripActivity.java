package com.eramo.karpooler.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.eramo.karpooler.R;
import com.eramo.karpooler.dialogs.TripDatePickerDialog;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import org.apmem.tools.layouts.FlowLayout;

import java.util.Calendar;

public class CreateTripActivity extends AppCompatActivity {

    private TextView tv_number;
    private final int PLACE_PICKER_FROM_REQUEST = 1;
    private final int PLACE_PICKER_TO_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_trip);

        prepareUIControllers();
    }

    private void prepareUIControllers(){

        prepareTypesToggleGroup();

        prepareNumberPicker();

        prepareDateAndTimeButtons();

        prepareFromLocationBtn();

        prepareToLocationBtn();

        prepareCriteriaLayout();
    }

    private void prepareTypesToggleGroup(){

        final RadioGroup typesRadioGroup  = (RadioGroup) findViewById(R.id.radio_group_types);
        typesRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                for (int j = 0; j < typesRadioGroup.getChildCount(); j++) {
                    final ToggleButton view = (ToggleButton) typesRadioGroup.getChildAt(j);
                    view.setChecked(view.getId() == checkedId);
                }
            }
        });

    }

    private void prepareNumberPicker(){

        tv_number = (TextView) findViewById(R.id.tv_number);

        Button increaseButton = (Button) findViewById(R.id.btn_increase);
        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseNumber();
            }
        });

        Button decreaseButton = (Button) findViewById(R.id.btn_decrease);
        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseNumber();
            }
        });

    }

    private void prepareDateAndTimeButtons(){

        EditText dateEditText = (EditText) findViewById(R.id.edt_date);
        dateEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                TripDatePickerDialog dialog = new TripDatePickerDialog();
                dialog.show(getSupportFragmentManager(), "");

                return false;
            }
        });
    }

    public void onToggle(View view) {
        ((RadioGroup)view.getParent()).check(view.getId());
        // app specific stuff ..
    }

  private void increaseNumber(){

       int numberOfSeat = Integer.parseInt(tv_number.getText().toString());
      numberOfSeat++;

      if(numberOfSeat>4)
          numberOfSeat = 4;

      tv_number.setText(numberOfSeat + "");
  }
    private void decreaseNumber(){

        int numberOfSeat = Integer.parseInt(tv_number.getText().toString());
        numberOfSeat--;

        if(numberOfSeat<0)
            numberOfSeat = 0;

        tv_number.setText(numberOfSeat + "");
    }

    private void prepareFromLocationBtn(){

        Button fromLocationBtn = (Button) findViewById(R.id.btn_pickup_location);
        fromLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openPlacePicker(PLACE_PICKER_FROM_REQUEST);
            }
        });

    }

    private void prepareToLocationBtn(){

        Button fromLocationBtn = (Button) findViewById(R.id.btn_drop_off);
        fromLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openPlacePicker(PLACE_PICKER_TO_REQUEST);
            }
        });

    }

    private void prepareCriteriaLayout(){

        FlowLayout criteriaLayout = (FlowLayout) findViewById(R.id.layout_criteria);

        // create test data
        criteriaLayout.addView(generateCriteriaToggleButton("Male"));
        criteriaLayout.addView(generateCriteriaToggleButton("Female"));
        criteriaLayout.addView(generateCriteriaToggleButton("Smoker"));
        criteriaLayout.addView(generateCriteriaToggleButton("Friends"));
        criteriaLayout.addView(generateCriteriaToggleButton("Friends of friends"));
        criteriaLayout.addView(generateCriteriaToggleButton("Music"));
        criteriaLayout.addView(generateCriteriaToggleButton("Quran"));

    }

    private ToggleButton generateCriteriaToggleButton (String criteriaName){

        ToggleButton toggleButton = (ToggleButton) getLayoutInflater().inflate(R.layout.criteria_toggle_button, null);
        toggleButton.setTextOff(criteriaName);
        toggleButton.setTextOn(criteriaName);
        toggleButton.setChecked(false);

        int ht_px = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics());
        FlowLayout.LayoutParams layoutParams = new FlowLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ht_px);
        layoutParams.setMargins(20, 20, 20, 20);
        toggleButton.setLayoutParams(layoutParams);

        return toggleButton;
    }

    private void openPlacePicker(int requestId){

        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

        try {
            startActivityForResult(builder.build(CreateTripActivity.this), requestId);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }

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
