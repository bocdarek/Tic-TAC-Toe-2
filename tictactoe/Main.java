package tictactoe;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Player player = new Player(board);
        board.clearBoard();
        board.display();

        int turn = 0;
        while (!board.xWins() && !board.oWins() && !board.isFull()) {
            if (turn % 2 == 0) {
                player.move('X');
            } else {
                player.move('O');
            }
            board.display();
            turn++;
        }
        board.evaluate();
    }
}
