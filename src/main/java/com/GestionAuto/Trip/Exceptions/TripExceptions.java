package com.GestionAuto.Trip.Exceptions;

public class TripExceptions extends Exception {
    public TripExceptions(String message) {

        super(message);
    }
    public void TimeException() {
        System.err.println("Une exception s'est produite : " + this.getMessage());
        this.printStackTrace();

    }


}
