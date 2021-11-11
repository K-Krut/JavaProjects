package task1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class Task1Test {

    Task1 TestObject = new Task1();
    ArrayList<Integer> arrA = new ArrayList<>();
    ArrayList<Integer> arrB = new ArrayList<>();
    ArrayList<Integer> arrC = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        arrA = new ArrayList<> (Arrays.asList(1, 3, 6, 82, 12, 31, 14, 5, 8));

    }

    @Test
    public void modification() {
        ArrayList<Integer> expected = TestObject.modification(arrA, arrB, arrC);
        ArrayList<Integer> actual = new ArrayList<> (Arrays.asList(6, 8, 12, 14, 82, 31, 5, 3, 1));
        assertEquals(expected, actual);
    }
}