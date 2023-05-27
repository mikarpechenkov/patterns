package entities.passenger;

public class TaxiPassenger extends Passenger {

    public TaxiPassenger(TypeOfPassenger typeOfPassenger) {
        super(typeOfPassenger);
        System.out.println("Создан объект типа TaxiPassenger");
    }

    @Override
    public void setTypeOfPassenger(TypeOfPassenger typeOfPassenger) {
        if (typeOfPassenger != TypeOfPassenger.PREFERENTIAL)
            this.typeOfPassenger = typeOfPassenger;
        else
            System.out.println("Не существует льгот для такси");;
    }

    @Override
    public boolean getOn() {
        System.out.println("Пассажир сел в такси");
        return true;
    }

    @Override
    public String toString() {
        return "TaxiPassenger has a category " + typeOfPassenger;
    }
}
