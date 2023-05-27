package entities;

import entities.composites.BusinessClass;
import entities.composites.EconomyClass;
import entities.composites.FirstClass;
import entities.primitives.Passenger;
import entities.primitives.Pilot;
import entities.primitives.Stewardess;

import java.util.LinkedList;
import java.util.List;

public class Airplane {
    public final static int MAX_COUNT_OF_STEWARDESSES = 6;
    public final static int MAX_COUNT_OF_PILOTS = 2;
    public final static int MAX_WEIGHT_OF_BAGGAGE = 1000;
    List<Unit> entitiesOnBoard = new LinkedList<>();

    public int getWeight() {
        return entitiesOnBoard.stream()
                .mapToInt(Unit::getWeight)
                .sum();
    }

    public void addEntity(Unit unit) {
        if (unit instanceof Stewardess) {
            long countOfStewardess = entitiesOnBoard.stream()
                    .filter(person -> person instanceof Stewardess)
                    .count();
            if (countOfStewardess < MAX_COUNT_OF_STEWARDESSES)
                entitiesOnBoard.add(unit);
            else
                System.out.println("Превышен лимит стюардесс");
        } else if (unit instanceof Pilot) {
            long countOfPilots = entitiesOnBoard.stream()
                    .filter(person -> person instanceof Pilot)
                    .count();
            if (countOfPilots < MAX_COUNT_OF_PILOTS)
                entitiesOnBoard.add(unit);
            else
                System.out.println("Превышен лимит пилотов");
        } else if (unit instanceof EconomyClass) {
            long countOfEconomyClass = entitiesOnBoard.stream()
                    .filter(person -> person instanceof EconomyClass)
                    .count();
            if (countOfEconomyClass < 1) {
                while (getWeight() + unit.getWeight() > MAX_WEIGHT_OF_BAGGAGE) {
                    Passenger deprivedPassenger = (Passenger) unit.getPassengers().remove(unit.getPassengers().size() - 1);
                    System.out.printf("Изъят багаж у эконом класса %s%n", deprivedPassenger.getBaggage());
                }
                entitiesOnBoard.add(unit);
            } else
                System.out.println("Сущность эконом класса уже зарегистрирована на борту");
        } else if (unit instanceof BusinessClass) {
            long countOfBusinessClass = entitiesOnBoard.stream()
                    .filter(person -> person instanceof BusinessClass)
                    .count();
            if (countOfBusinessClass < 1)
                entitiesOnBoard.add(unit);
            else
                System.out.println("Сущность бизнес класса уже зарегистрирована на борту");
        }else if(unit instanceof FirstClass){
            long countOfFirstClass = entitiesOnBoard.stream()
                    .filter(person -> person instanceof BusinessClass)
                    .count();
            if (countOfFirstClass < 1)
                entitiesOnBoard.add(unit);
            else
                System.out.println("Сущность первого класса уже зарегистрирована на борту");
        }
    }

    @Override
    public String toString() {
        StringBuffer tmp = new StringBuffer("Самолет: \n");
        entitiesOnBoard.forEach(tmp::append);
        return tmp.toString();
    }
}
