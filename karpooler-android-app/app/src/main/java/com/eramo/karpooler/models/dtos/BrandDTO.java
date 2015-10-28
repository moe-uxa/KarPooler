package com.eramo.karpooler.models.dtos;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mohamed.Gaber on 10/24/2015.
 */
public class BrandDTO implements Parcelable{

    private int brandId;
    private String brandName;
    private Bitmap brandImage;

    public BrandDTO(){

    }

    protected BrandDTO(Parcel in) {
        brandId = in.readInt();
        brandName = in.readString();
        brandImage = in.readParcelable(Bitmap.class.getClassLoader());
    }

    public static final Creator<BrandDTO> CREATOR = new Creator<BrandDTO>() {
        @Override
        public BrandDTO createFromParcel(Parcel in) {
            return new BrandDTO(in);
        }

        @Override
        public BrandDTO[] newArray(int size) {
            return new BrandDTO[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(brandId);
        dest.writeString(brandName);
        dest.writeParcelable(brandImage, flags);
    }
}
