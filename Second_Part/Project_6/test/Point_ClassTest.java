import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class Point_ClassTest {

    Point_Class TestObject = new Point_Class();


    @Test
    void getX() {
        TestObject.setX(3);
        assertEquals(TestObject.getX(), 3);
        assertNotEquals(TestObject.getX(), 5);
    }

    @Test
    void getY() {
        TestObject.setY(6);
        assertEquals(TestObject.getY(), 6);
        assertNotEquals(TestObject.getY(), 5);
    }

    @Test
    void setX() {
        TestObject.setX(7);
        assertEquals(7, TestObject.getX());
        assertNotEquals(9.4, TestObject.getX());
    }

    @Test
    void setY() {
        TestObject.setY(5.5);
        assertEquals(5.5, TestObject.getY());
        assertNotEquals(9.4, TestObject.getY());
    }


    @Test
    void moving() {
        TestObject.setX(3);
        TestObject.setY(4);
        TestObject.moving(1, 3);
        assertEquals(new Point_Class(4, 7), TestObject);
        assertNotEquals(new Point_Class(3, 4), TestObject);
    }

    @Test
    void testToString() {

        TestObject.setX(3);
        TestObject.setY(4);

        assertEquals("point {x = 3.0; y = 4.0}", TestObject.toString());
        assertNotEquals("point {x = 3.0; y = 4.0", TestObject.toString());
    }

}