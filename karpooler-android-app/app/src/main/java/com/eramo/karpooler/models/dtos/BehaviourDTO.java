package com.eramo.karpooler.models.dtos;

import android.graphics.Bitmap;

/**
 * Created by Mohamed.Gaber on 11/10/2015.
 */
public class BehaviourDTO {

    private Bitmap icon;
    private String text;

    public BehaviourDTO(Bitmap icon, String text) {
        this.icon = icon;
        this.text = text;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
