//Вывести таблицу преобразований целых десятичных чисел
//в интервале от min до max с шагом step в 16-ном представлении.
//Параметры задачи вводятся пользователем в ходе
//диалога с программой за один раз.


package task3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task_3 {
    public static void PrintTable(int min, int max, int step) {
        for (int j = 1, i = min; i < max; i += step, ++j) {
            System.out.format("%d. %d->%x\n", j, i, i);
//            if (j % 2 == 0)
//                System.out.println();
        }
    }

    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter min max step:");
        int min, max, step;
        try {
            min = scan.nextInt();
            max = scan.nextInt();
            step = scan.nextInt();
            if(min < 0 | max < 0 | step < 0 | max < min) {
               System.out.println("Invalid input");
            }
            PrintTable(min, max, step);
        } catch (InputMismatchException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}

