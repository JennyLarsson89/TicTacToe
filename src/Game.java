// Hanterar spelets flöde, byter spelare, kontrollerar om
// någon har vunnit eller om spelet slutat oavgjort,
// och startar om spelet när det är klart.

import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game() {
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
    }

    // Method to start and manage the game flow
    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;
        boolean draw = false;

        while (!gameWon && !draw) {
            board.displayBoard();
            System.out.println("Player " + currentPlayer.getSymbol() + ", enter your move (row[1-3] and column[1-3]): ");
            int row = scanner.nextInt() - 1; // Subtract 1 to match array indexing
            int col = scanner.nextInt() - 1;

            // Check if the input move is valid
            if (board.isValidMove(row, col)) {
                board.makeMove(row, col, currentPlayer.getSymbol());

                if (board.isWinner(currentPlayer.getSymbol())) {
                    gameWon = true;
                    board.displayBoard();
                    System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                } else if (board.isBoardFull()) {
                    draw = true;
                    board.displayBoard();
                    System.out.println("It's a draw!");
                } else {
                    // Switch players
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        System.out.println("Game over! Starting a new game...");
        board.clearBoard();
        play(); // Restart the game after it's over
    }
}
