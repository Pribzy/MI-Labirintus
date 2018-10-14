package test.java;

import main.java.hu.bme.mit.pribelszki.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;

public class MazeTest {
    private Maze maze;

    @Before public void initMaze(){
        //Init a testlevel
        maze = new Maze("level");
    }

    @After public void refreshMaze(){
        maze = new Maze("level");
    }

    @Test public void addField_ToEmptyMaze_Succes(){
        Field f = new Field();
        maze.addField(f);
        assertEquals(1,maze.getFields().size());
    }


    @Test public void addTreasure_ToEmptyMaze_TreasureNumberGrow(){
        Treasure t = new Treasure();
        maze.addTreasure(t);

        assertEquals(1,maze.getTreasureNumber());
    }

    @Test public void getClosestTreasureDistance(){

         /*
         X=Wall
         A=Adventurer
         T1=Treasure(distance = 2)
         T2=Treasure(distance = 1)
         XXXXXXXX
         XA   T1X
         XT2    X
         XXXXXXXX
         */

        Treasure T1 = new Treasure();
        Treasure T2 = new Treasure();
        Adventurer A = Adventurer.getInstance();

        Field fieldA = new Field(0,0); fieldA.addAdventurer(A);
        Field fieldT1 = new Field(0,2);
        fieldT1.setMaze(maze);
        fieldT1.addTreasure(T1);
        Field fieldT2 = new Field(0,1);
        fieldT2.setMaze(maze);
        fieldT2.addTreasure(T2);


        assertEquals(T2,maze.getClosestTreasure());
    }

    @Test public void getExitField(){
        //Exitfield = bottom-left field

        Field f1 = new Field();
        Field f2 = new Field();
        maze.addField(f1);
        maze.addField(f2);

        assertEquals(f2,maze.getExitField());
    }

    @Test public void clearAllFields_EveryFieldHasEmptyRoads_Succes(){
        Field f1 = new Field();
        maze.addField(f1);
        maze.clearFields();

        assertEquals(1,f1.getRoute().getFields().size());

    }

    @Test public void clearAllFields_EveryFieldIsFree_WasHereValueIsNull(){
        Field f1 = new Field();
        maze.addField(f1);
        maze.clearFields();

        assertFalse(f1.getWasHere());
    }

    @Test
    public void removeTreasure_WhenTreasureRemovedFromField(){
        Field f1 = new Field(maze);
        f1.addTreasure(new Treasure());
        f1.removeTreasure();

        assertEquals(0,maze.getTreasures().size());
    }

    @Test
    public void getAllTreasures_ReachEndOfTheLabirinth(){

          /*
         X=Wall
         A=Adventurer
         T1=Treasure
         T2=Treasure
         XXXXXX
         XA|T1X
         XT2  X
         XXXXXX
         */

        Treasure T1 = new Treasure();
        Treasure T2 = new Treasure();
        Adventurer A = Adventurer.getInstance();

        Field fieldA = new Field(0,0,maze); fieldA.addAdventurer(A); maze.addField(fieldA);
        Field fieldT1 = new Field(1,0,maze); fieldT1.addTreasure(T1); maze.addField(fieldT1);
        Field fieldT2 = new Field(0,1,maze); fieldT2.addTreasure(T2); maze.addField(fieldT2);
        Field fieldEnd = new Field(1,1,maze);                           maze.addField(fieldEnd);
        fieldA.setNextField(fieldT2,Direction.DOWN);
        fieldT1.setNextField(fieldEnd,Direction.DOWN);
        fieldT2.setNextField(fieldEnd,Direction.RIGHT); fieldT2.setNextField(fieldA,Direction.UP);
        fieldEnd.setNextField(fieldT1,Direction.UP); fieldEnd.setNextField(fieldT2,Direction.LEFT);

        maze.run();

        assertEquals(0,maze.getTreasures().size()); //All treasures have been collected
        assertEquals(fieldEnd,A.getField()); //The ending field is the right-bottom field
    }






}
