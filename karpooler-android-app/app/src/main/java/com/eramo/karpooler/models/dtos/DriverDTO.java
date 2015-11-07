package com.eramo.karpooler.models.dtos;

import android.graphics.Bitmap;

/**
 * Created by Mohamed.Gaber on 11/7/2015.
 */
public class DriverDTO {

    private Bitmap driverImage;
    private String driverName;

    public Bitmap getDriverImage() {
        return driverImage;
    }

    public void setDriverImage(Bitmap driverImage) {
        this.driverImage = driverImage;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}
