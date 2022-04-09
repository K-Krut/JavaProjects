import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class RectangularTest {

    Rectangular TestObject = new Rectangular();
    Rectangular Rectangle_ = new Rectangular(4, 9, 8.5, 7);



    @Test
    void Rectangular() {
        assertEquals(Rectangle_, new Rectangular(Rectangle_));
        Rectangular KEK = new Rectangular(4, 5, 6, 8);
        assertNotEquals(KEK, new Rectangular(Rectangle_));
    }


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

    @Test
    void setWidth() {
        TestObject.setWidth(8.9);
        assertEquals(8.9, TestObject.getWidth());
        assertNotEquals(2, TestObject.getWidth());
    }


    @Test
    void setHeight() {
        TestObject.setHeight(5);
        assertEquals(5, TestObject.getHeight());
        assertNotEquals(9, TestObject.getHeight());
    }

    @Test
    void area() {
        assertEquals(59.5, Rectangle_.area());
        assertNotEquals(64.9, Rectangle_.area());
    }

    @Test
    void perimeter() {
        assertEquals(31, Rectangle_.perimeter());
        assertNotEquals(69, Rectangle_.perimeter());
    }

    @Test
    void isEmpty() {
        assertFalse(Rectangle_.isEmpty());
        assertNotEquals(true, Rectangle_.isEmpty());
    }

    @Test
    void contains() {
        assertTrue(Rectangle_.contains(5, 12));
        assertFalse(Rectangle_.contains(2, 12));
    }

    @Test
    void moving() {
        Rectangle_.moving(1, 3);
        assertEquals(new Rectangular(5, 12, 8.5, 7), Rectangle_);
        assertNotEquals(new Rectangular(3, 4, 8.5, 7), Rectangle_);
    }

    @Test
    void testToString() {
        assertEquals("Rectangular {height = 8.5, width = 7.0}", Rectangle_.toString());
        assertNotEquals("Rectangular {height = 8.5, width = 7}", Rectangle_.toString());
    }

    @Test
    void testEquals() {
        assertEquals(new Rectangular(4, 9, 8.5, 7), Rectangle_);
        assertNotEquals(new Rectangular(52, 9, 8.5, 7), Rectangle_);
    }
}



