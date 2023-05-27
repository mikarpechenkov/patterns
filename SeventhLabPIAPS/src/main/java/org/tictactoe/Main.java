package org.tictactoe;

import org.tictactoe.factory.GameFactory;
import org.tictactoe.factory.TicTacToeFactory;

public class Main {
    public static void main(String[] args) {
        GameFactory factory = new TicTacToeFactory();
        Controller controller = new Controller(factory);
        controller.startGame();
    }
}
