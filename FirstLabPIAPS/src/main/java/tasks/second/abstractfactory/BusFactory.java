package tasks.second.abstractfactory;


import tasks.second.entities.boards.BoardAnyCar;
import tasks.second.entities.boards.BoardBus;
import tasks.second.entities.drivers.BusDriver;
import tasks.second.entities.drivers.Driver;

public class BusFactory implements ParkFactory{
    private static BusFactory instance;

    private BusFactory(){
        System.out.println("Создается BusFactory");
    }

    public static ParkFactory getInstance(){
        if(instance==null)
            instance=new BusFactory();
        return instance;
    }

    @Override
    public BoardAnyCar createBoardCurrentCar() {
        return new BoardBus();
    }

    @Override
    public Driver createDriver() {
        return new BusDriver();
    }
}
