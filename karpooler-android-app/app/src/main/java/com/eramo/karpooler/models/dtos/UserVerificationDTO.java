package com.eramo.karpooler.models.dtos;

/**
 * Created by Mohamed.Gaber on 11/14/2015.
 */
public class UserVerificationDTO {

    private int verificationId;
    private String verificationValue;

    public UserVerificationDTO(int verificationId, String verificationValue) {
        this.verificationId = verificationId;
        this.verificationValue = verificationValue;
    }

    public int getVerificationId() {
        return verificationId;
    }

    public void setVerificationId(int verificationId) {
        this.verificationId = verificationId;
    }

    public String getVerificationValue() {
        return verificationValue;
    }

    public void setVerificationValue(String verificationValue) {
        this.verificationValue = verificationValue;
    }
}
