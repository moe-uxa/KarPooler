package com.eramo.karpooler.models.dtos;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by Mohamed.Gaber on 10/30/2015.
 */

public class TripCreationFeedDTO extends FeedDTO {

    private int tripId;
    private List<Bitmap> tripPassengers;

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public List<Bitmap> getTripPassengers() {
        return tripPassengers;
    }

    public void setTripPassengers(List<Bitmap> tripPassengers) {
        this.tripPassengers = tripPassengers;
    }
}
