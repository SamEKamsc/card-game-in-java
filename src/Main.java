import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        intro();
    }

    public static void intro() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("----Welcome to Scoundrel----");
            System.out.println("1. Play");
            System.out.println("2. Rules");
            System.out.println("3. Exit");
            boolean invalid = true;
            int choice = 1;
            while (invalid) {
                System.out.print("Enter your choice:  ");
                try {
                    choice = sc.nextInt();
                    if (choice > 3 || choice <= 0) {
                        System.out.println("Please enter a number in range");
                    }
                    else {
                        invalid = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a number");
                    sc.nextLine();
                }
            }
            switch (choice) {
                case 1:
                    play();
                    break;
                case 2:
                    rules();
                    break;
                case 3:
                    running = false;
                    System.out.println("Thanks for Playing!");
                    break;
            }
        }
    }

    public static void rules() {
        System.out.println("---Rules---");
        System.out.println("Each turn there are four cards revealed");
        System.out.println("You must choose one card and perform an action on it based on the suit.");
        System.out.println("The different suits mean different things:");
        System.out.println(" -Hearts: Heal you the card value");
        System.out.println(" -Diamonds: Is stored as a weapon to reduce monster damage equal to its card value");
        System.out.println(" -Spades / Clubs: these are monsters and they deal damage to you equal to their value.");
        System.out.println(" Note: after fighting a monster with a weapon, can only, in the future, fight monsters with value less than the most recently fought monster.");
        System.out.println(" Plot Twist: There is one bomb for each suit. The bomb clears all revealed cards.");
    }
    
    public static void play() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Welcome the Scoundrel\nEnter your name:  ");

        // INIT
        Player player = new Player(sc.nextLine());
        Deck deck = new Deck();
        deck.build();
        deck.shuffle();
        ArrayList<Card> flipped = new ArrayList<>();

        //Game loop
        boolean running = true;
        while (running) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            // flip cards till there are four
            while (flipped.size() < 4 && !deck.deck.isEmpty()) {
                flipped.add(deck.draw());
            }
            if (deck.deck.isEmpty() && flipped.isEmpty()) {
                System.out.println("YOU WIN");
                break;

            }
            System.out.println("=========="+player.name + "'s stats==========");
            System.out.println("-Health: " + player.health);
            System.out.println("-Weapon Stack: " + player.print_weapon_stack());

            // print them
            System.out.println("==========ROOM==========");
            for (Card card : flipped) {
                System.out.print("| (" + (flipped.indexOf(card)+1) + ") " + card.get() + " |");
            }
            System.out.println();
            // display option menu
            System.out.println("==========Choose a Card=========");
            boolean invalid = true;
            int choice = 1;
            while (invalid) {
                System.out.print("Enter your choice:  ");
                try {
                    choice = sc.nextInt();
                    if (choice > 4 || choice <= 0) {
                        System.out.println("Please enter a number in range");
                    }
                    else {
                        invalid = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a number");
                    sc.nextLine();
                }
            }
            // let player choose
            Card card = flipped.get(choice-1);
            flipped.remove(choice-1);
            //do the effect
            if (card.value == 15) {
                System.out.println("You set off the Bomb.");
                flipped.clear();
            }
            else if (card.suit.equals("Spades") || card.suit.equals("Clubs")) {
                if (!player.fight(card)) {
                    System.out.println("You Died. There were " + deck.deck.size() + " cards left");
                    break;
                }
            }
            else if (card.suit.equals("Hearts")) {
                player.take_pot(card.value);
            }
            else {
                player.take_weapon(card);
            }
        }
    }
}