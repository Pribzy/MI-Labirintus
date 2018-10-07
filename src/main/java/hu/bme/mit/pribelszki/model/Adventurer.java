package main.java.hu.bme.mit.pribelszki.model;

import java.util.ArrayList;
import java.util.List;

public class Adventurer {
    //Fields
    private Field field;
    private List<Treasure> treasures = new ArrayList<Treasure>();

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
           Step(f);

        }

        if(field.getTreasure()!=null) {
            treasures.add(field.getTreasure());
            System.out.println("felvesz");

            field.removeTreasure();
        }

    }

    public void Step(Field f){
        field.removeAdventurer();
        f.stepOn(this);

    }

    public void addTreasure(Treasure t){
        treasures.add(t);
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(List<Treasure> treasures) {
        this.treasures = treasures;
    }
}
