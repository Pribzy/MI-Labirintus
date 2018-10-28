package main.java.hu.bme.mit.pribelszki;

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
    public Field(int id) {
        route.addFieldToRoute(this);
        this.Id=id;

    }
    public Field() {
        route.addFieldToRoute(this);

    }
    public Field(Maze m) {
        route.addFieldToRoute(this);
        this.maze=m;
    }
    public Field(int x,int y) {
        route.addFieldToRoute(this);
        this.coordX=x;
        this.coordY=y;
    }

    public Field(int x,int y,Maze m) {
        route.addFieldToRoute(this);
        this.coordX=x;
        this.coordY=y;
        this.maze =m;
    }

    //Functions

    public Adventurer getAdventurer() {
        return adventurer;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public void setNextField(Field f, Direction d){
        this.neighbors.put(d,f);
    }


    public void addTreasure(Treasure t){
        maze.addTreasure(t);
        this.treasure=t;
        t.setField(this);

    }

    public void removeTreasure(){
        maze.removeTreasure(treasure);
        this.treasure=null;

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
        this.adventurer.setField(null);
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


    public void doShortestRoute(){
        this.wasHere=true;
        if(this.adventurer!=null){
            route.removeFieldFromRoute(this);

            Adventurer.getInstance().doSteps();
        }
        else {


            recursiveSearch(Direction.RIGHT);
            recursiveSearch(Direction.UP);
            recursiveSearch(Direction.LEFT);
            recursiveSearch(Direction.DOWN);




        }
   }
   public void recursiveSearch(Direction d){
        if(this.neighbors.get(d)!=null) {
            if (!this.neighbors.get(d).wasHere) {


                for (int i = 0; i < route.getFields().size(); i++) {
                    this.neighbors.get(d).getRoute().addFieldToRoute(this.route.getFields().get(i));

                }
                    this.neighbors.get(d).doShortestRoute();

            }
        }
   }
}
