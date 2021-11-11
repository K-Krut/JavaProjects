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

//        {
//            @Override
//            public int size() {
//                return 0;
//            }
//
//            @Override
//            public boolean isEmpty() {
//                return false;
//            }
//
//            @Override
//            public boolean contains(Object o) {
//                return false;
//            }
//
//            @Override
//            public Iterator<String> iterator() {
//                return null;
//            }
//
//            @Override
//            public Object[] toArray() {
//                return new Object[0];
//            }
//
//            @Override
//            public <T> T[] toArray(T[] a) {
//                return null;
//            }
//
//            @Override
//            public boolean add(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean remove(Object o) {
//                return false;
//            }
//
//            @Override
//            public boolean containsAll(Collection<?> c) {
//                return false;
//            }
//
//            @Override
//            public boolean addAll(Collection<? extends String> c) {
//                return false;
//            }
//
//            @Override
//            public boolean addAll(int index, Collection<? extends String> c) {
//                return false;
//            }
//
//            @Override
//            public boolean removeAll(Collection<?> c) {
//                return false;
//            }
//
//            @Override
//            public boolean retainAll(Collection<?> c) {
//                return false;
//            }
//
//            @Override
//            public void clear() {
//
//            }
//
//            @Override
//            public String get(int index) {
//                return null;
//            }
//
//            @Override
//            public String set(int index, String element) {
//                return null;
//            }
//
//            @Override
//            public void add(int index, String element) {
//
//            }
//
//            @Override
//            public String remove(int index) {
//                return null;
//            }
//
//            @Override
//            public int indexOf(Object o) {
//                return 0;
//            }
//
//            @Override
//            public int lastIndexOf(Object o) {
//                return 0;
//            }
//
//            @Override
//            public ListIterator<String> listIterator() {
//                return null;
//            }
//
//            @Override
//            public ListIterator<String> listIterator(int index) {
//                return null;
//            }
//
//            @Override
//            public List<String> subList(int fromIndex, int toIndex) {
//                return null;
//            }
//
//        }
