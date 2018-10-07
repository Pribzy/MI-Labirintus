package test.java;

import main.java.hu.bme.mit.pribelszki.model.Adventurer;
import main.java.hu.bme.mit.pribelszki.model.Field;
import main.java.hu.bme.mit.pribelszki.model.Treasure;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TreasureTest {

    private Adventurer adventurer;
    private Treasure treasure;


    @Before
    public void initFields(){
        treasure= new Treasure();
        adventurer =Adventurer.getInstance();

    }

    @Test
    public void calculateDistance_FromAdventurer(){
        Field fieldAdventurer = new Field(0,0);
        Field fieldTreasure = new Field(0,2);
        fieldAdventurer.addAdventurer(adventurer);
        fieldTreasure.addTreasure(treasure);

        treasure.calculateDistanceFromAdventurer();

        /*distance = AdventurerField X_coord + TreasureField X_coord +
                     AdventurerField Y_coord + TreasureField Y_coord */

        assertEquals(2,treasure.getDistance());
    }
}
