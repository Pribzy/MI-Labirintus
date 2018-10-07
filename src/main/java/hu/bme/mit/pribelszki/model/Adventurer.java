package hu.bme.mit.pribelszki.model;

import java.util.ArrayList;
import java.util.List;

public class Adventurer {
    //Fields
    private Field field;

    //Init
    private static Adventurer ourInstance = new Adventurer();
    public static Adventurer getInstance() {
        return ourInstance;
    }
    private Adventurer() {
    }

    //Functions
    public void setField(Field f){
        this.field=f;
    }

    public Field getField() {
        return field;
    }

    public void doSteps(){
        List<Field> routeFields = new ArrayList<Field>();
        routeFields = field.getRoute().getFields();


        for (Field f: routeFields) {
            field.removeAdventurer();
            f.stepOn(this);

        }
        if(field.getTreasure()!=null) {
            System.out.println("felvesz");
            field.removeTreasure();
        }



    }
}
