package main.java.hu.bme.mit.pribelszki.model;

import java.util.ArrayList;
import java.util.List;

public class Route {

    //Fields
    private List<Field> fields = new ArrayList<Field>();

    //Init
    public Route(){

    }
    //Functions
    public void addFieldToRoute(Field f){
        fields.add(f);
        int distance = f.getDistance();
        f.setDistance(distance++);
    }

}
