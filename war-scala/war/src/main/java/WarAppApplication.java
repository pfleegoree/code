import java.util.*;

public class WarAppApplication {

    public static void main(String[] args) {
        // Making a list of cards
        List<String> list = new ArrayList<>(List.of(
                "AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "JH", "QH", "KH",
                "AD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "JD", "QD", "KD",
                "AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "JC", "QC", "KC",
                "AS", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "10S", "JS", "QS", "KS"
        ));

        // Each player gets a variable number of cards
        Random rand = new Random();

        // Shuffle the deck
        Collections.shuffle(list);

        // Generate a random number of cards for player1
        int player1CardCount = rand.nextInt(list.size() / 2) + 1;
        List<String> playerList1 = new ArrayList<>(list.subList(0, player1CardCount));

        // Remove the cards given to player1 from the deck
        list.subList(0, player1CardCount).clear();

        // Assign the remaining cards to player2
        List<String> playerList2 = new ArrayList<>(list);

        // Create player decks
        Deque<String> player1 = new ArrayDeque<>(playerList1);
        Deque<String> player2 = new ArrayDeque<>(playerList2);
        Deque<String> warPile = new ArrayDeque<>();

        System.out.println("Player 1's cards: " + player1);
        System.out.println("Player 2's cards: " + player2);

        // Game loop
        while (!player1.isEmpty() && !player2.isEmpty()) {
            String card1 = player1.pollLast();
            String card2 = player2.pollLast();
            System.out.println("Player 1 card: " + card1);
            System.out.println("Player 2 card: " + card2);

            int value1 = getCardValue(card1);
            int value2 = getCardValue(card2);

            if (value1 == value2) {
                System.out.println("War!");
                warPile.push(card1);
                warPile.push(card2);

                // Add additional cards to war pile if both players have enough cards
                int count = 3; // Number of cards to add to war pile
                for (int i = 0; i < count; i++) {
                    if (!player1.isEmpty()) warPile.push(player1.pollLast());
                    if (!player2.isEmpty()) warPile.push(player2.pollLast());
                }
            }

            if (value1 > value2) {
                player1.push(card1);
                player1.push(card2);
                player1.addAll(warPile);
                warPile.clear();
                System.out.println("Player 1 wins this round!");
            } else if (value2 > value1) {
                player2.push(card1);
                player2.push(card2);
                player2.addAll(warPile);
                warPile.clear();
                System.out.println("Player 2 wins this round!");
            }

            // Display current piles
            System.out.println("Player 1 pile: " + player1);
            System.out.println("Player 2 pile: " + player2);
        }

        // Final result
        if (player1.isEmpty()) {
            System.out.println("Player 2 wins the game!");
        } else {
            System.out.println("Player 1 wins the game!");
        }
    }

    // Converting card rank to a numeric value
    private static int getCardValue(String card) {
        String rank = card.length() == 3 ? "10" : card.substring(0, 1);
        return switch (rank) {
            case "A" -> 14; // Ace
            case "K" -> 13; // King
            case "Q" -> 12; // Queen
            case "J" -> 11; // Jack
            case "10" -> 10; // Ten
            default -> Integer.parseInt(rank); // 2-9
        };
    }
}
