package com.example.internalproject;

public class LocationSaver {
    private double Longitude;
    private double Latitude;

    public LocationSaver(double longitude, double latitude) {
        Longitude = longitude;
        Latitude = latitude;
    }

    public double getLongitude() { return Longitude; }

    public double getLatitude() {
        return Latitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }
}
