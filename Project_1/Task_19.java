package project1;

import java.util.Scanner;

public class Task_19 {
    public static double triangleSquare(int a, int b, int c, int d, int diag) {
        int p1 = a + b + diag;
        int p2 = c + d + diag;
        double S1 = Math.sqrt(p1 * (p1 - a) * (p1 - b) * (p1 - diag));
        double S2 = Math.sqrt(p2 * (p2 - c) * (p2 - d) * (p2 - diag));

        return S1 + S2;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Square: " + triangleSquare(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()));
    }
}


//Даны 4 целых стороны и диагональ выпуклого четырехугольника.
// Найти его площадь (рассмотрев 2 треугольника).
