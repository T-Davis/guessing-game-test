public class GuessingGame {

    public static void main(String[] args) {

        Game game = new Game();
        Prompter prompter = new Prompter(game);
        prompter.setupGame();
        prompter.startGame();
        while (!game.isWon()) {
            prompter.promptForGuess();
            prompter.outcome();

        }
    }
}