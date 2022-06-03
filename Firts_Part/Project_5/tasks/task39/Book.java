package task39;

import java.util.Objects;

/**
 * Class that represents Book
 */
public class Book {

    private String title;
    private String author;
    private int year;
    private int printCirculation;
    private int pages;

    /**
     * Constructor of the Book clas with no parameters
     */
    public Book() {

    }

    /**
     * Constructor of the Book class
     * @param title -- title of the book
     * @param author -- author of the book
     * @param year -- year of the book publishing
     * @param printCirculation -- circulation of the book publishing
     * @param pages - amount of the pages in teh book
     */
    public Book(String title, String author, int year, int printCirculation, int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.printCirculation = printCirculation;
        this.pages = pages;
    }

    /**
     * Method for comparison Book objects
     * @param o - Student object
     * @return bool
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return year == book.year && printCirculation == book.printCirculation
                && pages == book.pages && title.equals(book.title) && author.equals(book.author);
    }
    /**
     * Method for hashing Book object
     * @return int -- hash code of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, author, year, printCirculation, pages);
    }

    /**
     * Method for printing Book object
     * @return string representative
     */
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", printCirculation=" + printCirculation +
                ", pages=" + pages +
                '}';
    }
}
