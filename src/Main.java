import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.build(1);
        deck.print();

        //intro();
    }

    public static void intro() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("----Welcome to Scoundrel----");
            System.out.println("1. Play");
            System.out.println("2. Rules");
            System.out.println("3. Exit");
            System.out.print("Enter your choice:  ");
            int choice = sc.nextInt();
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
    }
    public static void play() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome the Scoundrel\nEnter your name:  ");

        // INIT
        Player player = new Player(sc.nextLine());
        Deck weapon_deck = new Deck();
        weapon_deck.build(2);
        Deck enemy_deck = new Deck();
        enemy_deck.build(1);
        Deck pot_deck = new Deck();
        pot_deck.build(3);

        //Game loop
        boolean running = true;
        while (running) {
            System.out.println("==========\n"+player.name + "'s stats");
            System.out.println(" -Health: " + player.health);
            System.out.println("==========");
        }
    }
}