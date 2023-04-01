package entities.passenger;

public abstract class Passenger {
    protected TypeOfPassenger typeOfPassenger;

    public Passenger(TypeOfPassenger typeOfPassenger) {
        setTypeOfPassenger(typeOfPassenger);
        System.out.println("Используется конструктор абстрактного класса Passenger");
    }

    public TypeOfPassenger getTypeOfPassenger() {
        return typeOfPassenger;
    }

    public abstract void setTypeOfPassenger(TypeOfPassenger typeOfPassenger);
    public abstract boolean getOn();
}
