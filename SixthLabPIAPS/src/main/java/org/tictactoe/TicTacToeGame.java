package org.tictactoe;

public class TicTacToeGame {
    public static void main(String[] args) {
        Model model = Model.getInstance();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.startGame();
    }
}
