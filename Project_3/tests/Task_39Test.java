package task39;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class Task_39Test {
    Task_39 TestObject = new Task_39();
    List<String> listB = new ArrayList<>();
    String str2;

    @Before
    public void setUp() throws Exception {
        str2 = "2F6";
        listB = Arrays.asList("2", "F", "6");
    }

    @Test
    public void convertingToList() {
        List<String> expected = TestObject.ConvertingToList(str2);
        List<String> actual = new ArrayList<>(Arrays.asList("2", "F", "6"));
        assertEquals(expected, actual);
    }
    
//    public static boolean Cheking(String strHex) {
//        List<String> list = ConvertingToList("0123456789ABCDEFabcdef");
//        List<String> listTemp = ConvertingToList(strHex);
//        return list.containsAll(listTemp);
//    }
    
    @Test
    public void cheking() {
        boolean expected = TestObject.Cheking(str2);
//        boolean actual = true;
        assertEquals(expected, true);
    }

    @Test
    public void convertingDemical() {
        Integer expected = TestObject.ConvertingDemical(str2);
        Integer actual = 758;
        assertEquals(expected, actual);
    }

    @Test
    public void main() {

    }
}
