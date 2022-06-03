package project1;

import java.util.Scanner;

public class Task_19_2
{
    public static double triangleSquare(int a, int b, int c, int d, int diag) {
        int p1 = a + b + diag;
        int p2 = c + d + diag;
        double S1 = Math.sqrt(p1 * (p1 - a) * (p1 - b) * (p1 - diag));
        double S2 = Math.sqrt(p2 * (p2 - c) * (p2 - d) * (p2 - diag));

        return S1 + S2;
    }
    public static boolean check_data(int a) {
        return a > 0 & a == (int)a;
    }
    public static void input_data(Scanner in) {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int diag = in.nextInt();
        if(check_data(a) & check_data(b) & check_data(c) & check_data(d)) {
            System.out.println("Square: " + triangleSquare(a, b, c, d, diag));
        } else {
            System.out.println("Invalid input");
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Square: " + triangleSquare(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()));
    }
}
//javac -d C:\Users\User\Desktop\bin C:\Users\User\Desktop\tak12a.java
//javac -d C:\Users\User\Desktop\bin C:\Users\User\Desktop\Task_2.java
//javac -d bin Task_2.java