import helper.Pair;
import model.Charger;
import model.Truck;

import java.util.*;

public class CustomSchedule1 implements Schedule{
    @Override
    public void schedule(List<Truck> trucks, List<Charger> chargers, int time) {

        // Initialize result mapping each charger to a list of assigned trucks
        Map<String, List<String>> result = new HashMap<>();
        for(Charger charger : chargers) {
            result.put(charger.getId(), new ArrayList<>());
        }

        // Max-Heap for trucks based on charge required (Descending Order)
        PriorityQueue<Truck> truckMaxHeap = new PriorityQueue<>((a, b) ->
                Integer.compare(b.getChargeRemaining(), a.getChargeRemaining()));
        truckMaxHeap.addAll(trucks);

        // Min-Heap for chargers based on next available time, and if equal, charge rate (Descending Order)
        PriorityQueue<Pair> chargerMaxHeap = new PriorityQueue<>(
                (a, b) -> a.getNextAvailableTime() != b.getNextAvailableTime() ?
                        Integer.compare(a.getNextAvailableTime(), b.getNextAvailableTime())
                        : Integer.compare(b.getCharger().getChargeRate(), a.getCharger().getChargeRate())
        );
        chargerMaxHeap.addAll(chargers.stream().map(x -> new Pair(0, x)).toList());

        while (!truckMaxHeap.isEmpty()) {
            Truck truck = truckMaxHeap.poll();
            Pair chargerPair = chargerMaxHeap.poll();

            if(chargerPair.getNextAvailableTime() >= time ) {
                break; // top if no charger is available within the given time
            }

            // Calculate charge completion time
            int remainingCharge = truck.getChargeRemaining();
            int chargeRate = chargerPair.getCharger().getChargeRate();
            int availableTime = time - chargerPair.getNextAvailableTime();

            // only charge the truck if it can be charged in the remaining time
            if (remainingCharge <= chargeRate * availableTime) {
                result.get(chargerPair.getCharger().getId()).add(truck.getId());
                int chargeCompletionTime = (int) Math.ceil((double) remainingCharge / chargeRate);
                chargerPair.setNextAvailableTime(chargerPair.getNextAvailableTime() + chargeCompletionTime);
            }

            // add charger again in the heap with the updated availability time
            chargerMaxHeap.add(chargerPair);
        }

        System.out.println(result);
    }
}
