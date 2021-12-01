//Создайте приложение для просмотра списка элементов
// – целых чисел (типа Integer) и изменения элементов
// списка в заданном диапазоне индексов. Список
// (10 чисел) является объектом класса  ArrayList.
// Предусмотреть возможность расчета количества
// повторов элементов, для чего использовать HashSet.


package task1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please choose an action:\n" +
                    "\n1 to see all numbers;" +
                    "\n2 to add a new number(10 numbers);" +
                    "\n3 to see a number of duplicates" +
                    "\n0 to exit;");
            int num = scanner.nextInt();
            switch (num) {
                case 1 :{
                    System.out.print("| ");
                    for (Integer number : numbers) {
                        System.out.print(number + " ");
                    }
                    System.out.println("|");
                    break;
                }
                case 2 : {
                    String buffer = scanner.nextLine();
                    if (numbers.size() >= 10) {
                        System.out.println("There are already ten numbers, please choose other option:");
                        break;
                    }
                    System.out.println("Please enter a number to add:");
                    Integer number = scanner.nextInt();

                    numbers.add(number);
                    break;
                }
                case 3 : {
                    System.out.println(numbers.size() - new HashSet<>(numbers).size());
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
