package main.java.hu.bme.mit.pribelszki.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maze {
    //Fields
    private List<Field> fields = new ArrayList<Field>();
    private List<Treasure> treasures = new ArrayList<Treasure>();
    private int treasureNumber;
    private int width,height;

    //Init
    public Maze() throws IOException {

       makeFieldsFromString();



       makeFieldsFromRelationShip();



    }





    public void makeFieldsFromString() throws IOException {


        String[] lineElements=null;

        int h=0;


        List<String> lines = new ArrayList<String>();
        String lineNew;




        Scanner input = new Scanner(System.in);

        try {
            lineNew = input.nextLine();
            lines.add(lineNew);

            while (lineNew.length()>2) {
                lineNew = input.nextLine();
               // System.out.println(lineNew);
                /*if (lineNew.length()==1) {
                    break;
                }*/

                if(lineNew.length()>2) {
                    lines.add(lineNew);
                }
            }

        }catch (Exception e){

        }

        input.close();



        for (int i = 0; i <lines.size() ; i++) {


            lineElements = lines.get(i).split(" ");

            for (int j = 0; j < lineElements.length; j++) {
                int fieldNumber = Integer.parseInt(lineElements[j]);
                Field f = new Field(fieldNumber, this);
                f.setCoordY(j);
                f.setCoordX(i);
                fields.add(f);
            }
            h++;
            this.width=lineElements.length;
        }


        this.height=h;




    }

    public void makeFieldsFromRelationShip(){
        for (int i = 0; i <fields.size() ; i++) {

            Field actualField = fields.get(i);
            if(16<=actualField.getId()){
                actualField.addTreasure(new Treasure());
                int newId=actualField.getId()-16;
                actualField.setId(newId);
            }

            int rightIndex=i+1;
            int leftIndex=i-1;
            int upIndex=i-width;
            int downIndex=i+width;

            if(actualField==getStartField()){
                upIndex=0;
            }
            if(actualField==getExitField()){
                downIndex=0;
            }

            switch (actualField.getId()) {
                //1-es falak
                case 1:
                    actualField.setNextField(fields.get(rightIndex),Direction.RIGHT);
                    actualField.setNextField(fields.get(leftIndex),Direction.LEFT);
                    if(actualField!=getStartField()){
                        //actualField.setNextField(fields.get(upIndex),Direction.UP);
                    }
                    if(actualField!=getExitField()){
                        actualField.setNextField(fields.get(downIndex),Direction.DOWN);
                    }

                    break;
                case 2:
                    //actualField.setNextField(fields.get(rightIndex),Direction.RIGHT);
                    actualField.setNextField(fields.get(leftIndex),Direction.LEFT);
                    if(actualField!=getStartField()){
                        actualField.setNextField(fields.get(upIndex),Direction.UP);
                    }
                    if(actualField!=getExitField()){
                        actualField.setNextField(fields.get(downIndex),Direction.DOWN);
                    }
                    break;
                case 4:
                    actualField.setNextField(fields.get(rightIndex),Direction.RIGHT);
                    actualField.setNextField(fields.get(leftIndex),Direction.LEFT);
                    if(actualField!=getStartField()){
                        actualField.setNextField(fields.get(upIndex),Direction.UP);
                    }
                    if(actualField!=getExitField()){
                        //actualField.setNextField(fields.get(downIndex),Direction.DOWN);
                    }
                    break;
                case 8:
                    actualField.setNextField(fields.get(rightIndex),Direction.RIGHT);
                    //actualField.setNextField(fields.get(leftIndex),Direction.LEFT);
                    if(actualField!=getStartField()){
                        actualField.setNextField(fields.get(upIndex),Direction.UP);
                    }
                    if(actualField!=getExitField()){
                        actualField.setNextField(fields.get(downIndex),Direction.DOWN);
                    }
                    break;
                    //2-es falak
                case (1+2):
                    //actualField.setNextField(fields.get(rightIndex),Direction.RIGHT);
                    actualField.setNextField(fields.get(leftIndex),Direction.LEFT);
                    if(actualField!=getStartField()){
                        //actualField.setNextField(fields.get(upIndex),Direction.UP);
                    }
                    if(actualField!=getExitField()){
                        actualField.setNextField(fields.get(downIndex),Direction.DOWN);
                    }
                    break;
                case (1+4):
                    actualField.setNextField(fields.get(rightIndex),Direction.RIGHT);
                    actualField.setNextField(fields.get(leftIndex),Direction.LEFT);
                    if(actualField!=getStartField()){
                        //actualField.setNextField(fields.get(upIndex),Direction.UP);
                    }
                    if(actualField!=getExitField()){
                        //actualField.setNextField(fields.get(downIndex),Direction.DOWN);
                    }
                    break;
                case (1+8):
                    actualField.setNextField(fields.get(rightIndex),Direction.RIGHT);
                    //actualField.setNextField(fields.get(leftIndex),Direction.LEFT);
                    if(actualField!=getStartField()){
                        //actualField.setNextField(fields.get(upIndex),Direction.UP);
                    }
                    if(actualField!=getExitField()){
                        actualField.setNextField(fields.get(downIndex),Direction.DOWN);
                    }
                    break;
                case (2+4):
                    //actualField.setNextField(fields.get(rightIndex),Direction.RIGHT);
                    actualField.setNextField(fields.get(leftIndex),Direction.LEFT);
                    if(actualField!=getStartField()){
                        actualField.setNextField(fields.get(upIndex),Direction.UP);
                    }
                    if(actualField!=getExitField()){
                        //actualField.setNextField(fields.get(downIndex),Direction.DOWN);
                    }
                    break;
                case (2+8):
                    //actualField.setNextField(fields.get(rightIndex),Direction.RIGHT);
                    //actualField.setNextField(fields.get(leftIndex),Direction.LEFT);
                    if(actualField!=getStartField()){
                        actualField.setNextField(fields.get(upIndex),Direction.UP);
                    }
                    if(actualField!=getExitField()){
                        actualField.setNextField(fields.get(downIndex),Direction.DOWN);
                    }
                    break;
                case (4+8):
                    actualField.setNextField(fields.get(rightIndex),Direction.RIGHT);
                    //actualField.setNextField(fields.get(leftIndex),Direction.LEFT);
                    if(actualField!=getStartField()){
                        actualField.setNextField(fields.get(upIndex),Direction.UP);
                    }
                    if(actualField!=getExitField()){
                        //actualField.setNextField(fields.get(downIndex),Direction.DOWN);
                    }
                    break;
                    //3-as falak
                case (1+2+4):
                    //actualField.setNextField(fields.get(rightIndex),Direction.RIGHT);
                    actualField.setNextField(fields.get(leftIndex),Direction.LEFT);
                    if(actualField!=getStartField()){
                       // actualField.setNextField(fields.get(upIndex),Direction.UP);
                    }
                    if(actualField!=getExitField()){
                        //actualField.setNextField(fields.get(downIndex),Direction.DOWN);
                    }
                    break;
                case (1+2+8):
                    //actualField.setNextField(fields.get(rightIndex),Direction.RIGHT);
                    //actualField.setNextField(fields.get(leftIndex),Direction.LEFT);
                    if(actualField!=getStartField()){
                        //actualField.setNextField(fields.get(upIndex),Direction.UP);
                    }
                    if(actualField!=getExitField()){
                        actualField.setNextField(fields.get(downIndex),Direction.DOWN);
                    }
                    break;
                case (2+4+8):
                   // actualField.setNextField(fields.get(rightIndex),Direction.RIGHT);
                    //actualField.setNextField(fields.get(leftIndex),Direction.LEFT);
                    if(actualField!=getStartField()){
                        actualField.setNextField(fields.get(upIndex),Direction.UP);
                    }
                    if(actualField!=getExitField()){
                       // actualField.setNextField(fields.get(downIndex),Direction.DOWN);
                    }
                    break;
                case (1+4+8):
                    actualField.setNextField(fields.get(rightIndex),Direction.RIGHT);
                    //actualField.setNextField(fields.get(leftIndex),Direction.LEFT);
                    if(actualField!=getStartField()){
                        //actualField.setNextField(fields.get(upIndex),Direction.UP);
                    }
                    if(actualField!=getExitField()){
                        //actualField.setNextField(fields.get(downIndex),Direction.DOWN);
                    }
                    break;
                case (1+2+4+8):
                    //actualField.setNextField(fields.get(i+1),Direction.RIGHT);
                    //actualField.setNextField(fields.get(i-1),Direction.LEFT);
                    //actualField.setNextField(fields.get(i+width),Direction.DOWN);
                    //actualField.setNextField(fields.get(i-width),Direction.UP);
                    break;
                case 0:
                    actualField.setNextField(fields.get(rightIndex),Direction.RIGHT);
                    actualField.setNextField(fields.get(leftIndex),Direction.LEFT);
                    if(actualField!=getStartField()){
                        actualField.setNextField(fields.get(upIndex),Direction.UP);
                    }
                    if(actualField!=getExitField()){
                        actualField.setNextField(fields.get(downIndex),Direction.DOWN);
                    }
                    break;

            }


        }


        getStartField().addAdventurer(Adventurer.getInstance());
    }

    public Maze(String level){
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

        Treasure t0 = new Treasure();
        f3.addTreasure(t0);

        Treasure t1 = new Treasure();
        f9.addTreasure(t1);

        Treasure t2 = new Treasure();
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

    public void addField(Field f){
        this.fields.add(f);
    }

    public void addTreasure(Treasure t){
        this.treasures.add(t);
        treasureNumber++;
    }

    public void removeTreasure(Treasure t){
        this.treasures.remove(t);

    }

    public int getTreasureNumber() {
        return treasureNumber;
    }

    public List<Field> getFields() {
        return fields;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public void run() {

            for (int i = 0; i <treasureNumber ; i++) {
                getClosestTreasure().getField().doShortestRoute();
                clearFields();
            }


            getExitField().doShortestRoute();


       // System.out.println(getExitField().getCoordY()+" "+getExitField().getCoordX());


        //System.out.println();

    }

    public void clearFields(){

            for (Field field : fields) {
                Route newRoute = new Route();
                newRoute.addFieldToRoute(field);
                field.setRoute(newRoute);
                field.setWasHere(false);
                field.setHeuristicValue(0);
            }
    }








    public Treasure getClosestTreasure(){
        Treasure closestTreasure;

        for (Treasure t:treasures) {
            t.calculateDistanceFromAdventurer();
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

    public Field getExitField(){
        return fields.get(fields.size()-1);
    }
    public Field getStartField(){
        return fields.get(0);
    }





}
