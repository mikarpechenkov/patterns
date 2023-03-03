package tasks.second.entities.boards;

import tasks.second.entities.drivers.Driver;
import tasks.second.entities.drivers.DrivingLicenseCategory;
import tasks.second.entities.passenger.Passenger;


public class BoardBus extends BoardAnyCar {
    private static final int maxPassengers=20;
    public BoardBus() {
        super();
        System.out.println("Создан объект типа BoardBus");
    }

    @Override
    public void boardDriver(Driver driver) {
        if (!driverPresence)
            if (driver.getDrivingLicenseCategory() == DrivingLicenseCategory.D)
                driverPresence = driver.getOn();
            else
                System.out.println("У данного водителя нет соответствующей категории в правах");
        else
            System.out.println("У этого автобуса уже есть водитель");
    }

    @Override
    public void boardPassenger(Passenger passenger) {
        if (countOfPassengers < maxPassengers) {
            passenger.getOnBus();
            countOfPassengers++;
        } else {
            System.out.println("Автобус полностью загружен, посадка более невозможна");
        }
    }
}
