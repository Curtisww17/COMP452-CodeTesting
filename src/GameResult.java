import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Data class to hold the result of a game
 * NOTE: You can refactor and edit this file if needed
 */
public class GameResult {
    public final boolean humanWasPlaying;
    public final int correctValue;
    public final int numGuesses;

    public GameResult(boolean humanWasPlaying, int correctValue, int numGuesses){
        this.humanWasPlaying = humanWasPlaying;
        this.correctValue = correctValue;
        this.numGuesses = numGuesses;
    }


    public static void writeResultToFile(GameResult result) {

        // write stats to file
        try(CSVWriter writer = new CSVWriter(new FileWriter(StatsFile.FILENAME, true))) {

            String [] record = new String[2];
            record[0] = LocalDateTime.now().toString();
            record[1] = Integer.toString(result.numGuesses);

            writer.writeNext(record);
        } catch (IOException e) {
            // NOTE: In a full implementation, we would log this error and possibly alert the user
            // NOTE: For this project, you do not need unit tests for handling this exception.
        }
    }
}
