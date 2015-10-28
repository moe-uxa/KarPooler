package com.eramo.karpooler.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.eramo.karpooler.R;
import com.eramo.karpooler.services.callbacks.ServiceErrorCallback;
import com.eramo.karpooler.apis.LoginAPI;
import com.eramo.karpooler.services.callbacks.ServiceSuccessCallback;
import com.eramo.karpooler.models.dtos.ErrorDTO;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class LoginActivity extends AppCompatActivity {

    private CallbackManager callbackManager;
    private LoginAPI loginAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // init login API
        loginAPI = new LoginAPI();

        // initialize facebook sdk
        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_login);

        final LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_friends");

        // If using in a fragment
        //loginButton.setFragment(this);


        // create call back manager
        callbackManager = CallbackManager.Factory.create();

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                login(loginResult);
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

    }

    private void login(LoginResult loginResult){

        loginAPI.login(loginResult, new ServiceSuccessCallback() {
            @Override
            public void onSuccess(Object response) {

                // navigate to car selection activity
                Intent intent = new Intent(LoginActivity.this, CarSelectionActivity.class);
                startActivity(intent);

            }
        }, new ServiceErrorCallback<ErrorDTO>() {
            @Override
            public void onError(ErrorDTO errorResponse) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
