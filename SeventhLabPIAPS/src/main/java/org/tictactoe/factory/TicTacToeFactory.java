package org.tictactoe.factory;

import org.tictactoe.Model;
import org.tictactoe.View;

public class TicTacToeFactory implements GameFactory {
    @Override
    public Model createModel() {
        return Model.getInstance();
    }

    @Override
    public View createView() {
        return new View();
    }
}

