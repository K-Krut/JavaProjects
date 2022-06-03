// Создайте базовый класс Книга (название, автор(ы),
// год издания, тираж, кол-во страниц).
// Производный класс – Книга в библиотеке (инвентарный номер, кто взял).

package task39;

/**
 * Primary class for teh Task 39
 */
public class Task_39 {
    /**
     * Function for showing the result of the program running
     * @param args parameters are not expected
     */
    public static void main(String[] args) {
        Book Book_1 = new Book("Gone with the Wind", "Margaret Mitchell",
                1936, 30000000, 1037);
        BookInLibrary BookInLibrary_1 = new BookInLibrary( "Gone with the Wind", "Margaret Mitchell",
                1936, 30000000, 1037, 5453457, "John");

        System.out.println(Book_1);
        System.out.println(BookInLibrary_1);
    }
}
