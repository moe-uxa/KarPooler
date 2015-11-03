package com.eramo.karpooler.models.dtos;

import android.view.View;

/**
 * Created by Mohamed.Gaber on 11/4/2015.
 */
public class MenuItemDTO {

    private int iconResource;
    private String text;
    private View.OnClickListener onClickListener;

    public MenuItemDTO(int iconResource, String text, View.OnClickListener onClickListener) {
        this.iconResource = iconResource;
        this.text = text;
        this.onClickListener = onClickListener;
    }

    public int getIconResource() {
        return iconResource;
    }

    public void setIconResource(int iconResource) {
        this.iconResource = iconResource;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
