package tasks.second.entities.boards;

import tasks.second.entities.drivers.Driver;
import tasks.second.entities.drivers.DrivingLicenseCategory;
import tasks.second.entities.passenger.Passenger;


public class BoardTaxi extends BoardAnyCar {
    private static final int maxPassenger=4;

    public BoardTaxi() {
        super();
        System.out.println("Создан объект типа BoardTaxi");
    }

    @Override
    public void boardDriver(Driver driver) {
        if (!driverPresence)
            if (driver.getDrivingLicenseCategory() == DrivingLicenseCategory.B)
                driverPresence = driver.getOn();
            else
                System.out.println("У данного водителя нет соответствующей категории в правах");
        else
            System.out.println("У этого такси уже есть водитель");
    }

    @Override
    public void boardPassenger(Passenger passenger) {
        if (countOfPassengers < maxPassenger) {
            passenger.getOnTaxi();
            countOfPassengers++;
        } else {
            System.out.println("Такси полностью загружено, посадка более невозможна");
        }
    }
}
