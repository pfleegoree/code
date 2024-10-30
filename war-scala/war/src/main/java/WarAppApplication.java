import java.util.*;

public class WarAppApplication {

    public static void main(String[] args) {

        // Making a list of cards
        List<String> list = new ArrayList<>(List.of(
                "AH", "2H", "3H", "4H", "5H", "6H",
                "AD", "2D", "3D", "4D", "5D", "6D",
                "AC", "2C", "3C", "4C", "5C", "6C",
                "AS", "2S", "3S", "4S", "5S", "6S"
        ));

        // Each player gets a variable number of cards
        Random rand = new Random();

        // Shuffle the deck
        Collections.shuffle(list);

        // Generate a random number of cards for player1 (e.g., between 1 and half the deck size)
        int player1CardCount = rand.nextInt(list.size() / 2) + 1;
        List<String> playerList1 = new ArrayList<>(list.subList(0, player1CardCount));

        // Remove the cards given to player1 from the deck
        list.subList(0, player1CardCount).clear();

        int player2CardCount = rand.nextInt(list.size() / 2) + 1;
        List<String> playerList2 = new ArrayList<>(list.subList(0, player1CardCount));

        // Create new player decks
        Stack<String> player1 = new Stack<>();
        Stack<String> player2 = new Stack<>();

        // Add cards to player1 and player2 decks
        player1.addAll(playerList1);
        player2.addAll(playerList2); // Remaining cards for player2

        // Print the results
        System.out.println("Player 1's cards: " + player1);
        System.out.println("Player 2's cards: " + player2);
    }
}
