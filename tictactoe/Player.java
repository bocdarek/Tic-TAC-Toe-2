package tictactoe;

public class Player {

    private final Board board;

    public Player(Board board) {
        this.board = board;
    }

    public void move(char ch) {
        Coordinates coordinates = takeCoordinates();
        updateBoard(coordinates, ch);
    }

    private Coordinates takeCoordinates() {
        String input;
        do {
            System.out.print("Enter the coordinates: ");
            input = board.sc.nextLine();
        } while (!isValid(input));

        int x = Integer.parseInt(input.substring(0, 1)) - 1;
        int y = Integer.parseInt(input.substring(2, 3)) - 1;
        return new Coordinates(x, y);
    }

    private void updateBoard(Coordinates coordinates, char ch) {
        int x = coordinates.getX();
        int y = coordinates.getY();
        board.setField(x, y, ch);
    }

    private boolean isValid(String input) {
        if (!isCorrectFormat(input)) {
            System.out.println("You should enter numbers!");
            return false;
        }
        if (!isInRange(input)) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        if (isOccupied(input)) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        return true;
    }

    private boolean isCorrectFormat(String input) {
        String digits = "0123456789";
        return input.length() == 3
                && digits.contains(input.substring(0, 1))
                && input.charAt(1) == ' '
                && digits.contains(input.substring(2, 3));
    }

    private boolean isInRange(String input) {
        int x = Integer.parseInt(input.substring(0, 1));
        int y = Integer.parseInt(input.substring(2, 3));
        return x >= 1 && x <= 3 && y >= 1 && y <= 3;
    }

    private boolean isOccupied(String input) {
        int x = Integer.parseInt(input.substring(0, 1));
        int y = Integer.parseInt(input.substring(2, 3));
        return board.getBoard()[x - 1][y - 1] != '_';
    }
}
