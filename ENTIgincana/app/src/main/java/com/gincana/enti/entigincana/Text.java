package com.gincana.enti.entigincana;

public class Text extends Hint{
    private String textInfo;

    public Text(){};
    public Text(int id, String descript, double lat, double lon, int nextH, String tInfo){
        super(id, descript, lat, lon, nextH);
        textInfo = tInfo;
    };

    @Override
    public void printInfo() {
        System.out.println("ID: " + getIdentificator());
        System.out.println("Description: " + getDescription());
        System.out.println("Latitude: " + getP().getLatitude() + " Longitude: " + getP().getLongitude());
        System.out.println("Text Hint info: " + getTextInfo());
    }

    public int type(){
        return R.mipmap.hint_text;
    }

    public String getTextInfo() {
        return textInfo;
    }

    public void setTextInfo(String textInfo) {
        this.textInfo = textInfo;
    }
}
