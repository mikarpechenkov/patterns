package org.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public static final int SIZE = 5;
    private static Model instance;
    private char[][] board;
    private char currentPlayer;
    private List<GameObserver> observers;

    private Model() {
        board = new char[SIZE][SIZE];
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
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
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

    private boolean checkRowWin() {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][2] == board[i][3]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnWin() {
        for (int i = 0; i < SIZE; i++) {
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[2][i] == board[3][i]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalWin() {
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == board[3][3]) {
            return true;
        }
        if (board[0][3] != ' ' && board[0][3] == board[1][2] && board[1][2] == board[2][1] && board[2][1] == board[3][0]) {
            return true;
        }
        return false;
    }

    public Character checkWin() {
//        char[][] winningCombinations=new char[SIZE][SIZE];
        int counter = 0;
        char symbolCheckingForWin = (currentPlayer == 'X') ? 'O' : 'X';
        for (int i = 0; i < SIZE * 2 + 2; i++) {
            counter = 0;
//            if (i < SIZE)
//                symbolCheckingForWin = board[i][0];
//            if (i < SIZE*2 && i >= SIZE)
//                symbolCheckingForWin = board[0][i-SIZE];
//            if (i >= SIZE*2)
//                symbolCheckingForWin = board[(i-SIZE*2)*(SIZE-1)][0];
            for (int j = 0; j < SIZE; j++) {
                if (i < SIZE) {
                    if (symbolCheckingForWin == board[i][j]) {
                        counter++;
                        if (counter == SIZE)
                            return symbolCheckingForWin;
                        continue;
                    } else
                        counter = 0;
                }
                if (i < SIZE * 2 && i >= SIZE) {
                    if (symbolCheckingForWin == board[j][i - SIZE]) {
                        counter++;
                        if (counter == SIZE)
                            return symbolCheckingForWin;
                        continue;
                    } else
                        counter = 0;
                }
                if (i == SIZE * 2) {
                    if (symbolCheckingForWin == board[j][j]) {
                        counter++;
                        if (counter == SIZE)
                            return symbolCheckingForWin;
                        continue;
                    } else
                        counter = 0;
                }
                if (i == SIZE * 2 + 1) {
                    if (symbolCheckingForWin == board[SIZE - j - 1][j]) {
                        counter++;
                        if (counter == SIZE)
                            return symbolCheckingForWin;
                        continue;
                    } else
                        counter = 0;
                }
//                    if (counter == SIZE)
//                        return symbolCheckingForWin;
//                    else
//                        return null;
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

