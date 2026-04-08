import java.util.ArrayList;
import java.util.Arrays;

public class Card {
    int value;
    String suit;

    Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    // Prints the cards, the numbers that aren't cards become the card names like 11 == jack
    public String get() {
        String[] special_name = {"Jack", "Queen", "King", "Ace"};
        ArrayList<Integer> special_value = new ArrayList<>(Arrays.asList(11, 12, 13, 14));
        if (special_value.contains(value)) {
            return special_name[special_value.indexOf(value)] + " of " + suit;
        }
        else {
            return value + " of " + suit;
        }
    }
}
