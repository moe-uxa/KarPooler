package com.eramo.karpooler.models.dtos;

/**
 * Created by Mohamed.Gaber on 11/8/2015.
 */
public class SentChatMessageDTO extends ChatMessageDTO {

    private String messageState;

    public String getMessageState() {
        return messageState;
    }

    public void setMessageState(String messageState) {
        this.messageState = messageState;
    }
}
