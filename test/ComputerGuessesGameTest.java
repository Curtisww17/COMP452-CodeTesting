import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputerGuessesGameTest {
    @Test
    void guessTest(){
        ComputerGuessesGame g = new ComputerGuessesGame();

        assertEquals(501, g.guess());
        //lower
        assertEquals(251, g.lower());
        //higher
        assertEquals(377, g.higher());

        assertEquals(3, g.getNumGuesses());
        assertEquals(377, g.getLastGuess());
    }

    @Test
    void boundsTest(){
        ComputerGuessesGame g = new ComputerGuessesGame();

        for (int i = 0; i < 8; i++) {
            g.higher();
        }

        assertEquals(1000, g.higher());

        g = new ComputerGuessesGame();

        for (int i = 0; i < 8; i++) {
            g.lower();
        }
        assertEquals(1, g.lower());
    }
}
