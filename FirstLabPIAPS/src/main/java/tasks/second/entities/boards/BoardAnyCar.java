package tasks.second.entities.boards;

import tasks.second.entities.drivers.Driver;
import tasks.second.entities.passenger.Passenger;

public abstract class BoardAnyCar {
    protected boolean driverPresence;
    protected int countOfPassengers;

    public BoardAnyCar() {
        driverPresence = false;
        countOfPassengers = 0;
        System.out.println("Используется конструктор абстрактного класса BoardAny");
    }

    public abstract void boardDriver(Driver driver); //Здесь прописать ограничение на одного водителя

    public abstract void boardPassenger(Passenger passenger); //Здесь прописать ограничение на пассажиров

    //Проверка на готовность к отправке
    public boolean isReadyToGo() {
        return countOfPassengers > 0 && driverPresence;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " with " + countOfPassengers + " and " +
                (driverPresence ? "with" : "without") + " driver and this car " +
                (isReadyToGo() ? "is" : "isn't") + " ready to go";
    }
}
