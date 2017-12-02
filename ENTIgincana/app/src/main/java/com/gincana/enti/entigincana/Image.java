package com.gincana.enti.entigincana;

public class Image extends Hint{
    private String path;

    public Image(){};
    public Image(int id, String descript, double lat, double lon, int nextH, String pth){
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
        return R.mipmap.hint_image;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
