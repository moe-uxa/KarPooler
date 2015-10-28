package com.eramo.karpooler.activities;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
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

public class CreateTripActivity extends BaseActivity {

    private TextView tv_number;
    private final int PLACE_PICKER_FROM_REQUEST = 1;
    private final int PLACE_PICKER_TO_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_trip);

        // setup tool bar
        setupToolBar();

        // enable home button
        enableUpButton();

        // set toolbar title
        getSupportActionBar().setTitle(getResources().getString(R.string.create_trip));

        prepareUIControllers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_create_trip, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home){

            NavUtils.navigateUpFromSameTask(this);

        }

        return super.onOptionsItemSelected(item);
    }


    private void prepareUIControllers(){

        prepareTypesToggleGroup();

        prepareNumberPicker();

        prepareDateAndTimeSelectors();

        prepareFromLocationBtn();

        prepareToLocationBtn();

        prepareCriteriaLayout();

        prepareTypeSpinner();

        preparePriceSpinner();
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

    private void prepareDateAndTimeSelectors(){

        EditText dateEditText = (EditText) findViewById(R.id.edt_date);
        dateEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                TripDatePickerDialog dialog = new TripDatePickerDialog();
                dialog.show(getSupportFragmentManager(), "");

                return false;
            }
        });

        final EditText timeEditText = (EditText) findViewById(R.id.edt_time);
        timeEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                TimePickerDialog dialog = new TimePickerDialog(CreateTripActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        timeEditText.setText(hourOfDay+":"+minute);
                    }
                }, Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), false);

                dialog.show();

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

    private void prepareTypeSpinner(){

        Spinner typeSpinner = (Spinner) this.findViewById(R.id.spinner_trip_type);

        // test data
        String [] types = {"Work Trip", "Other"};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, types);
        typeSpinner.setAdapter(adapter);

    }

    private void preparePriceSpinner(){

        Spinner priceSpinner = (Spinner) this.findViewById(R.id.spinner_trip_price);

        // test data
        String [] priceOptions = {"Free"};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, priceOptions);
        priceSpinner.setAdapter(adapter);


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
