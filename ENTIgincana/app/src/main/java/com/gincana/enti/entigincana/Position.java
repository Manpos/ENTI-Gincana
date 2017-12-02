package com.gincana.enti.entigincana;

public class Position {
    private double latitude;
    private double longitude;

    public Position(){
        latitude = 0;
        longitude = 0;
    };

    public Position(double lat, double lon){
        setLatitude(lat);
        setLongitude(lon);
    };

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        if(latitude < 0){
            throw new RuntimeException("No negative values allowed");
        }
        else this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        if(longitude < 0){
            throw new RuntimeException("No negative values allowed");
        }
        else this.longitude = longitude;
    }
}
