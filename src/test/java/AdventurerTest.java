package test.java;

import main.java.hu.bme.mit.pribelszki.model.*;
import org.junit.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

public class AdventurerTest {
    private Adventurer adventurer;
    private Field actualField,nextField;

    @Before
    public void initFields(){
        adventurer = Adventurer.getInstance();
        actualField = new  Field(0,0);
        nextField = new  Field(0,1);


    }
    @After
    public void clearTreasures(){
        adventurer.getTreasures().clear();
    }




    @Test
    public void moveAdventurer_ToNextField_NotNull(){
        actualField.addAdventurer(adventurer);

        adventurer.Step(nextField);
        assertNotNull(nextField.getAdventurer());

    }

    @Test
    public void removeAdventurer_FromActualField_FieldWithoutAdventurer(){
        nextField.stepOn(adventurer);
        assertNull(actualField.getAdventurer());

    }










}