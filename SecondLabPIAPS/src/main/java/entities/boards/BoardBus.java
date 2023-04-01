package entities.boards;

import entities.drivers.Driver;
import entities.drivers.DrivingLicenseCategory;
import entities.passenger.BusPassenger;
import entities.passenger.Passenger;


public class BoardBus extends BoardAnyCar {
    public BoardBus() {
        super();
        maxPassengers = 30;
        System.out.println("Создан объект типа BoardBus");
    }

    @Override
    protected boolean isRightDriver(Driver driver) {
        return driver.getDrivingLicenseCategory() == DrivingLicenseCategory.D;
    }

    @Override
    protected boolean isRightPassenger(Passenger passenger) {
        return passenger instanceof BusPassenger;
    }
}
