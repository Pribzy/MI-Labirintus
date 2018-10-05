package main.java.hu.bme.mit.pribelszki.model;

public class Adventurer {
    private static Adventurer ourInstance = new Adventurer();

    public static Adventurer getInstance() {
        return ourInstance;
    }

    private Adventurer() {
    }


}
