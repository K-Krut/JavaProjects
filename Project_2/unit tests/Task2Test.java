package task2;

import static junit.framework.TestCase.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Task2Test {

    Task2 TestObject = new Task2();

    ArrayList<Integer> arrA = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        arrA = new ArrayList<>(Arrays.asList(1, 3, 3, 5, 7));
    }
    @Test
    public void repeatedNumber(){
        boolean  expected = TestObject.repeatedNumber(arrA);
        assertEquals(expected, false);
    }
}