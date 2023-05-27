package entities.primitives;

import entities.Baggage;
import entities.Unit;
import lombok.ToString;

import java.util.List;

@ToString
public class Passenger implements Unit {
    private Baggage baggage;

    public Passenger(Baggage baggage) {
        if (baggage.weight() >= 5 && baggage.weight() <= 60)
            this.baggage = baggage;
        else
            System.out.println("Пассажир не может лететь с таким багажом");
    }


    @Override
    public int getWeight() {
        if (baggage != null)
            return baggage.weight();
        else
            return 0;
    }

    @Override
    public void addPassenger(Passenger passenger) {
    }

    @Override
    public List<Unit> getPassengers() {
        return null;
    }

    public Baggage getBaggage() {
        return baggage;
    }
}
