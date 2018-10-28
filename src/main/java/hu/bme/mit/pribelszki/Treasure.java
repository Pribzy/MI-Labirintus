package main.java.hu.bme.mit.pribelszki;

public class Treasure {
    //Fields
    private Field field;
    private int distance=0;
    //Init

    //Functions


    public int getDistance() {
        return distance;
    }


    public void setField(Field f){
        this.field=f;
    }

    public Field getField() {
        return field;
    }

    public void calculateDistanceFromAdventurer(){
        Adventurer a = Adventurer.getInstance();
        distance = ((field.getCoordX())-(a.getField().getCoordX()))+
                ((field.getCoordY())-(a.getField().getCoordY()));

    }


}
