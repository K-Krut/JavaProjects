package project1;

import java.util.Scanner;

public class Task_2 {
    public static int Integer;
    public static double SqaredRoot, RoundedRoot;

    public static int getting_summa(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum; //        return number % 10 + number / 10 % 10 + number / 100 % 10;
    }

    public static void counting(int num) {
        Integer = getting_summa(num);
        SqaredRoot = Math.sqrt(Integer);
        RoundedRoot = Math.round(SqaredRoot);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
//        try {
            counting(in.nextInt());
            System.out.printf("Sum of digits: %d\nSquare root: %1.3f\nThe closets integer: %.0f", Integer, SqaredRoot, RoundedRoot);
//        }
//        catch (Exception e) {
//            System.out.println("Invalid value! Exit program...");
//        }
    }
}
