package main.java.hu.bme.mit.pribelszki.model;

import java.util.HashMap;
import java.util.Map;

public class Field {

    //Fields
    private Map<Direction,Field> neighbors = new HashMap<>();
    private Adventurer adventurer;
    private Treasure treasure;
    private Route route = new Route();
    private Maze maze;

    private Boolean wasHere =false;
    private int Id;

    private int coordX;
    private int coordY;
    private int heuristicValue=0;

    //Init
    public Field(int id,Maze m) {
        route.addFieldToRoute(this);
        this.Id=id;
        this.maze=m;
    }

    //Functions
    public Field getNextField(Direction d){
        Field nextField = neighbors.get(d);
        return nextField;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public void setNextField(Field f, Direction d){
        this.neighbors.put(d,f);
    }


    public void addTreasure(Treasure t){
        this.treasure=t;
        t.setField(this);

    }

    public void removeTreasure(){
        maze.getTreasures().remove(treasure);
        this.treasure=null;

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

    public int getId() {
        return Id;
    }

    public void addAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
        adventurer.setField(this);
    }
    public void removeAdventurer() {
        this.adventurer = null;

    }


    public void setHeuristicValue(int value) {
        this.heuristicValue = value;
    }

    public int getHeuristicValue() {
        return heuristicValue;
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

        addAdventurer(a);

        System.out.println(this.coordX+" "+this.coordY);

    }

    public Route getRoute() {
        return route;
    }

    public Map<Direction, Field> getNeighbors() {
        return neighbors;
    }

    public Boolean getWasHere() {
        return wasHere;
    }

    public Treasure getTreasure() {
        return treasure;
    }




    public int calculateHeuristics(Direction d){

        int heuristic=-1;
        if(neighbors.get(d)!=null){

            heuristic = Adventurer.getInstance().getField().coordX+
                    Adventurer.getInstance().getField().coordY+
                    neighbors.get(d).coordX+neighbors.get(d).coordY;
            neighbors.get(d).setHeuristicValue(heuristic);
        }

            return heuristic;

    }




    public void searchClosestRoute(){
        this.wasHere=true;
        if(this.adventurer!=null){
            route.removeFieldFromRoute(this);

            Adventurer.getInstance().doSteps();
        }
        else {

           // recursiveSearch(min.getKey());
            recursiveSearch(Direction.LEFT);
            recursiveSearch(Direction.DOWN);
            recursiveSearch(Direction.UP);
            recursiveSearch(Direction.RIGHT);




        }
   }
   public void recursiveSearch(Direction d){
        if(this.neighbors.get(d)!=null) {
            if (!this.neighbors.get(d).wasHere) {


                for (int i = 0; i < route.getFields().size(); i++) {
                    this.neighbors.get(d).getRoute().addFieldToRoute(this.route.getFields().get(i));

                }
                    this.neighbors.get(d).searchClosestRoute();

            }
        }
   }
}
