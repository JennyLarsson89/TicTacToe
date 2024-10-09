import java.util.Scanner; // Importerar Scanner-klassen för att läsa användarens inmatning från terminalen

public class Game {
    // Attribut för spelet
    private Board board;             // Representerar spelbrädet
    private Player player1;          // Representerar spelare 1, som spelar med symbolen 'X'
    private Player player2;          // Representerar spelare 2, som spelar med symbolen 'O'
    private Player currentPlayer;    // Håller koll på vilken spelare som har turen att spela just nu

    // Konstruktor för att initiera ett nytt spel
    public Game() {
        board = new Board();         // Skapar ett nytt spelbräde
        player1 = new Player('X');   // Skapar spelare 1 med symbolen 'X'
        player2 = new Player('O');   // Skapar spelare 2 med symbolen 'O'
        currentPlayer = player1;     // Spelare 1 börjar alltid spelet
    }

    // Metod som hanterar spelets gång
    public void play() {
        Scanner scanner = new Scanner(System.in);  // Skapar en scanner för att läsa användarens inmatning
        boolean gameWon = false;    // Håller reda på om någon har vunnit spelet
        boolean draw = false;       // Håller reda på om spelet har slutat oavgjort

        // Spelet fortsätter tills någon vinner eller spelet slutar oavgjort
        while (!gameWon && !draw) {
            board.displayBoard();   // Visar aktuellt spelbräde
            System.out.println("Player " + currentPlayer.getSymbol() + ", enter your move (row[1-3] and column[1-3]): ");

            // Tar emot spelarens drag (rad och kolumn), justerar för att matcha array-index (börjar från 0)
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            // Kontrollerar om spelarens drag är giltigt
            if (board.isValidMove(row, col)) {
                // Om draget är giltigt, placeras spelarens symbol på brädet
                board.makeMove(row, col, currentPlayer.getSymbol());

                // Kontrollera om den aktuella spelaren har vunnit
                if (board.isWinner(currentPlayer.getSymbol())) {
                    gameWon = true;  // Om en spelare vinner sätts gameWon till true
                    board.displayBoard();  // Visa det vinnande brädet
                    System.out.println("Player " + currentPlayer.getSymbol() + " wins!");  // Meddela att någon har vunnit
                }
                // Kontrollera om brädet är fullt och ingen har vunnit, dvs. oavgjort
                else if (board.isBoardFull()) {
                    draw = true;  // Om det inte finns några tomma rutor kvar, avslutas spelet som oavgjort
                    board.displayBoard();  // Visa det fulla brädet
                    System.out.println("It's a draw!");  // Meddela att spelet är oavgjort
                }
                // Om ingen har vunnit och spelet inte är oavgjort, byts turen till den andra spelaren
                else {
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;  // Växla mellan spelare 1 och spelare 2
                }
            } else {
                // Om draget inte är giltigt (rutan är redan upptagen eller utanför gränserna), be spelaren försöka igen
                System.out.println("Invalid move. Try again.");
            }
        }

        // När spelet är över (antingen vinst eller oavgjort), meddela att spelet startar om
        System.out.println("Game over! Starting a new game...");
        board.clearBoard();  // Rensa brädet för ett nytt spel
        play();  // Starta om spelet från början
    }
}
