package com.eramo.karpooler.models.dtos;

import android.graphics.Bitmap;

/**
 * Created by Mohamed.Gaber on 11/3/2015.
 */
public class NotificationDTO {

    private int notifyId;
    private Bitmap notifyOwnerImage;
    private String notifyText;
    private String notifyTime;
    private String notifyOwnerName;

    public int getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(int notifyId) {
        this.notifyId = notifyId;
    }

    public Bitmap getNotifyOwnerImage() {
        return notifyOwnerImage;
    }

    public void setNotifyOwnerImage(Bitmap notifyOwnerImage) {
        this.notifyOwnerImage = notifyOwnerImage;
    }

    public String getNotifyText() {
        return notifyText;
    }

    public void setNotifyText(String notifyText) {
        this.notifyText = notifyText;
    }

    public String getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(String notifyTime) {
        this.notifyTime = notifyTime;
    }

    public String getNotifyOwnerName() {
        return notifyOwnerName;
    }

    public void setNotifyOwnerName(String notifyOwnerName) {
        this.notifyOwnerName = notifyOwnerName;
    }
}
