package task1;

import java.util.*;


public class Task1 {
    public static void printArray(ArrayList<Integer> arr) {
        System.out.println(arr);
    }
    public static ArrayList<Integer> randomizing(ArrayList<Integer> arr, int length) {
        Random random = new Random();
        for (int i = 0; i < length; ++i)
            arr.add(random.nextInt(99 - 1));
        return arr;
    }
    public static ArrayList<Integer> modification(ArrayList<Integer> arrA,
                                                  ArrayList<Integer> arrB, ArrayList<Integer> arrC){
        Collections.sort(arrA);

        for (int i = 0; i < arrA.size(); ++i) {
            if (arrA.get(i) % 2 == 0)
                arrB.add(arrA.get(i));
            else
                arrC.add(arrA.get(i));
        }
        Collections.sort(arrC, Collections.reverseOrder());

        arrB.addAll(arrC);
        return arrB;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> arrA = new ArrayList<>();
        ArrayList<Integer> arrB = new ArrayList<>();
        ArrayList<Integer> arrC = new ArrayList<>();

        System.out.println("Enter Array size");
        randomizing(arrA, scan.nextInt());

        System.out.println("Original");
        printArray(arrA);

        System.out.println("\n\nResult");
        printArray(modification(arrA, arrB, arrC));
    }
}
