package com.gincana.enti.entigincana;

/**
 * Created by mique on 19/09/2017.
 */

public class Audio extends Hint {
    private String path;

    public Audio(){};
    public Audio(int id, String descript, double lat, double lon, int nextH, String pth){
        super(id, descript, lat, lon, nextH);
        path = pth;
    }

    public void printInfo() {
        System.out.println("ID: " + getIdentificator());
        System.out.println("Description: " + getDescription());
        System.out.println("Latitude: " + getP().getLatitude() + " Longitude: " + getP().getLongitude());
        System.out.println("Path: " + getPath());
    }

    public int type(){
        return R.mipmap.hint_sound;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
