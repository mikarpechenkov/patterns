package entities.boards.builders;

public class Director {
    private BoardBuilder builder;

    public Director(BoardBuilder builder) {
        this.builder = builder;
    }

    public void changeBuilder(BoardBuilder builder) {
        this.builder = builder;
    }

    public BoardAnyCar(BoardBuilder builder) {

    }
}
