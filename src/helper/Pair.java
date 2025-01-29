package helper;

import model.Charger;

public class Pair{
    private int nextAvailableTime;
    private final Charger charger;

    public Pair(int nextAvailableTime, Charger charger) {
        this.nextAvailableTime = nextAvailableTime;
        this.charger = charger;
    }

    public int getNextAvailableTime() {
        return nextAvailableTime;
    }

    public void setNextAvailableTime(int nextAvailableTime) {
        this.nextAvailableTime = nextAvailableTime;
    }

    public Charger getCharger() {
        return charger;
    }
}