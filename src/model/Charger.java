package model;

public class Charger {

    private final String id;
    private final int chargeRate;


    public Charger(String id, int chargeRate) {
        this.id = id;
        this.chargeRate = chargeRate;
    }

    public String getId() {
        return id;
    }

    public int getChargeRate() {
        return chargeRate;
    }
}
