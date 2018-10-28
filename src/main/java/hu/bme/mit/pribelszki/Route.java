package main.java.hu.bme.mit.pribelszki;

import java.util.ArrayList;
import java.util.List;

public class Route {

    //Fields
    private List<Field> fields;

    //Init
    public Route(){
        fields = new ArrayList<Field>();
    }
    //Functions
    public void addFieldToRoute(Field f){
        fields.add(f);

    }

    public void removeFieldFromRoute(Field f){
        fields.remove(f);
    }

    public List<Field> getFields() {
        return fields;
    }


}
