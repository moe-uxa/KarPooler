package com.eramo.karpooler.models.dtos;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by Mohamed.Gaber on 11/7/2015.
 */
public class TripPersonDTO {

    private int personId;
    private Bitmap personImage;
    private String personName;
    private int numberOfFriendsInCommon;
    private Bitmap [] friendsInCommonSocialMedias;
    private boolean driver;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public Bitmap getPersonImage() {
        return personImage;
    }

    public void setPersonImage(Bitmap personImage) {
        this.personImage = personImage;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getNumberOfFriendsInCommon() {
        return numberOfFriendsInCommon;
    }

    public void setNumberOfFriendsInCommon(int numberOfFriendsInCommon) {
        this.numberOfFriendsInCommon = numberOfFriendsInCommon;
    }

    public Bitmap [] getFriendsInCommonSocialMedias() {
        return friendsInCommonSocialMedias;
    }

    public void setFriendsInCommonSocialMedias(Bitmap [] friendsInCommonSocialMedias) {
        this.friendsInCommonSocialMedias = friendsInCommonSocialMedias;
    }

    public boolean isDriver() {
        return driver;
    }

    public void setDriver(boolean driver) {
        this.driver = driver;
    }
}
