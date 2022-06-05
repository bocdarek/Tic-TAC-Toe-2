package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Board {

    Scanner sc = new Scanner(System.in);
    private final char[][] board = new char[3][3];

    public void clearBoard() {
        for (char[] chars : board) {
            Arrays.fill(chars, '_');
        }
    }

    public void display() {
        displayDashes();
        for (int i = 0; i < board.length; i++) {
            displayRow(i);
        }
        displayDashes();
    }

    private void displayDashes() {
        System.out.println("-".repeat(9));
    }

    private void displayRow(int row) {
        System.out.print("| ");
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[row][i] + " ");
        }
        System.out.println("|");
    }

    public void evaluate() {
        if (isImpossible1() || isImpossible2()) {
            System.out.println("Impossible");
        } else if (xWins()){
            System.out.println("X wins");
        } else if (oWins()){
            System.out.println("O wins");
        } else if (isFull()) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }
    }

    private boolean isImpossible1() {
        int x = 0;
        int o = 0;
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == 'X') {
                    x++;
                } else if (aChar == 'O') {
                    o++;
                }
            }
        }
        return Math.abs(x - o) > 1;
    }

    private boolean isImpossible2() {
        return (isWinner('O') + isWinner('X')) > 1;
    }

    public boolean xWins() {
        return isWinner('X') == 1;
    }

    public boolean oWins() {
        return isWinner('O') == 1;
    }

    public boolean isFull() {
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    private int isWinner(char ch) {
        int h = checkHorizontal(ch);
        int v = checkVertical(ch);
        int d = checkDiagonal(ch);
        return h + v +d;
    }

    private int checkHorizontal(char ch) {
        int count = 0;
        for (char[] arr : board) {
            if (arr[0] == ch && arr[1] == ch && arr[2] == ch) {
                count++;
            }
        }
        return count;
    }

    private int checkVertical(char ch) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == ch && board[1][i] == ch && board[2][i] == ch) {
                count++;
            }
        }
        return count;
    }

    private int checkDiagonal(char ch) {
        int count = 0;
        if (board[0][0] == ch && board[1][1] == ch && board[2][2] == ch) {
            count++;
        }
        if (board[0][2] == ch && board[1][1] == ch && board[2][0] == ch) {
            count++;
        }
        return count;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setField(int x, int y, char ch) {
        board[x][y] = ch;
    }
}
