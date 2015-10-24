package com.eramo.karpooler.application;

/**
 * Created by Mohamed.Gaber on 9/2/2015.
 */

import android.app.Application;


public class MyApplication extends Application {

    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

}

