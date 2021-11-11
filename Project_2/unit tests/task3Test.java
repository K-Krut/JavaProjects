package task3;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;


public class task3Test {
    task3 TestObject = new task3();
    int[] arr;
    @Before
    public void setUp() throws Exception {
        arr = new int[]{1, 2, 5, 5, 3};
    }

    @Test
    public void checkFunction() {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Map<Integer, Integer> map3 = new HashMap<>();
        map1.put(1, 0);
        map2.put(2, 1);
        map3.put(3, 4);
        ArrayList<Map<Integer, Integer>> actual = new ArrayList<>();
        actual.add(map1);
        actual.add(map2);
        actual.add(map3);
        ArrayList<Map<Integer, Integer>> expected = TestObject.checkFunction(arr);
        assertEquals(expected, actual);

    }
}