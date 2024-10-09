import java.util.Scanner; // Importerar Scanner-klassen för att möjliggöra inmatning från användaren via terminalen

public class TicTacToe {
    public static void main(String[] args) {     // Huvudmetoden som körs när programmet startar
        Game game = new Game(); // Skapar ett nytt Game-objekt som representerar ett nytt Tic-Tac-Toe-spel

        game.play();    // Anropar play()-metoden för att starta spelet och hantera spelets gång
    }
}

