import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class HumanGuessesGameTest {

    @Test
    void makeGuessTest() {

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
