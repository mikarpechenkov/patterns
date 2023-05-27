import entities.Airplane;
import entities.Baggage;
import entities.Unit;
import entities.composites.BusinessClass;
import entities.composites.EconomyClass;
import entities.composites.FirstClass;
import entities.primitives.Passenger;
import entities.primitives.Pilot;
import entities.primitives.Stewardess;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        Airplane airplane = new Airplane();

        //Добавляем стюардесс
        for (int i = 0; i != 5; i++)
            airplane.addEntity(new Stewardess());

        //Добавление пилотов
        for (int i = 0; i != 3; i++)
            airplane.addEntity(new Pilot());

        //Добавление первого класса
        Unit firstClass = new FirstClass();
        for (int i = 0; i != 5; i++)
            firstClass.addPassenger(new Passenger(new Baggage(rand.nextInt(), rand.nextInt(5, 60))));
        airplane.addEntity(firstClass);

        //Добавление бизнес класса
        Unit businessClass = new BusinessClass();
        for (int i = 0; i != 11; i++)
            businessClass.addPassenger(new Passenger(new Baggage(rand.nextInt(), rand.nextInt(5, 35))));
        airplane.addEntity(businessClass);

        //Добавление эконома
        Unit economyClass = new EconomyClass();
        for (int i = 0; i != 100; i++)
            economyClass.addPassenger(new Passenger(new Baggage(rand.nextInt(), rand.nextInt(5, 20))));
        airplane.addEntity(economyClass);

        System.out.println(airplane);
    }
}
