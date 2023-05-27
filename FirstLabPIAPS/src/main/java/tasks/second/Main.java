package tasks.second;

import tasks.second.abstractfactory.BusFactory;
import tasks.second.abstractfactory.ParkFactory;
import tasks.second.abstractfactory.TaxiFactory;
import tasks.second.entities.TypesOfTransport;
import tasks.second.entities.boards.BoardAnyCar;
import tasks.second.entities.boards.BoardBus;
import tasks.second.entities.boards.BoardTaxi;
import tasks.second.entities.drivers.Driver;
import tasks.second.entities.drivers.TaxiDriver;
import tasks.second.entities.passenger.Passenger;

public class Main {
    public static void main(String[] args) {
        Example example1 = new Example(TypesOfTransport.BUS);
        example1.boardPassengers(19);
        example1.boardDriver();
        System.out.println(example1);

        Example example2 = new Example(TypesOfTransport.TAXI);
        example2.boardDriver();
        example2.boardPassengers(0);
        System.out.println(example2);

        example2.boardDriver(example1.getDriver());
        example2.boardPassengers(6);
        System.out.println(example2);
    }
}

class Example {
    private BoardAnyCar board;
    private Driver driver;

    public Example(TypesOfTransport typeOfTransport) {
        ParkFactory factory =
                switch (typeOfTransport) {
                    case BUS -> BusFactory.getInstance();
                    case TAXI -> TaxiFactory.getInstance();
                };
        board = factory.createBoardCurrentCar();
        driver = factory.createDriver();
    }

    public void boardPassengers(int countOfPassengers) {
        for (int i = 0; i != countOfPassengers; i++)
            board.boardPassenger(new Passenger());
    }

    public Driver getDriver() {
        return driver;
    }

    public void boardDriver(Driver driver) {
        this.driver = driver;
        boardDriver();
    }

    public void boardDriver() {
        board.boardDriver(driver);
    }

    @Override
    public String toString() {
        return board.toString() + ", type of driver is " + driver.getClass().getSimpleName() + "\n";
    }
}
