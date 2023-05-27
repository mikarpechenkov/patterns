package entities.primitives;

import entities.Unit;
import lombok.ToString;

import java.util.List;

@ToString
public class Stewardess implements Unit {
    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public void addPassenger(Passenger passenger) {    }

    @Override
    public List<Unit> getPassengers() {
        return null;
    }
}
