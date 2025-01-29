import model.Charger;
import model.Truck;

import java.util.List;

public interface Schedule {

    void schedule(List<Truck> truckList, List<Charger> chargerList, int time);
}
