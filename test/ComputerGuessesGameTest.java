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

        assertEquals(2, g.getNumGuesses());
        assertEquals(377, g.getLastGuess());
    }


    @Test
    void k(){
        ComputerGuessesGame g = new ComputerGuessesGame();

    }
}
