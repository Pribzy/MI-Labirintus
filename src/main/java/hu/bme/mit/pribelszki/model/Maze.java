package hu.bme.mit.pribelszki.model;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    //Fields
    private List<Field> fields = new ArrayList<Field>();
    private List<Treasure> treasures = new ArrayList<Treasure>();
    private int treasureNumber;

    //Init
    public Maze(){

       /* InputHandler input = new InputHandler(this);
        treasureNumber = input.getTreasureNumber();
        input.makeFields();*/


        Field f1 = new Field(1,this); f1.setCoordX(0); f1.setCoordY(0);
        Field f2 = new Field(2,this); f2.setCoordX(0); f2.setCoordY(1);
        Field f3 = new Field(3,this); f3.setCoordX(0); f3.setCoordY(2);
        Field f4 = new Field(4,this); f4.setCoordX(1); f4.setCoordY(0);
        Field f5 = new Field(5,this); f5.setCoordX(1); f5.setCoordY(1);
        Field f6 = new Field(6,this); f6.setCoordX(1); f6.setCoordY(2);
        Field f7 = new Field(7,this); f7.setCoordX(2); f7.setCoordY(0);
        Field f8 = new Field(8,this); f8.setCoordX(2); f8.setCoordY(1);
        Field f9 = new Field(9,this); f9.setCoordX(2); f9.setCoordY(2);

        f1.setNextField(f2,Direction.RIGHT); f1.setNextField(f4,Direction.DOWN);
        f2.setNextField(f1,Direction.LEFT); f2.setNextField(f5,Direction.DOWN);
        f3.setNextField(f6,Direction.DOWN);

        f4.setNextField(f1,Direction.UP); f4.setNextField(f5,Direction.RIGHT);f4.setNextField(f7,Direction.DOWN);
        f5.setNextField(f4,Direction.LEFT); f5.setNextField(f2,Direction.UP);
        f6.setNextField(f3,Direction.UP); f6.setNextField(f9,Direction.DOWN);

        f7.setNextField(f4,Direction.UP); f7.setNextField(f8,Direction.RIGHT);
        f8.setNextField(f9,Direction.RIGHT); f8.setNextField(f7,Direction.LEFT);
        f9.setNextField(f6,Direction.UP); f9.setNextField(f8,Direction.LEFT);

        f1.addAdventurer(Adventurer.getInstance());

        Treasure t1 = new Treasure();
        this.treasures.add(t1);
        f3.addTreasure(t1);

        Treasure t2 = new Treasure();
        this.treasures.add(t2);
        f5.addTreasure(t2);





        fields.add(f1);
        fields.add(f2);
        fields.add(f3);
        fields.add(f4);
        fields.add(f5);
        fields.add(f6);
        fields.add(f7);
        fields.add(f8);
        fields.add(f9);

        treasureNumber = treasures.size();
    }

    //Functions---------------------------


    public List<Treasure> getTreasures() {
        return treasures;
    }

    public void run(){

        for (int i = 0; i <treasureNumber ; i++) {
            getClosestTreasure().getField().searchClosestRoute();
            clearFields();
        }

        getExitField().searchClosestRoute();

        }

        private void clearFields(){
            for (Field field : fields) {
                Route newRoute = new Route();
                newRoute.addFieldToRoute(field);
                field.setRoute(newRoute);
                field.setWasHere(false);
                field.setHeuristicValue(0);
            }
        }

    private Treasure getClosestTreasure(){
        Treasure closestTreasure = new Treasure();



        for (Treasure t:treasures) {
            int distance = ((t.getField().getCoordX())-(Adventurer.getInstance().getField().getCoordX()))+
                    ((t.getField().getCoordY())-(Adventurer.getInstance().getField().getCoordY()));
            t.setDistance(distance);
        }

        int min = 0;
        if(treasures.size()!=1) {

            for (int i = 0; i < treasures.size(); i++) {

                if (treasures.get(min).getDistance() > treasures.get(i).getDistance()) {
                    min = i;
                }
            }


        }
        closestTreasure = treasures.get(min);


        return closestTreasure;

    }


    private Field getExitField(){
        return fields.get(fields.size()-1);
    }






}
