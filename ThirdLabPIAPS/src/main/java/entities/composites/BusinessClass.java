package entities.composites;

import entities.primitives.Passenger;
import lombok.ToString;

@ToString
public class BusinessClass extends Classes {
    public BusinessClass() {
        maxCountOfPassengers = 20;
        maxBaggageWeight = 35;
    }

    @Override
    public void addPassenger(Passenger passenger) {
        if (passenger.getWeight() <= maxBaggageWeight)
            super.addPassenger(passenger);
        else
            System.out.println("Превышен лимит багажа для пассажира бизнес класса");
    }
}
