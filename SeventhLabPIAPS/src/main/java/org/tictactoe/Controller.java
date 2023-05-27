package org.tictactoe;

import org.tictactoe.factory.GameFactory;

public class Controller {
    private Model model;
    private View view;

    public Controller(GameFactory factory) {
        model = factory.createModel();
        view = factory.createView();
        model.addObserver(view);
        view.setModel(model);
    }

    public void startGame() {
        view.drawBoard();
        while (true) {

            int[] move = view.getPlayerMove();
            int row = move[0];
            int col = move[1];
            if (model.makeMove(row, col)) {
                Character winner = model.checkWin();
                if (winner != null || model.isBoardFull()) {
                    view.showWinner(winner);
                    break;
                }
            } else {
                view.showInvalidMove();
            }
        }
    }
}

