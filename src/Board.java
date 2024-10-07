// Hanterar spelplanen, validerar drag, visar rutnätet
// och kontrollerar om en spelare har vunnit eller om
// det är oavgjort.

public class Board {
    private char[][] board;
    private final int SIZE = 3;

    public Board() {
        board = new char[SIZE][SIZE];
        clearBoard();
    }

    // Display the board to the console
    public void displayBoard() {
        System.out.println("Current board:");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Clear the board for a new game
    public void clearBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Check if the move is valid (i.e., within bounds and on an empty cell)
    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == '-';
    }

    // Place a player's symbol on the board
    public void makeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Check if there is a winner
    public boolean isWinner(char symbol) {
        // Check rows, columns, and diagonals
        return (checkRows(symbol) || checkColumns(symbol) || checkDiagonals(symbol));
    }

    // Check if the board is full (i.e., no more empty cells)
    public boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    // Helper methods to check for a winner
    private boolean checkRows(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(char symbol) {
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }
}
