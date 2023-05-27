package entities.boards;

import entities.boards.builders.BoardBuilder;
import entities.drivers.Driver;
import entities.drivers.DrivingLicenseCategory;
import entities.passenger.Passenger;
import entities.passenger.TaxiPassenger;
import entities.passenger.TypeOfPassenger;

import java.util.ArrayList;
import java.util.List;


public class BoardTaxi extends BoardAnyCar {

    private BoardTaxi(Builder builder) {
        super();

        maxPassengers = Builder.maxPassengers;
        boardDriver(builder.driver);
        builder.passengers.forEach(this::boardPassenger);

        System.out.println("Вызван конструктор BoardTaxi");
    }

    @Override
    protected boolean isRightDriver(Driver driver) {
        return driver.getDrivingLicenseCategory() == DrivingLicenseCategory.B;
    }

    @Override
    protected boolean isRightPassenger(Passenger passenger) {
        return passenger instanceof TaxiPassenger && passenger.getTypeOfPassenger()!=null;
    }

    @Override
    public boolean boardPassenger(Passenger passenger) {
        boolean isPassengerGotOn = super.boardPassenger(passenger);
        if (isPassengerGotOn && passenger.getTypeOfPassenger() == TypeOfPassenger.KID)
            System.out.println("Установлено детское кресло");
        return isPassengerGotOn;
    }

    public static class Builder implements BoardBuilder {
        private final static int maxPassengers = 4;
        private Driver driver;
        private List<Passenger> passengers;

        public Builder() {
            System.out.println("Используется конструктор BoardTaxi.Builder");
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
            return new BoardTaxi(this);
        }
    }
}
