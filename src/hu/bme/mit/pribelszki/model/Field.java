package hu.bme.mit.pribelszki.model;

import java.util.HashMap;
import java.util.Map;

public class Field {

    //Fields
    private Map<Direction,Field> neighbors = new HashMap<>();
    private Adventurer adventurer;
    private Treasure treasure;
    private Route route;

    private Boolean wasHere =false;
    private int Id;
    private int distance=0;

    private int coordX;
    private int coordY;

    //Init
    public Field() {
    }

    //Functions
    public Field getNextField(Direction d){
        Field nextField = neighbors.get(d);
        return nextField;
    }

    public void setNextField(Field f,Direction d){
        this.neighbors.put(d,f);
    }


    public void addTreasure(Treasure t){
        this.treasure=t;
    }

    public void addRoute(Route r){
        this.route = r;
    }

    public void setWasHere(Boolean b){
        this.wasHere=b;
    }
    public void setId(int id){
        this.Id=id;
    }

    public void setAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public void stepOn(Adventurer a){
        this.adventurer = a;
        setWasHere(true);
        System.out.println(this.coordX+" "+this.coordY);
    }
}
