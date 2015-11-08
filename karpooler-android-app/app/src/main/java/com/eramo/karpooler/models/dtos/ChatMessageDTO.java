package com.eramo.karpooler.models.dtos;

import android.graphics.Bitmap;

/**
 * Created by Mohamed.Gaber on 11/8/2015.
 */
public class ChatMessageDTO {

    private Bitmap messageOwnerImage;
    private String message;
    private String messageTime;

    public Bitmap getMessageOwnerImage() {
        return messageOwnerImage;
    }

    public void setMessageOwnerImage(Bitmap messageOwnerImage) {
        this.messageOwnerImage = messageOwnerImage;
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
}
