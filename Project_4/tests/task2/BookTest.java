package task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book TestObject = new Book();
    Book book1 =  new Book("Six of Crows", "Leigh Bardugo", "Orion", 2015, 465);
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void get_setName() {
        TestObject.setName("Six of Crows");
        assertEquals(TestObject.getName(), "Six of Crows");
    }

    @Test
    void get_setAuthorName() {
        TestObject.setAuthorName("Leigh Bardugo");
        assertEquals(TestObject.getAuthorName(), "Leigh Bardugo");
    }

    @Test
    void get_setPublisher() {
        TestObject.setPublisher("Orion");
        assertEquals(TestObject.getPublisher(), "Orion");
    }


    @Test
    void get_setPublishingYear() {
        TestObject.setPublishingYear(2015);
        assertEquals(TestObject.getPublishingYear(), 2015);
    }

    @Test
    void get_setPrice() {
        TestObject.setPrice(465);
        assertEquals(TestObject.getPrice(), 465);
    }

    @Test
    void testToString() {
        String actual = "Book: name='Six of Crows', authorName='Leigh Bardugo', publisher='Orion', publishingYear=2015, price=465.0";
        assertEquals(actual, book1.toString());
    }
}