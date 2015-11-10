package com.eramo.karpooler.models.dtos;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by Mohamed.Gaber on 11/10/2015.
 */
public class UserProfileDTO {

    private int userId;
    private String userName;
    private Bitmap userImage;
    private int userAge;
    private String userGender;
    private String RegistrationDate;
    private int userRate;
    private String userPhoneNumber;
    private String userLocation;
    private int numberOfFriendsInCommon;
    private Bitmap [] commonSocialMedias;
    private List<VerificationDTO> verificationList;
    private List<BehaviourDTO> behavioursList;

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

    public int getUserRate() {
        return userRate;
    }

    public void setUserRate(int userRate) {
        this.userRate = userRate;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
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

    public List<VerificationDTO> getVerificationList() {
        return verificationList;
    }

    public void setVerificationList(List<VerificationDTO> verificationList) {
        this.verificationList = verificationList;
    }

    public List<BehaviourDTO> getBehavioursList() {
        return behavioursList;
    }

    public void setBehavioursList(List<BehaviourDTO> behavioursList) {
        this.behavioursList = behavioursList;
    }
}
