package model;

public class Truck {

    private final String id;
    private final int capacity;
    private final int currentLevel;

    public Truck(String id, int capacity, int currentLevel) {
        this.id = id;
        this.capacity = capacity;
        this.currentLevel = currentLevel;
    }

    public String getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getChargeRemaining() {
        return capacity - currentLevel;
    }
}
