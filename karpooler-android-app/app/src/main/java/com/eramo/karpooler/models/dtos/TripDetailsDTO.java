package com.eramo.karpooler.models.dtos;

import android.graphics.Bitmap;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by Mohamed.Gaber on 11/7/2015.
 */
public class TripDetailsDTO {

    private int tripId;
    private String tripName;
    private LatLng startPoint;
    private LatLng endPoint;
    private String from;
    private String to;
    private String tripDate;
    private int numberOfSeatsAvailable;
    List<Bitmap> passengers;
    List<DriverDTO> drivers;

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

    public LatLng getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(LatLng startPoint) {
        this.startPoint = startPoint;
    }

    public LatLng getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(LatLng endPoint) {
        this.endPoint = endPoint;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTripDate() {
        return tripDate;
    }

    public void setTripDate(String tripDate) {
        this.tripDate = tripDate;
    }

    public int getNumberOfSeatsAvailable() {
        return numberOfSeatsAvailable;
    }

    public void setNumberOfSeatsAvailable(int numberOfSeatsAvailable) {
        this.numberOfSeatsAvailable = numberOfSeatsAvailable;
    }

    public List<Bitmap> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Bitmap> passengers) {
        this.passengers = passengers;
    }

    public List<DriverDTO> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<DriverDTO> drivers) {
        this.drivers = drivers;
    }
}
