package com.eramo.karpooler.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.eramo.karpooler.R;

public class CreateTripActivity extends AppCompatActivity {

    private TextView tv_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_trip);

        prepareUIControllers();
    }

    private void prepareUIControllers(){

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
        //number picker business

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

        tv_number.setText(numberOfSeat+"");
    }
}
