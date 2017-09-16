import java.util.Scanner;

public class Prompter {

    private Game game;
    private Jar jar;
    private Scanner scanner;

    public Prompter(Game game) {
        this.game = game;
        this.scanner = new Scanner(System.in);
    }

    public void setupGame() {
        String itemName;
        int maxNumItems;

        System.out.printf("ADMINISTRATOR SETUP %n");
        System.out.println("===================== ");

        System.out.print("What type of item? ");
        itemName = scanner.nextLine();

        System.out.printf("What is the maximum amount of %s? ", itemName);
        maxNumItems = scanner.nextInt();
        System.out.println();
        jar = new Jar(itemName, maxNumItems);
        jar.fill();
        game.setJar(jar);
    }

    public void startGame() {
        System.out.println("PLAYER");
        System.out.println("========");
        System.out.printf("How many %s are in the jar? " +
                        "Pick a number between 1 and %d %n",
                        jar.getItemName(), jar.getMaxNumItems());
        System.out.printf("Ready? Start Guessing! %n");
    }

    public void promptForGuess() {
        boolean isAcceptable = false;
        int guess;

        do {
            System.out.print("Guess: ");
            guess = scanner.nextInt();

            try {
                isAcceptable = game.applyGuess(guess);
            } catch (IllegalArgumentException iae) {
                System.out.printf("%s. Please try again. %n", iae.getMessage());
            }

        } while (!isAcceptable);

        game.setGuess(guess);
        game.setNumGuesses((game.getNumGuesses() + 1));
    }


    public void outcome() {
        if (game.isWon()) {
            int guesses = game.getNumGuesses();

            if (guesses == 1) {
                System.out.printf("Congratulations - You guessed that there are %d %s in the jar! " +
                                "You got it in %d attempt. %n",
                        jar.getNumItems(), jar.getItemName(), guesses);
            } else {
                System.out.printf("Congratulations - You guessed that there are %d %s in the jar! " +
                                "You got it in %d attempts. %n",
                        jar.getNumItems(), jar.getItemName(), guesses);
            }

        } else if (game.getGuess() < jar.getNumItems()) {
            System.out.printf("Your guess is too low %n");
        } else if (game.getGuess() > jar.getNumItems()) {
            System.out.printf("Your guess is too high %n");
        }
    }

}