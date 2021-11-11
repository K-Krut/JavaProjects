package task3;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static junit.framework.TestCase.assertEquals;

public class Task_3Test {

    Task_3 TestObject = new Task_3();
    int min, max, step;
    String actual;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();


    @Before
    public void setUp() throws Exception {
        min = 1; max = 11; step = 2;
        actual =  "1. 1->1\n" +
                    "2. 3->3\n" +
                    "3. 5->5\n" +
                    "4. 7->7\n" +
                    "5. 9->9\n";
        System.setOut(new PrintStream(output));
    }

    @Test
    public void printTable() {
        TestObject.PrintTable(min, max, step);
        assertEquals(actual, output.toString());
    }
}
