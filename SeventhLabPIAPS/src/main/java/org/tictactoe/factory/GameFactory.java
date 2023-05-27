package org.tictactoe.factory;

import org.tictactoe.Model;
import org.tictactoe.View;

public interface GameFactory {
    Model createModel();
    View createView();
}

