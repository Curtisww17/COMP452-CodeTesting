import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


public class HumanGuessesGameTest {

    @Test
    void goodInit() {
        HumanGuessesGame hgg = new HumanGuessesGame();
        assertFalse(hgg.isDone());
        assertEquals(0, hgg.getNumGuesses());
    }

    @Test
    void makeGuessTest() {
        //using dependency injection
        HumanGuessesGame hgg = new HumanGuessesGame(new RandomDouble(500));
        assertEquals(hgg.makeGuess(500), GuessResult.LOW);
        assertEquals(hgg.makeGuess(502), GuessResult.HIGH);
        assertEquals(hgg.makeGuess(0), GuessResult.LOW);
        assertEquals(hgg.makeGuess(1000), GuessResult.HIGH);
        assertEquals(hgg.makeGuess(501), GuessResult.CORRECT);
    }

    @Test
    void isDoneTest() {
        //using dependency injection
        HumanGuessesGame hgg = new HumanGuessesGame(new RandomDouble(500));
        assertFalse(hgg.isDone());
        assertEquals(hgg.makeGuess(501), GuessResult.CORRECT);
        assertTrue(hgg.isDone());
    }

    @Test
    void numGuessesTest() {
        HumanGuessesGame hgg = new HumanGuessesGame();
        for (int i = 0; i < 5; i++) {
            assertEquals(i, hgg.getNumGuesses());
            hgg.makeGuess(-1);
        }
    }
}
