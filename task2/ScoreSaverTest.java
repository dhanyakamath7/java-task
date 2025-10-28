 package studentlogger;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.nio.file.*;

public class ScoreSaverTest {
    private final String testFile = "test_data.csv";

    @BeforeEach
    void clearFile() throws Exception {
        Files.deleteIfExists(Paths.get(testFile));
    }

    @Test
    void testIfScoreIsWritten() throws Exception {
        StudentInfo s = new StudentInfo("Tester", 1, 100);
        ScoreSaver saver = new ScoreSaver(s, testFile);
        Thread t = new Thread(saver, "JUnit-Thread");

        t.start();
        t.join();

        String data = Files.readString(Paths.get("student_scores.csv"));
        assertTrue(data.contains("Tester,1,100"));
    }
}

