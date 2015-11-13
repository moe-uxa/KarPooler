package com.eramo.karpooler.models.dtos;

import android.graphics.Bitmap;

/**
 * Created by Mohamed.Gaber on 11/13/2015.
 */
public class ShortUserProfileDTO {

    private int userId;
    private String userName;
    private Bitmap userImage;
    private int userAge;
    private String userGender;
    private String RegistrationDate;
    private int numberOfFriendsInCommon;
    private Bitmap [] commonSocialMedias;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Bitmap getUserImage() {
        return userImage;
    }

    public void setUserImage(Bitmap userImage) {
        this.userImage = userImage;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        RegistrationDate = registrationDate;
    }

    public int getNumberOfFriendsInCommon() {
        return numberOfFriendsInCommon;
    }

    public void setNumberOfFriendsInCommon(int numberOfFriendsInCommon) {
        this.numberOfFriendsInCommon = numberOfFriendsInCommon;
    }

    public Bitmap[] getCommonSocialMedias() {
        return commonSocialMedias;
    }

    public void setCommonSocialMedias(Bitmap[] commonSocialMedias) {
        this.commonSocialMedias = commonSocialMedias;
    }
}
