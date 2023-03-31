package com.example.internalproject;

public class vehiclesDetailsSaver {
    String location;
    String model;
    String number;
    String problem;
    String vehicleType;

    public vehiclesDetailsSaver(String location, String model, String number, String problem, String vehicleType) {
        this.location = location;
        this.model = model;
        this.number = number;
        this.problem = problem;
        this.vehicleType = vehicleType;
    }

    public String getLocation() {
        return location;
    }

    public String getModel() {
        return model;
    }

    public String getNumber() {
        return number;
    }

    public String getProblem() {
        return problem;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}
