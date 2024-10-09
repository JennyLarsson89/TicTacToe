public class Player {
    // Attribut för att lagra spelarens symbol ('X' eller 'O')
    private char symbol;

    // Konstruktor som tar in spelarens symbol och tilldelar den till attributet 'symbol'
    public Player(char symbol) {
        this.symbol = symbol; // Tilldelar symbolen som skickas in till spelarens symbol
    }

    // Metod för att hämta spelarens symbol
    public char getSymbol() {
        return symbol; // Returnerar spelarens symbol ('X' eller 'O')
    }
}
