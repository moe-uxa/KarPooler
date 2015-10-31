package com.eramo.karpooler.models.dtos;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by Mohamed.Gaber on 10/30/2015.
 */
public class FeedDTO {

    private int feedId;
    private Bitmap ownerImage;
    private String ownerName;
    private String feedTitle;
    private String feedTime;
    private int numberOfFriendsInCommon;
    private Bitmap [] socialMediasList;
    private String feedDescription;

    public int getFeedId() {
        return feedId;
    }

    public void setFeedId(int feedId) {
        this.feedId = feedId;
    }

    public Bitmap getOwnerImage() {
        return ownerImage;
    }

    public void setOwnerImage(Bitmap ownerImage) {
        this.ownerImage = ownerImage;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getFeedTitle() {
        return feedTitle;
    }

    public void setFeedTitle(String feedTitle) {
        this.feedTitle = feedTitle;
    }

    public String getFeedTime() {
        return feedTime;
    }

    public void setFeedTime(String feedTime) {
        this.feedTime = feedTime;
    }

    public int getNumberOfFriendsInCommon() {
        return numberOfFriendsInCommon;
    }

    public void setNumberOfFriendsInCommon(int numberOfFriendsInCommon) {
        this.numberOfFriendsInCommon = numberOfFriendsInCommon;
    }

    public Bitmap[] getSocialMediasList() {
        return socialMediasList;
    }

    public void setSocialMediasList(Bitmap[] socialMediasList) {
        this.socialMediasList = socialMediasList;
    }

    public String getFeedDescription() {
        return feedDescription;
    }

    public void setFeedDescription(String feedDescription) {
        this.feedDescription = feedDescription;
    }
}
