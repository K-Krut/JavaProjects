package task39;

import java.util.Objects;

/**
 * Class that implements a library operation with a book
 * extends Book class
 */
public class BookInLibrary extends Book {

    private long id;
    private String nameWhoBorrowed;

    /**
     * Constructor of the BookInLibrary
     */
    public BookInLibrary() {

    }

    /**
     * Constructor of the BookInLibrary class
     * @param id -- inventory id of a book
     * @param nameWhoBorrowed - name of the reader
     */
    public BookInLibrary(long id, String nameWhoBorrowed) {
        this.id = id;
        this.nameWhoBorrowed = nameWhoBorrowed;
    }

    /**
     * Constructor of the BookInLibrary class
     * @param title -- title of the book
     * @param author -- author of the book
     * @param year -- year of publishing the book
     * @param printCirculation -- circulation of the book
     * @param pages - amunt of teh pages in the book
     */
    public BookInLibrary(String title, String author, int year, int printCirculation, int pages) {
        super(title, author, year, printCirculation, pages);
    }

    /**
     *
     * Constructor of the BookInLibrary class
     * @param title -- title of the book
     * @param author -- author of the book
     * @param year -- year of publishing the book
     * @param printCirculation -- circulation of the book
     * @param pages - amunt of teh pages in the book
     * @param id -- inventory id of a book
     * @param nameWhoBorrowed - name of the reader
     */
    public BookInLibrary(String title, String author, int year, int printCirculation, int pages, long id, String nameWhoBorrowed) {
        super(title, author, year, printCirculation, pages);
        this.id = id;
        this.nameWhoBorrowed = nameWhoBorrowed;
    }

    /**
     * Method for comparison BookInLibrary objects
     * @param o - Student object
     * @return bool
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookInLibrary)) return false;
        if (!super.equals(o)) return false;
        BookInLibrary that = (BookInLibrary) o;
        return id == that.id && nameWhoBorrowed.equals(that.nameWhoBorrowed);
    }

    /**
     * Method for hashing BookInLibrary object
     * @return int -- hash code of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, nameWhoBorrowed);
    }

    /**
     * Method for printing BookInLibrary object
     * @return string representative
     */
    @Override
    public String toString() {
        return "BookInLibrary{" +
                "id=" + id +
                ", nameWhoBorrowed='" + nameWhoBorrowed + '\'' +
                "} " + super.toString();
    }
}
