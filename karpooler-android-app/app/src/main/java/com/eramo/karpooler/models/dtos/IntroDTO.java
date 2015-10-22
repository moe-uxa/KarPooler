package com.eramo.karpooler.models.dtos;

/**
 * Created by Mohamed.Gaber on 10/22/2015.
 */
public class IntroDTO {

    private int orderNumber;
    private String title;
    private String description;
    private int imageResource;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
