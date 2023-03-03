package tasks.second.abstractfactory;


import tasks.second.entities.boards.BoardAnyCar;
import tasks.second.entities.drivers.Driver;

public interface ParkFactory {
    BoardAnyCar createBoardCurrentCar();
    Driver createDriver();
}
