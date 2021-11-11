package project1;

import java.util.Scanner;

public class Task_9 {

    public static void counting(int num) {
        int A2 = num * num;
        int A3 = A2 * num;
        int A5 = A2 * A3;
        int A10 = A5 * A5;
        int A15 = A10 * A5;
        System.out.printf("Number or A: %d\nA^2: %d\nA^3: %d\nA^5: %d\nA^10: %d\nA^15: %d", num, A2, A3, A5, A10, A15);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        counting(in.nextInt());
    }
}
//Дано целое число A. Вычислить A15, используя две вспомогательные переменные
//        и пять операций умножения. Для этого последовательно находить
//        A2, A3, A5, A10, A15. Вывести все найденные степени числа A.


