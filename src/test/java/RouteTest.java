package test.java;

import main.java.hu.bme.mit.pribelszki.model.Field;
import main.java.hu.bme.mit.pribelszki.model.Route;
import org.junit.*;

import static junit.framework.TestCase.assertEquals;

public class RouteTest {

    Route route;

    @Before
    public void initFields(){
        route = new Route();
    }

    @Test
    public void addField_EmptyList_Succes(){
        Field f = new Field();
        route.addFieldToRoute(f);
        assertEquals(1,route.getFields().size());
    }

    @Test
    public void removeField_FilledList_Succes(){
        Field f = new Field();
        route.addFieldToRoute(f);
        route.removeFieldFromRoute(f);
        assertEquals(0,route.getFields().size());
    }


}
