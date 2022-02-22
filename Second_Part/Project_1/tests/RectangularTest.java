import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class RectangularTest {

    Rectangular TestObject = new Rectangular();
    Rectangular Rectangle = new Rectangular(4, 9, 8.5, 7);

//    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
//
//    @BeforeEach
//    void setUp() {
//        System.setOut(new PrintStream(output));
//    }

    @Test
    void getHeight() {
        TestObject.setHeight(7.9);
        assertEquals(7.9, TestObject.getHeight());
        assertNotEquals(2.9, TestObject.getHeight());
    }

    @Test
    void getWidth() {
        TestObject.setWidth(5);
        assertEquals(5, TestObject.getWidth());
        assertNotEquals(2.9, TestObject.getWidth());
    }

    /*
        @Test
        void setWidth() {
        }


        @Test
        void setHeight() {
        }



    @Test
    void area() {
        TestObject.setX(9);
        TestObject.setY(4);
        assertEquals(36, TestObject.area());
        assertNotEquals(64.9, TestObject.area());
    }

     */

    @Test
    void area() {
        assertEquals(59.5, Rectangle.area());
        assertNotEquals(64.9, Rectangle.area());
    }

    @Test
    void perimeter() {
        assertEquals(31, Rectangle.perimeter());
        assertNotEquals(69, Rectangle.perimeter());
    }

    @Test
    void isEmpty() {
        assertFalse(Rectangle.isEmpty());
        assertNotEquals(true, Rectangle.isEmpty());
    }

    @Test
    void contains() {
        assertTrue(Rectangle.contains(5, 12));
        assertFalse(Rectangle.contains(2, 12));
    }

    @Test
    void moving() {
        Rectangle.moving(1, 3);
        assertEquals(new Rectangular(5, 12, 8.5, 7), Rectangle);
        assertNotEquals(new Rectangular(3, 4, 8.5, 7), Rectangle);
    }

    @Test
    void testToString() {
        assertEquals("Rectangular {height = 8.5, width = 7.0}", Rectangle.toString());
        assertNotEquals("Rectangular {height = 8.5, width = 7}", Rectangle.toString());
    }

    /*

    @Test
    void testEquals() {
    }

    @Test
    void testClone() {
    }

    @Test
    void testHashCode() {
    }

     */
}