package hu.bme.mit.pribelszki.model;

import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {

    private Maze maze;

    //Init
    public InputHandler(Maze m){
        this.maze=m;
    }

    public String getLevelFromString(){
        Scanner reader =new Scanner(System.in);

        String level = reader.nextLine();
        reader.close();

        return level;


    }

    public String[] splitStringByLines(){

        String[] lines = getLevelFromString().split("\\\\n");

        ArrayList<Field> fields = new ArrayList<>();

        int k=1;

        for (int i = 0; i <lines.length-1; i++) {
            String[] lineElements = lines[i].split(" ");
            for (int j = 0; j <lineElements.length ; j++) {
                int fieldNumber = Integer.parseInt(lineElements[j]);
                Field f = new Field(fieldNumber,maze);
                f.setCoordY(j);
                f.setCoordX(i);
                fields.add(f);
            }
        }


        for (int i = 0; i <lines.length-1; i++) {
            String[] lineElements = lines[i].split(" ");
            for (int j = 0; j <lineElements.length ; j++) {
                Field f = fields.get((i+j)*k);
                switch (f.getId()){
                    case 1: f.setNextField(fields.get((i*j)-i),Direction.UP);
                    default:
                }

            }
        }


        return lines;
    }



    public int getTreasureNumber(){
        int treasureNumber=0;

        String[] lines = splitStringByLines();

        treasureNumber = Integer.parseInt(lines[lines.length-1]);

        return treasureNumber;
    }

    public void makeFields(){
        ArrayList<Field> fields = new ArrayList<>();


       /* for (int i = 0; i <lines.length-1; i++) {
            String[] lineElements = lines[i].split(" ");
            for (int j = 0; j <lineElements.length ; j++) {
                int fieldNumber = Integer.parseInt(lineElements[j]);
                Field f= new Field(i+j,new Maze());
                f.setCoordX(i); f.setCoordY(j);
                if(fieldNumber>16){
                    f.addTreasure(new Treasure());
                }
                fields.add(f);
            }
        }
        System.out.println(fields.size());*/


    }








}
