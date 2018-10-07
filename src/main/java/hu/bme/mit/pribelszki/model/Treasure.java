package main.java.hu.bme.mit.pribelszki.model;

public class Treasure {
    //Fields
    private Field field;
    private int distance=0;
    //Init

    //Functions


    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setField(Field f){
        this.field=f;
    }

    public Field getField() {
        return field;
    }


}
