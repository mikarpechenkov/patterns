package tasks.second.abstractfactory;

import tasks.second.entities.boards.BoardAnyCar;
import tasks.second.entities.boards.BoardTaxi;
import tasks.second.entities.drivers.Driver;
import tasks.second.entities.drivers.TaxiDriver;

public class TaxiFactory implements ParkFactory{
    private static TaxiFactory instance;

    private TaxiFactory(){
        System.out.println("Создание TaxiFactory");
    }

    public static ParkFactory getInstance(){
        if(instance==null)
            instance=new TaxiFactory();
        return instance;
    }

    @Override
    public BoardAnyCar createBoardCurrentCar() {
        return new BoardTaxi();
    }

    @Override
    public Driver createDriver() {
        return new TaxiDriver();
    }
}
