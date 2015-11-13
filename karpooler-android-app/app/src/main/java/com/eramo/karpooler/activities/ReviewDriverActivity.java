package com.eramo.karpooler.activities;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.eramo.karpooler.R;
import com.eramo.karpooler.models.dtos.DriverInfoDTO;
import com.eramo.karpooler.models.dtos.UserProfileDTO;

public class ReviewDriverActivity extends BaseActivity {

    private DriverInfoDTO driverInfoDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_driver);

        // setup tool bar
        setupToolBar();

        // enable home button
        enableUpButton();

        // create test driver info
        createTestData();

        // view user info
        viewUserInfo();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {

            NavUtils.navigateUpFromSameTask(this);

        }

        return super.onOptionsItemSelected(item);
    }

    private void viewUserInfo() {

        // view user image
        ImageView userImage = (ImageView) findViewById(R.id.imgv_user_image);
        userImage.setImageBitmap(driverInfoDTO.getDriverImage());

        // view user name
        TextView userName = (TextView) findViewById(R.id.tv_user_name);
        userName.setText(driverInfoDTO.getDriverName());

        // view user gender and age
        TextView userGenderAge = (TextView) findViewById(R.id.tv_user_gender_age);
        userGenderAge.setText(driverInfoDTO.getDriverGender() + ", " + driverInfoDTO.getDriverAge() + " " + getResources().getString(R.string.years_old));

    }

    private void createTestData(){

        driverInfoDTO = new DriverInfoDTO();

        driverInfoDTO.setDriverId(1);
        driverInfoDTO.setDriverImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person3)).getBitmap());
        driverInfoDTO.setDriverName("Jared Leto");
        driverInfoDTO.setDriverAge(25);
        driverInfoDTO.setDriverGender("Male");

    }
}
