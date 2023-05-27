package entities.boards.builders;

import entities.boards.BoardAnyCar;
import entities.drivers.Driver;
import entities.passenger.Passenger;

public interface BoardBuilder {
    BoardBuilder setDriver(Driver driver);

    BoardBuilder addPassenger(Passenger passenger);

    BoardAnyCar build();
}
