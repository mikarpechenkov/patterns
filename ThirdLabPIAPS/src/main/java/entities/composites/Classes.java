package entities.composites;

import entities.Unit;
import entities.primitives.Passenger;

import java.util.LinkedList;
import java.util.List;

public abstract class Classes implements Unit {
    protected List<Unit> passengers = new LinkedList<>();
    protected int maxCountOfPassengers;
    protected int maxBaggageWeight;

    @Override
    public int getWeight() {
        return passengers.stream().
                mapToInt(Unit::getWeight)
                .sum();
    }

    @Override
    public void addPassenger(Passenger passenger) {
        if (passengers.size() < maxCountOfPassengers)
            passengers.add(passenger);
        else
            System.out.println("Превышен лимит пассажиров в данном классе");
    }

    public List<Unit> getPassengers(){
        return passengers;
    }
}
