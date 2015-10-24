package com.eramo.karpooler.models.dtos;

import android.graphics.Bitmap;

/**
 * Created by Mohamed.Gaber on 10/24/2015.
 */
public class BrandDTO {

    private int brandId;
    private String brandName;
    private Bitmap brandImage;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Bitmap getBrandImage() {
        return brandImage;
    }

    public void setBrandImage(Bitmap brandImage) {
        this.brandImage = brandImage;
    }
}
