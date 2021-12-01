//Создайте приложение для просмотра списка книг
// и удаления книг в библиотечном каталоге.
// Записи в списке (5 записей) являются объектами
// класса HashMap, где ключом является индекс ISBN
// книги (типа Integer), а значением – объект Book,
// содержащий наименование книги, фамилию, имя и
// отчество (ФИО) автора, издательство (все поля типа String),
// год издания (типа int) и цену книги (типа float).
// Предусмотреть возможность сортировки книг по 2-3 полям.
package task2;

import java.util.*;

public class Task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Book> library = new HashMap<>();
        library.put(1, new Book("Six of Crows", "Leigh Bardugo", "Orion", 2015, 465));
        library.put(2, new Book("The Restaurant at the End of the Universe", "Douglas Adams", "Pan Books", 1980, 300));
        library.put(3, new Book("A Conjuring of Light", "V. E. Schwab", "Titan Books", 2017, 468));
        library.put(4, new Book("The Lord of the Rings", "John Ronald Reuel Tolkien", "HarperCollins Publishers", 2014, 2703));
        library.put(5, new Book("The Smoke Thieves", "Sally Green", "Penguin", 2018, 393));

        while (true) {
            System.out.println("Please choose an action:\n" +
                    "\n1 to see the list of books;" +
                    "\n2 to delete a book by its ISBN;" +
                    "\n3 to see ordered list of books;" +
                    "\n0 to exit;");
            int num = scanner.nextInt();
            switch (num) {
                case 1 : {
                    for (Map.Entry<Integer, Book> entry : library.entrySet()) {
                        System.out.println("ISBN: " + entry.getKey() + " | " + entry.getValue());
                    }
                    break;
                }
                case 2 : {
                    System.out.println("Please enter ISBN of a book you want to delete:");
                    int isbn = scanner.nextInt();
                    library.remove(isbn);
                    break;
                }
                case 3 : {
                    System.out.println("Please choose how would you like to sort books:\n" +
                            "\n1 By their name;" +
                            "\n2 By the name of author" +
                            "\n3 By their price" +
                            "\n0 to exit;");
                    int option = scanner.nextInt();
                    ArrayList<Book> books = new ArrayList<>(library.values());
                    switch (option) {
                        case 1:
                            books.sort(Comparator.comparing(Book::getName));
                            break;
                        case 2:
                            books.sort(Comparator.comparing(Book::getAuthorName));
                            break;
                        case 3:
                            books.sort(Comparator.comparing(Book::getPrice));
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("You've chosen an invalid option.");
                    }
                    for (Book book : books) {
                        System.out.println(book);
                    }
                    break;
                }
                case 0 : {
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Please, enter a number which is present in menu.");
                    break;
            }
        }
    }
}

