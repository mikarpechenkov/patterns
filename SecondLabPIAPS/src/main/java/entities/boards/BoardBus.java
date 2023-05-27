package entities.boards;

import entities.boards.builders.BoardBuilder;
import entities.drivers.Driver;
import entities.drivers.DrivingLicenseCategory;
import entities.passenger.BusPassenger;
import entities.passenger.Passenger;

import java.util.ArrayList;
import java.util.List;


public class BoardBus extends BoardAnyCar {
    private BoardBus(Builder builder) {
        super();

        maxPassengers = Builder.maxPassengers;
        boardDriver(builder.driver);
        builder.passengers.forEach(this::boardPassenger);

        System.out.println("Вызван конструктор BoardBus");
    }

    @Override
    protected boolean isRightDriver(Driver driver) {
        return driver.getDrivingLicenseCategory() == DrivingLicenseCategory.D;
    }

    @Override
    protected boolean isRightPassenger(Passenger passenger) {
        return passenger instanceof BusPassenger;
    }

    public static class Builder implements BoardBuilder {
        private final static int maxPassengers = 30;
        private Driver driver;
        private List<Passenger> passengers;

        public Builder() {
            System.out.println("Используется конструктор BoardBus.Builder");
        }

        @Override
        public BoardBuilder setDriver(Driver driver) {
            this.driver = driver;
            return this;
        }

        @Override
        public BoardBuilder addPassenger(Passenger passenger) {
            if (passengers == null)
                passengers = new ArrayList<>();
            passengers.add(passenger);
            return this;
        }

        public BoardAnyCar build() {
            return new BoardBus(this);
        }
    }
}
