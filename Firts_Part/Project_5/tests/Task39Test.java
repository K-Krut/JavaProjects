package task5;

import org.junit.Test;
import task39.BookInLibrary;
import task39.Book;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Task39Test {

    private Book book = new Book("Lord of the Rings", "J.R. Tolkien", 1954, 150_000_000, 1137);
    private BookInLibrary bookInLibrary = new BookInLibrary("Some other book", "Some author",2010,
            150_500,111,145L, "James Carter");

    @Test
    public void checkThatBooksAreNotTheSame() {
        assertNotEquals(book, bookInLibrary);
    }

    @Test
    public void checkStudentsEquality() {
        Book bookOne = book;
        assertEquals(book, bookOne);
    }

    @Test
    public void checkGraduateAndStudentWithSameDataEquality() {
        BookInLibrary bookOne = new BookInLibrary("Lord of the Rings", "J.R. Tolkien", 1954, 150_000_000, 1137);
        assertEquals(book, bookOne);
        assertNotEquals(bookOne, book);
    }
}
