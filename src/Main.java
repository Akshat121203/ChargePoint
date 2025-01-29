import model.Charger;
import model.Truck;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Truck> trucks = new ArrayList<>();
        trucks.add(new Truck("t1", 100, 40));
        trucks.add(new Truck("t2", 80, 10));
        trucks.add(new Truck("t3", 50, 20));

        List<Charger> chargers = new ArrayList<>();
        chargers.add(new Charger("c1", 30));
        chargers.add(new Charger("c2", 20));


        int time = 2; // number of hours to charge the trucks


        Schedule schedule = new CustomSchedule1();
        schedule.schedule(trucks, chargers, time);

    }
}

