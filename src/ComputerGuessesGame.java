public class ComputerGuessesGame {
    private int numGuesses;
    private int lastGuess;

    public int getNumGuesses() {
        return numGuesses;
    }

    public int getLastGuess() {
        return lastGuess;
    }

    // upperBound and lowerBound track the computer's knowledge about the correct number
    // They are updated after each guess is made
    private int upperBound; // correct number is <= upperBound
    private int lowerBound; // correct number is >= lowerBound

    public ComputerGuessesGame(){
        numGuesses = 0;
        upperBound = 1000;
        lowerBound = 1;
    }

    public ComputerGuessesGame(int ng, int lg){
        numGuesses = ng;
        upperBound = 1000;
        lowerBound = 1;
        lastGuess = lg;
    }

    public int lower(){
        upperBound = Math.min(upperBound, lastGuess);
        numGuesses += 1;

        return guess();
    }

    public int higher(){
        lowerBound = Math.max(lowerBound, lastGuess + 1);
        numGuesses += 1;

        return guess();
    }

    public int guess(){
        lastGuess = (lowerBound + upperBound + 1) / 2;


        return lastGuess;
    }
}
