package org.tictactoe;

import java.util.Scanner;

public class View implements GameObserver {
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
        int row = 0;
        int col = 0;
        System.out.print("Enter row (1-3): ");
        boolean flag = false;
        while (!flag)
            try {
                row = Integer.parseInt(scanner.nextLine());
                if (row <= 3 && row >= 1)
                    flag = true;
                else
                    throw new RuntimeException();
            } catch (Exception e) {
                System.out.print("Input correct row number: ");
            }
        flag = false;
        System.out.print("Enter column (1-3): ");
        while (!flag)
            try {
                col = Integer.parseInt(scanner.nextLine());
                if (col <= 3 && col >= 1)
                    flag = true;
                else
                    throw new RuntimeException();
            } catch (Exception e) {
                System.out.print("Input correct column number: ");
            }
        return new int[]{row - 1, col - 1};
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

