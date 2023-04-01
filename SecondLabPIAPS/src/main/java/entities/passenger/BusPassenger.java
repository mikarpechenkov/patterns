package entities.passenger;

import entities.passenger.Passenger;

public class BusPassenger extends Passenger {
    private int ticketPrice;

    public BusPassenger(TypeOfPassenger typeOfPassenger) {
        super(typeOfPassenger);
        System.out.println("Создан объект типа BusPassenger");
    }

    @Override
    public void setTypeOfPassenger(TypeOfPassenger typeOfPassenger) {
        this.typeOfPassenger = typeOfPassenger;
        setTicketPrice();
    }

    @Override
    public boolean getOn() {
        System.out.println("Пассажир сел в автобус");
        return true;
    }

    private void setTicketPrice() {
        switch (typeOfPassenger) {
            case ADULT -> ticketPrice = 50;
            case PREFERENTIAL -> ticketPrice = 25;
            case KID -> ticketPrice = 20;
        }
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public String toString() {
        return "BusPassenger has a category " + typeOfPassenger + " and ticket for him costs "
                + ticketPrice + "₽";
    }
}
