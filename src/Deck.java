import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();

    // Builds the decks {{TYPE 1 == ENEMIES, TYPE 2 == WEAPONS, TYPE 3 == POTS}}
    public void build(int type) {
        if (type==1) {
            String[] suits = {"Spades", "Clubs"};
            for (String suit : suits) {
                for (int i = 2; i <= 14; i++) {
                    deck.add(new Card(i, suit));
                }
            }
        }
        else if (type==2) {
            for (int i = 2; i <= 14; i++) {
                deck.add(new Card(i, "Diamonds"));
            }
        }
        else if (type==3) {
            for (int i = 2; i <= 14; i++) {
                deck.add(new Card(i, "Hearts"));
            }
        }
    }

    // Ts prints each card in the deck for debugging
    public void print() {
        for (Card card : deck) {
            card.print();
        }
    }
}
