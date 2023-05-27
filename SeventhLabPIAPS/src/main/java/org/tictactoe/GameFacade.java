package org.tictactoe;

import org.tictactoe.factory.GameFactory;
import org.tictactoe.factory.TicTacToeFactory;

public class GameFacade {
    private Controller controller;

    public GameFacade() {
        GameFactory factory = new TicTacToeFactory();
        controller = new Controller(factory);
    }

    public void startGame() {
        controller.startGame();
    }
}
