package com.eramo.karpooler.models.dtos;

import android.graphics.Bitmap;

/**
 * Created by Mohamed.Gaber on 11/2/2015.
 */
public class MessageDTO {

    private int messageId;
    private Bitmap messageOwner;
    private String message;
    private String messageTime;
    private String messageOwnerName;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public Bitmap getMessageOwner() {
        return messageOwner;
    }

    public void setMessageOwner(Bitmap messageOwner) {
        this.messageOwner = messageOwner;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageOwnerName() {
        return messageOwnerName;
    }

    public void setMessageOwnerName(String messageOwnerName) {
        this.messageOwnerName = messageOwnerName;
    }
}
