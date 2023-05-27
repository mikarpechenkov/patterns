package org.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static Model instance;
    private char[][] board;
    private char currentPlayer;
    private List<GameObserver> observers;

    private Model() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
        observers = new ArrayList<>();
    }

    public static Model getInstance() {
        if (instance == null)
            instance = new Model();
        return instance;
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public boolean makeMove(int row, int col) {
        if (board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            notifyObservers();
            return true;
        }
        return false;
    }

    public Character checkWin() {
        char[][] winningCombinations = {
                {board[0][0], board[0][1], board[0][2]},
                {board[1][0], board[1][1], board[1][2]},
                {board[2][0], board[2][1], board[2][2]},
                {board[0][0], board[1][0], board[2][0]},
                {board[0][1], board[1][1], board[2][1]},
                {board[0][2], board[1][2], board[2][2]},
                {board[0][0], board[1][1], board[2][2]},
                {board[0][2], board[1][1], board[2][0]}
        };

        for (char[] combination : winningCombinations) {
            if (combination[0] != ' ' && combination[0] == combination[1] && combination[1] == combination[2]) {
                return combination[0];
            }
        }
        return null;
    }

    public boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (GameObserver observer : observers) {
            observer.update();
        }
    }

    public char[][] getBoard() {
        return board;
    }
}

