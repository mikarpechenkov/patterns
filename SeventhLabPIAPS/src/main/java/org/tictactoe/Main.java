package org.tictactoe;

import org.tictactoe.factory.GameFactory;
import org.tictactoe.factory.TicTacToeFactory;

public class Main {
    public static void main(String[] args) {
        GameFacade facade = new GameFacade();
        facade.startGame();
    }
}
