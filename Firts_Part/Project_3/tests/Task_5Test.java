package task5;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class Task_5Test {

    Task_5 TestObject = new Task_5();
    String strOriginal;
    Integer key;

    @Before
    public void setUp() throws Exception {
        strOriginal = "Message";
        key = 3;
    }

    @Test
    public void ceaser() {
        String expected = TestObject.Ceaser(strOriginal, key);
        String actual = "Phvvdjh";
        assertEquals(expected, actual);
    }
}