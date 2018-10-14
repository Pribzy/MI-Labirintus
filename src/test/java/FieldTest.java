package test.java;

import main.java.hu.bme.mit.pribelszki.model.Adventurer;
import main.java.hu.bme.mit.pribelszki.model.Direction;
import main.java.hu.bme.mit.pribelszki.model.Field;
import main.java.hu.bme.mit.pribelszki.model.Route;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

public class FieldTest {
    Field field;
    Field nextField;
    Adventurer adventurer;

    @Before
    public void init(){
        field = new Field(0,0);
        nextField = new Field(0,1);
        adventurer = Adventurer.getInstance();
    }



    @Test
    public void AdventurerStepOn_EmptyField_Succes(){
        nextField.stepOn(adventurer);

        assertNotNull(nextField.getAdventurer());
    }

    @Test
    public void SetNeighbor_Down_Succes(){
        field.setNextField(nextField, Direction.DOWN);

        assertEquals(nextField,field.getNeighbors().get(Direction.DOWN));
    }

    @Test
    public void calculateHeuristic_FromNeighbor_Success(){
        field.addAdventurer(adventurer);
        field.setNextField(nextField, Direction.DOWN);
        assertEquals(1,field.calculateHeuristics(Direction.DOWN));
    }

    @Test
    public void calculateHeuristic_FromNotNeighbor_Fail(){
        field.addAdventurer(adventurer);
        assertEquals(-1,field.calculateHeuristics(Direction.DOWN));
    }





}