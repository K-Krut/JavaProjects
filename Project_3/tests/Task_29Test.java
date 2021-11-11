package task29;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static junit.framework.TestCase.assertEquals;

public class Task_29Test {

    Task_29 TestObject = new Task_29();
    String args[] = {"h", "hi", "ап", "87", "lo", "o", "hello"};

    String actual;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        actual =  "hi true\n"+
                "ап false\n"+
                "87 false\n"+
                "lo false\n" +
                "o false\n" +
                "hello true\n";

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void checking() {
        TestObject.checking(args);
        assertEquals(outputStreamCaptor.toString(), actual);
    }
}