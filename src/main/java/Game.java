public class Game {

    private Jar jar;
    private int guess;
    private int numGuesses;


    public boolean applyGuess(int guess) {
        if (guess > jar.getMaxNumItems()) {
            throw new IllegalArgumentException("Your guess must be less than " + jar.getMaxNumItems());
        }
        return true;
    }

    public boolean isWon() {
        return guess == jar.getNumItems();
    }

    public void setJar(Jar jar) {
        this.jar = jar;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public int getNumGuesses() {
        return numGuesses;
    }

    public void setNumGuesses(int numGuesses) {
        this.numGuesses = numGuesses;
    }
}