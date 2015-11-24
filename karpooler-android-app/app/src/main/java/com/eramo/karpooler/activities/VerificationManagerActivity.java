package com.eramo.karpooler.activities;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.eramo.karpooler.R;
import com.eramo.karpooler.helpers.Constants;
import com.eramo.karpooler.models.dtos.UserVerificationDTO;
import java.util.ArrayList;
import java.util.List;

public class VerificationManagerActivity extends BaseActivity implements View.OnClickListener {

    // verification values
    private TextView facebookVerifyValue;
    private TextView linkedInVerifyValue;
    private TextView twitterVerifyValue;
    private TextView payPalVerifyValue;
    private TextView googleVerifyValue;
    private TextView idCardVerifyValue;
    private TextView corpMailVerifyValue;
    private TextView emailVerifyValue;
    private TextView mobileVerifyValue;
    private TextView carPlatesVerifyValue;

    // verification buttons
    private Button facebookVerifyBtn;
    private Button linkedInVerifyBtn;
    private Button twitterVerifyBtn;
    private Button payPalVerifyBtn;
    private Button googleVerifyBtn;
    private Button idCardVerifyBtn;
    private Button corpMailVerifyBtn;
    private Button emailVerifyBtn;
    private Button mobileVerifyBtn;
    private Button carPlatesVerifyBtn;

    List<UserVerificationDTO> verificationsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_manager);

        // createTestData
        createTestData();

        // setup tool bar
        setupToolBar();

        // enable home button
        enableUpButton();

        // set tool title
        getSupportActionBar().setTitle(getResources().getString(R.string.my_verification));

        // prepare UI controllers
        prepareUIControllers();

        // bind verification data
        bindVerificationData();
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

        // verification values
        facebookVerifyValue = (TextView) findViewById(R.id.tv_value_facebook);
        linkedInVerifyValue = (TextView) findViewById(R.id.tv_value_linkedIn);
        twitterVerifyValue = (TextView) findViewById(R.id.tv_value_twitter);
        payPalVerifyValue = (TextView) findViewById(R.id.tv_value_payPal);
        googleVerifyValue = (TextView) findViewById(R.id.tv_value_google);
        idCardVerifyValue = (TextView) findViewById(R.id.tv_value_id_card);
        corpMailVerifyValue = (TextView) findViewById(R.id.tv_value_corp_mail);
        emailVerifyValue = (TextView) findViewById(R.id.tv_value_email);
        mobileVerifyValue = (TextView) findViewById(R.id.tv_value_mobile);
        carPlatesVerifyValue = (TextView) findViewById(R.id.tv_value_car_plates);

        // verification buttons
        facebookVerifyBtn = (Button) findViewById(R.id.btn_verify_facebook);
        linkedInVerifyBtn = (Button) findViewById(R.id.btn_verify_linkedIn);
        twitterVerifyBtn = (Button) findViewById(R.id.btn_verify_twitter);
        payPalVerifyBtn = (Button) findViewById(R.id.btn_verify_payPal);
        googleVerifyBtn = (Button) findViewById(R.id.btn_verify_google);
        idCardVerifyBtn = (Button) findViewById(R.id.btn_verify_id_card);
        corpMailVerifyBtn = (Button) findViewById(R.id.btn_verify_corp_mail);
        emailVerifyBtn = (Button) findViewById(R.id.btn_verify_email);
        mobileVerifyBtn = (Button) findViewById(R.id.btn_verify_mobile);
        carPlatesVerifyBtn = (Button) findViewById(R.id.btn_verify_car_plates);

        // set on click listeners
        facebookVerifyBtn.setOnClickListener(this);
        linkedInVerifyBtn.setOnClickListener(this);
        twitterVerifyBtn.setOnClickListener(this);
        payPalVerifyBtn.setOnClickListener(this);
        googleVerifyBtn.setOnClickListener(this);
        idCardVerifyBtn.setOnClickListener(this);
        corpMailVerifyBtn.setOnClickListener(this);
        emailVerifyBtn.setOnClickListener(this);
        mobileVerifyBtn.setOnClickListener(this);
        carPlatesVerifyBtn.setOnClickListener(this);
    }

    private void bindVerificationData(){

        for (UserVerificationDTO verificationDTO : verificationsList){

            switch (verificationDTO.getVerificationId()){

                case Constants.FACEBOOK_VERIFY_ID:
                    facebookVerifyValue.setText(verificationDTO.getVerificationValue());
                    setVerifiedIcon(facebookVerifyBtn);
                    break;

                case Constants.LINKED_IN_VERIFY_ID:
                    linkedInVerifyValue.setText(verificationDTO.getVerificationValue());
                    setVerifiedIcon(linkedInVerifyBtn);
                    break;

                case Constants.TWITTER_VERIFY_ID:
                    twitterVerifyValue.setText(verificationDTO.getVerificationValue());
                    setVerifiedIcon(twitterVerifyBtn);
                    break;

                case Constants.PAY_PAL_VERIFY_ID:
                    payPalVerifyValue.setText(verificationDTO.getVerificationValue());
                    setVerifiedIcon(payPalVerifyBtn);
                    break;

                case Constants.GOOGLE_PLUS_VERIFY_ID:
                    googleVerifyValue.setText(verificationDTO.getVerificationValue());
                    setVerifiedIcon(googleVerifyBtn);
                    break;

                case Constants.ID_CARD_VERIFY_ID:
                    idCardVerifyValue.setText(verificationDTO.getVerificationValue());
                    setVerifiedIcon(idCardVerifyBtn);
                    break;

                case Constants.CORP_MAIL_VERIFY_ID:
                    corpMailVerifyValue.setText(verificationDTO.getVerificationValue());
                    setVerifiedIcon(corpMailVerifyBtn);
                    break;

                case Constants.EMAIL_VERIFY_ID:
                    emailVerifyValue.setText(verificationDTO.getVerificationValue());
                    setVerifiedIcon(emailVerifyBtn);
                    break;

                case Constants.MOBILE_VERIFY_ID:
                    mobileVerifyValue.setText(verificationDTO.getVerificationValue());
                    setVerifiedIcon(mobileVerifyBtn);
                    break;

                case Constants.CAR_PLATES_VERIFY_ID:
                    carPlatesVerifyValue.setText(verificationDTO.getVerificationValue());
                    setVerifiedIcon(carPlatesVerifyBtn);
                    break;


            }

        }

    }

    @Override
    public void onClick(View v) {

        setVerifiedIcon((Button)v);

    }

    private void setVerifiedIcon(Button button){

        button.setText("");
        button.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.ic_verified), null);
        button.setEnabled(false);

    }

    private void createTestData(){

        verificationsList = new ArrayList<>();

        verificationsList.add(new UserVerificationDTO(Constants.FACEBOOK_VERIFY_ID, "mgaberali"));
        verificationsList.add(new UserVerificationDTO(Constants.LINKED_IN_VERIFY_ID, "m.gaber.ali"));
        verificationsList.add(new UserVerificationDTO(Constants.TWITTER_VERIFY_ID, "@mgaberali"));
        verificationsList.add(new UserVerificationDTO(Constants.MOBILE_VERIFY_ID, "012432242434"));

    }
}
