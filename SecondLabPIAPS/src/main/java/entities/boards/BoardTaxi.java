package entities.boards;

import entities.drivers.Driver;
import entities.drivers.DrivingLicenseCategory;
import entities.passenger.Passenger;
import entities.passenger.TaxiPassenger;
import entities.passenger.TypeOfPassenger;


public class BoardTaxi extends BoardAnyCar {

    public BoardTaxi() {
        super();
        maxPassengers = 4;
        System.out.println("Создан объект типа BoardTaxi");
    }

    @Override
    protected boolean isRightDriver(Driver driver) {
        return driver.getDrivingLicenseCategory() == DrivingLicenseCategory.B;
    }

    @Override
    protected boolean isRightPassenger(Passenger passenger) {
        return passenger instanceof TaxiPassenger;
    }

    @Override
    public boolean boardPassenger(Passenger passenger) {
        boolean isPassengerGotOn = super.boardPassenger(passenger);
        if (isPassengerGotOn && passenger.getTypeOfPassenger() == TypeOfPassenger.KID)
            System.out.println("Установлено детское кресло");
        return isPassengerGotOn;
    }
}
