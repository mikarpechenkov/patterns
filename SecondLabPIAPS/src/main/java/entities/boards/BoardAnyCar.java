package entities.boards;

import entities.drivers.Driver;
import entities.passenger.Passenger;

import java.util.ArrayList;
import java.util.List;

/*
 * Заменил поле присутствие водителя на самого водителя;
 * Заменил количество пассажиров на коллекцию пассажиров
 */
public abstract class BoardAnyCar {
    protected int maxPassengers;
    protected Driver driver;
    protected List<Passenger> passengers;

    public boolean boardDriver(Driver driver) {
        if (this.driver == null)
            if (isRightDriver(driver)) {
                this.driver = driver;
                return driver.getOn();
            } else {
                System.out.println("У данного водителя нет соответствующей категории в правах");
                return false;
            }
        else
            System.out.println("У этого автомобиля уже есть водитель");
        return false;
    }

    protected abstract boolean isRightDriver(Driver driver);

    //Проверка на готовность к отправке
    public boolean isReadyToGo() {
        return passengers != null && !passengers.isEmpty() && driver != null;
    }

    public boolean boardPassenger(Passenger passenger) {
        if (isRightPassenger(passenger)) {
            if (passengers == null)
                passengers = new ArrayList<>();
            if (passengers.size() < maxPassengers) {
                passengers.add(passenger);
                return passenger.getOn();
            } else {
                System.out.println("Автомобиль полностью загружено, посадка более невозможна");
                return false;
            }
        }
        return false;
    }

    protected abstract boolean isRightPassenger(Passenger passenger);

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " with " + passengers.size() + " and " +
                (driver != null ? "with" : "without") + " driver and this car " +
                (isReadyToGo() ? "is" : "isn't") + " ready to go" + "\n info about passengers:\n" + passengers;
    }
}
