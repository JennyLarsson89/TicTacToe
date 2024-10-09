public class Board {
    // Ett 2D-array som representerar spelbrädet
    private char[][] board;

    // Konstant som anger storleken på spelbrädet (3x3)
    private final int SIZE = 3;

    // Konstruktor som initialiserar spelbrädet och rensar det
    public Board() {
        board = new char[SIZE][SIZE]; // Skapar ett tomt 3x3-bräde
        clearBoard(); // Rensar brädet genom att fylla det med '-'
    }

    // Metod för att visa spelbrädet i konsolen
    public void displayBoard() {
        System.out.println("Current board:"); // Skriver ut rubrik för brädet
        // Loopar igenom rader och kolumner för att skriva ut varje cell i brädet
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " "); // Skriver ut varje cell separerad med mellanslag
            }
            System.out.println(); // Skapar ny rad efter varje rad på brädet
        }
    }

    // Metod för att rensa spelbrädet inför ett nytt spel
    public void clearBoard() {
        // Fyller alla celler i brädet med '-' för att indikera att de är tomma
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-'; // Sätter varje position till '-'
            }
        }
    }

    // Kontrollera om spelarens drag är giltigt
    // Det måste vara inom gränserna för brädet och positionen måste vara tom
    public boolean isValidMove(int row, int col) {
        // Returnerar true om raden och kolumnen är inom gränserna och om cellen är tom
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == '-';
    }

    // Metod för att placera en spelares symbol på brädet
    public void makeMove(int row, int col, char symbol) {
        board[row][col] = symbol; // Sätter spelarens symbol ('X' eller 'O') på den angivna positionen
    }

    // Kontrollera om en spelare har vunnit
    public boolean isWinner(char symbol) {
        // Returnerar true om symbolen finns i en hel rad, kolumn eller diagonal
        return (checkRows(symbol) || checkColumns(symbol) || checkDiagonals(symbol));
    }

    // Kontrollera om brädet är fullt (ingen tom cell kvar)
    public boolean isBoardFull() {
        // Gå igenom alla celler och kontrollera om någon fortfarande är tom ('-')
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '-') {
                    return false; // Om det finns en tom cell, returnera false
                }
            }
        }
        return true; // Returnera true om alla celler är fyllda
    }

    // Hjälpmetod för att kontrollera om en spelare har vunnit genom raderna
    private boolean checkRows(char symbol) {
        // Loopar genom varje rad och kontrollerar om alla tre celler i raden innehåller spelarens symbol
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true; // Om alla celler i en rad innehåller samma symbol, har spelaren vunnit
            }
        }
        return false; // Returnera false om ingen rad är fylld med samma symbol
    }

    // Hjälpmetod för att kontrollera om en spelare har vunnit genom kolumnerna
    private boolean checkColumns(char symbol) {
        // Loopar genom varje kolumn och kontrollerar om alla tre celler i kolumnen innehåller spelarens symbol
        for (int i = 0; i < SIZE; i++) {
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true; // Om alla celler i en kolumn innehåller samma symbol, har spelaren vunnit
            }
        }
        return false; // Returnera false om ingen kolumn är fylld med samma symbol
    }

    // Hjälpmetod för att kontrollera om en spelare har vunnit genom diagonalerna
    private boolean checkDiagonals(char symbol) {
        // Kontrollerar båda diagonalerna för att se om alla celler innehåller spelarens symbol
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) || // Från övre vänstra till nedre högra
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);   // Från övre högra till nedre vänstra
    }
}
