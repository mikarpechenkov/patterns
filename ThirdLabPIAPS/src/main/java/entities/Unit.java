package entities;

import entities.primitives.Passenger;

import java.util.List;

public interface Unit{
    int getWeight();
    void addPassenger(Passenger passenger);
    List<Unit> getPassengers();
}
