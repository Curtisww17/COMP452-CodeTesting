import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class StatsFileTest {

    @Test
    void numGamesTest() {

        LocalDateTime limit = LocalDateTime.parse("2021-02-25T21:45:13.377323200");
        StatsFile statsFile = new StatsFile(limit, "stats-tester.csv");

        assertEquals(1, statsFile.numGames(1));
        assertEquals(3, statsFile.numGames(10));
        assertEquals(2, statsFile.numGames(9));
    }

    @Test
    void maxNumGuessesTest() {

        LocalDateTime limit = LocalDateTime.parse("2021-02-25T21:45:13.377323200");
        StatsFile statsFile = new StatsFile(limit, "stats-tester.csv");

        assertEquals(15, statsFile.maxNumGuesses());
    }

    @Test
    void dateTimeParseExceptionTest() {

        StatsFile statsFile = new StatsFile();
        SortedMap<Integer, Integer> statsMap = new TreeMap<>();
        LocalDateTime limit = LocalDateTime.parse("2021-03-07T17:09:22.122139");
        String[] vals = {"hi this should not work", "9"};

        assertThrows(DateTimeParseException.class, () -> statsFile.filterValues(limit, vals, statsMap));
    }

    @Test
    void numberFormatExceptionTest() {

        StatsFile statsFile = new StatsFile();
        SortedMap<Integer, Integer> statsMap = new TreeMap<>();
        LocalDateTime limit = LocalDateTime.parse("2021-03-07T17:09:22.122139");
        String[] vals = {"2021-02-25T09:42:49.992879200", "hi"};

        assertThrows(NumberFormatException.class, () -> statsFile.filterValues(limit, vals, statsMap));
    }

    @Test
    void filtersOutDatesMoreThan30DaysAgo() {

        StatsFile statsFile = new StatsFile();
        SortedMap<Integer, Integer> statsMap = new TreeMap<>();
        LocalDateTime limit = LocalDateTime.parse("2021-03-07T17:09:22.122139");

        String[] vals = {"2021-01-07T17:09:22.122139", "5"}; //before the limit

        statsFile.filterValues(limit, vals, statsMap);

        assertEquals(0, statsMap.size());

    }

    @Test
    void filterAllowsDatesWithin30Days(){

        StatsFile statsFile = new StatsFile();
        SortedMap<Integer, Integer> statsMap = new TreeMap<>();
        LocalDateTime limit = LocalDateTime.parse("2021-03-07T17:09:22.122139");

        String[] vals = {"2021-03-08T17:09:22.122139", "5"};

        statsFile.filterValues(limit, vals, statsMap);

        assertEquals(1, statsMap.size());
    }

    @Test
    void filterAllowsDatesExactly30DaysAgo() {

        StatsFile statsFile = new StatsFile();
        SortedMap<Integer, Integer> statsMap = new TreeMap<>();
        LocalDateTime limit = LocalDateTime.parse("2021-03-07T17:09:22.122139");

        String[] vals = {"2021-03-07T17:09:22.122139", "5"}; //before the limit

        statsFile.filterValues(limit, vals, statsMap);

        assertEquals(1, statsMap.size());

    }
}