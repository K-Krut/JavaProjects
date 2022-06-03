//Создайте приложение для просмотра списка файлов
// и добавления файла в список.  Список (для 5
// текстовых файлов с расширением .txt) создается
// в программе и является объектом класса HashMap,
// где ключом является имя файла (типа String),
// а значением – объект типа TextFile, содержащий
// два элемента String – абсолютный путь к файлу
// (без имени файла) и краткое описание содержимого файла.

package task4;

import java.util.*;

public class Task_4 {
    public static void main(String[] args) {

        HashMap<String,TextFile> files = new HashMap<>();
        files.put("song.txt", new TextFile("C:\\Program Files", "Song lyrics"));
        files.put("lab.txt", new TextFile("C:\\my_tasks\\homework\\","Task description"));

        System.out.println(new TextFile("C:\\Program Files", "Song lyrics"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please choose an action:\n" +
                    "\n1 to see all files;" +
                    "\n2 to add a new file;" +
                    "\n0 to exit;");
            int num = scanner.nextInt();
            switch (num) {
                case 1 : {
                    for (Map.Entry<String, TextFile> entry : files.entrySet()) {
                        System.out.println("File: " + entry.getKey() +  " " + entry.getValue());
                    }
                    break;
                }
                case 2 : {
                    String buffer = scanner.nextLine();
                    if (files.size() >= 5) {
                        System.out.println("There are already five files stored, please choose other option:");
                        break;
                    }
                    System.out.println("Please enter a file name:");
                    String fileName = scanner.nextLine();

                    System.out.println("Please enter a file's absolute path:");
                    String filePath = scanner.nextLine();

                    System.out.println("Please enter a file's description:");
                    String fileDescription = scanner.nextLine();
                    files.put(fileName, new TextFile(filePath, fileDescription));
                    break;
                }
                case 0 : {
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Please, enter a valid number.");
                    break;
            }
        }
    }
}
