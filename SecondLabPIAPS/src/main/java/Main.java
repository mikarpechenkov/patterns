import entities.boards.BoardAnyCar;
import entities.boards.BoardBus;
import entities.boards.BoardTaxi;
import entities.boards.builders.BoardDirector;

public class Main {
    public static void main(String[] args) {
        var director = new BoardDirector(new BoardTaxi.Builder());

        BoardAnyCar boardTaxi = director.make();
        System.out.println(boardTaxi);

        director.changeBuilder(new BoardBus.Builder());
        BoardAnyCar boardBus = director.make();
        System.out.println(boardBus);
    }
}
