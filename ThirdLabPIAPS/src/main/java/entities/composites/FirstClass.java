package entities.composites;

import lombok.ToString;

@ToString
public class FirstClass extends Classes {

    public FirstClass() {
        maxBaggageWeight = Integer.MAX_VALUE;
        maxCountOfPassengers = 10;
    }
    // addPassenger в данном случае имеет базовую реализацию
}
