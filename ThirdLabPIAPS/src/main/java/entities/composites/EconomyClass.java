package entities.composites;

import entities.primitives.Passenger;
import lombok.ToString;

@ToString
public class EconomyClass extends Classes {
    public EconomyClass() {
        maxBaggageWeight = 20;
        maxCountOfPassengers = 150;
    }

    @Override
    public void addPassenger(Passenger passenger) {
        if (passenger.getWeight() <= maxBaggageWeight)
            super.addPassenger(passenger);
        else
            System.out.println("Превышен лимит багажа для пассажира эконом класса класса");
    }
}
