package com.eramo.karpooler.models.dtos;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by Mohamed.Gaber on 11/9/2015.
 */
public class TripMatchDTO {

    private int tripId;
    private Bitmap tripOwnerImage;
    private String tripOwnerName;
    private int tripOwnerRate;
    private int numberOfFriendsInCommon;
    private Bitmap [] commonFriendsSocialMediasIcons;
    private Bitmap [] verificationsIcons;

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public Bitmap getTripOwnerImage() {
        return tripOwnerImage;
    }

    public void setTripOwnerImage(Bitmap tripOwnerImage) {
        this.tripOwnerImage = tripOwnerImage;
    }

    public String getTripOwnerName() {
        return tripOwnerName;
    }

    public void setTripOwnerName(String tripOwnerName) {
        this.tripOwnerName = tripOwnerName;
    }

    public int getTripOwnerRate() {
        return tripOwnerRate;
    }

    public void setTripOwnerRate(int tripOwnerRate) {
        this.tripOwnerRate = tripOwnerRate;
    }

    public int getNumberOfFriendsInCommon() {
        return numberOfFriendsInCommon;
    }

    public void setNumberOfFriendsInCommon(int numberOfFriendsInCommon) {
        this.numberOfFriendsInCommon = numberOfFriendsInCommon;
    }

    public Bitmap[] getCommonFriendsSocialMediasIcons() {
        return commonFriendsSocialMediasIcons;
    }

    public void setCommonFriendsSocialMediasIcons(Bitmap[] commonFriendsSocialMediasIcons) {
        this.commonFriendsSocialMediasIcons = commonFriendsSocialMediasIcons;
    }

    public Bitmap[] getVerificationsIcons() {
        return verificationsIcons;
    }

    public void setVerificationsIcons(Bitmap[] verificationsIcons) {
        this.verificationsIcons = verificationsIcons;
    }
}
