package com.eramo.karpooler.models.dtos;

import android.graphics.Bitmap;
import android.view.View;

/**
 * Created by Mohamed.Gaber on 11/16/2015.
 */
public class InviteMethodDTO {

    private int inviteMethodId;
    private int iconResource;
    private String name;
    private View.OnClickListener onClickListener;

    public InviteMethodDTO(int inviteMethodId, int iconResource, String name, View.OnClickListener onClickListener) {
        this.inviteMethodId = inviteMethodId;
        this.iconResource = iconResource;
        this.name = name;
        this.onClickListener = onClickListener;
    }

    public int getInviteMethodId() {
        return inviteMethodId;
    }

    public void setInviteMethodId(int inviteMethodId) {
        this.inviteMethodId = inviteMethodId;
    }

    public int getIconResource() {
        return iconResource;
    }

    public void setIconResource(int iconResource) {
        this.iconResource = iconResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
