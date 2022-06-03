//Построить программу для работы с классом для хранения
//данных о сообщении на форуме (автор, тема, текст, время,
//дата создания и редактирование). Программа должна обеспечивать
//простейшие функции: ввод значений, редактирование, вывод значений.

package task5;

import java.util.Scanner;

/**
 * Primary class for the Task 5
 */
public class Task_5 {
    /**
     * Function for interaction with the user and showing result of the program
     * @param args parameters are not expected
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please choose an option:\n" +
                    "1 to list all messages;\n" +
                    "2 to add a new message;\n" +
                    "3 to change an existing message;\n" +
                    "0 to exit;");

            int option = scanner.nextInt();
            switch (option) {
                case 1: {
                    MessagesArchive.showMessages();
                    break;
                }
                case 2: {
                    String buffer = scanner.nextLine();
                    System.out.println("Please enter an author's name");
                    String author = scanner.nextLine();
                    System.out.println("Please enter a topic of message");
                    String topic = scanner.nextLine();
                    System.out.println("Please enter a text of message");
                    String text = scanner.nextLine();
                    MessagesArchive.addMessage(author,topic,text);
                    break;
                }
                case 3: {
                    String buffer = scanner.nextLine();
                    System.out.println("Please enter an index of a message you want to change:");
                    int index = scanner.nextInt();
                    buffer = scanner.nextLine();
                    System.out.println("Please enter a new author's name (Press enter to skip)");
                    String author = scanner.nextLine();
                    System.out.println("Please enter a new topic of message (Press enter to skip)");
                    String topic = scanner.nextLine();
                    System.out.println("Please enter a new text of message (Press enter to skip)");
                    String text = scanner.nextLine();
                    MessagesArchive.changeMessage(index, author,topic,text);

                    break;
                }
                case 0: {
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Please choose a valid number");
                    break;
            }
        }
    }
}
