package com.gincana.enti.entigincana;

public abstract class Hint {
    private Position p;
    private int identificator;
    private String description;
    private int nextHint;

    public Hint(){
        p = new Position();
        identificator = -1;
        description = "";
        nextHint = -1;
    }

    public Hint(int id, String descript, double lat, double lon, int nextH){
        p = new Position(lat, lon);
        identificator = id;
        description = descript;
        nextHint = nextH;
    }

    public abstract void printInfo();

    public abstract int type();

    public int getIdentificator() {
        return identificator;
    }

    public void setIdentificator(int identificator) {
        this.identificator = identificator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Position getP() {
        return p;
    }

    public void setP(Position p) {
        this.p = p;
    }

    public int getNextHint() {
        return nextHint;
    }

    public void setNextHint(int nextHint) {
        this.nextHint = nextHint;
    }
}
