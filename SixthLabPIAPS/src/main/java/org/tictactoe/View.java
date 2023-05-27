package org.tictactoe;

import java.util.Scanner;

public class View implements GameObserver{
    private Model model;

    public void setModel(Model model) {
        this.model = model;
    }

    public void drawBoard() {
        char[][] board = model.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
        System.out.println();
    }

    public int[] getPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row (0-2): ");
        int row = scanner.nextInt();
        System.out.print("Enter column (0-2): ");
        int col = scanner.nextInt();
        return new int[]{row, col};
    }

    public void showWinner(Character winner) {
        if (winner != null) {
            System.out.println("Player " + winner + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    public void showInvalidMove() {
        System.out.println("Invalid move. Please choose an empty cell.");
    }

    @Override
    public void update() {
        drawBoard();
    }
}

