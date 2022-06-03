package project1;

import java.util.Scanner;

public class Task_14 {
    public static void triangle(int a, int b) {
        double hypotenyse = Math.sqrt(a * a  + b * b);
        double height = a * b / hypotenyse;
        System.out.printf("Legs: %d %d\nHypotenyse: %.0f\nHeight: %.2f", a, b, hypotenyse, height);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        triangle(in.nextInt(), in.nextInt());
    }
}


//Даны целые катеты прямоугольного треугольника, найти высоту и гипотенузу.
