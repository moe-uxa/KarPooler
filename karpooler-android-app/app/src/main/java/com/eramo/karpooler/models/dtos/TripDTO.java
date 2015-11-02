package com.eramo.karpooler.models.dtos;

import android.graphics.Bitmap;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Mohamed.Gaber on 11/1/2015.
 */
public class TripDTO implements Comparable{

    private int tripId;
    private String tripName;
    private String tripDate;
    private String tripFromTo;
    private List<Bitmap> passengers;
    private int tripState;

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getTripDate() {
        return tripDate;
    }

    public void setTripDate(String tripDate) {
        this.tripDate = tripDate;
    }

    public String getTripFromTo() {
        return tripFromTo;
    }

    public void setTripFromTo(String tripFromTo) {
        this.tripFromTo = tripFromTo;
    }

    public List<Bitmap> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Bitmap> passengers) {
        this.passengers = passengers;
    }

    public int getTripState() {
        return tripState;
    }

    public void setTripState(int tripState) {
        this.tripState = tripState;
    }


    @Override
    public int compareTo(Object another) {

        TripDTO otherTripDTO = (TripDTO) another;

        if (tripState < otherTripDTO.tripState)
            return -1;
        else if (tripState > otherTripDTO.tripState)
            return 1;
        else
            return 0;

    }
}
