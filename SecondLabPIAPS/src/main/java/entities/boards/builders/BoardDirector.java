package entities.boards.builders;

import entities.boards.BoardAnyCar;
import entities.boards.BoardBus;
import entities.boards.BoardTaxi;
import entities.drivers.BusDriver;
import entities.drivers.TaxiDriver;
import entities.passenger.BusPassenger;
import entities.passenger.TaxiPassenger;
import entities.passenger.TypeOfPassenger;

public class BoardDirector {
    private BoardBuilder builder;

    public BoardDirector(BoardBuilder builder) {
        this.builder = builder;
    }

    public void changeBuilder(BoardBuilder builder) {
        this.builder = builder;
    }

    public BoardAnyCar make() {
        if (builder instanceof BoardBus.Builder)
            builder.setDriver(new BusDriver())
                    .addPassenger(new BusPassenger(TypeOfPassenger.PREFERENTIAL))
                    .addPassenger(new BusPassenger(TypeOfPassenger.KID))
                    .addPassenger(new BusPassenger(TypeOfPassenger.ADULT))
                    .addPassenger(new BusPassenger(TypeOfPassenger.PREFERENTIAL));

        if (builder instanceof BoardTaxi.Builder)
            builder.setDriver(new TaxiDriver())
                    .addPassenger(new TaxiPassenger(TypeOfPassenger.KID))
                    .addPassenger(new TaxiPassenger(TypeOfPassenger.ADULT))
                    .addPassenger(new TaxiPassenger(TypeOfPassenger.ADULT))
                    .addPassenger(new TaxiPassenger(TypeOfPassenger.PREFERENTIAL));

        return builder.build();
    }
}
