import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputerGuessesPanelTest {

    @Test
    void highGuess(){
        ComputerGuessesPanel c = new ComputerGuessesPanel(0,1000,1,0);
        String base = c.lowerGuess();
        assertEquals("", base);
    }
}
