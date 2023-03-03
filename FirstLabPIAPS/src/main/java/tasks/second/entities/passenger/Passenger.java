package tasks.second.entities.passenger;

public class Passenger {

    public Passenger() {
        System.out.println("Создан объект типа Passenger ");
    }

    public void getOnBus(){
        System.out.println("Пассажир сел в автобус");
    }

    public void getOnTaxi(){
        System.out.println("Пассажир сел в такси");
    }
}
