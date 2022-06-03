package task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Task2 {

    public static void printArray(ArrayList<Integer> arr) {

        System.out.println("Array: ");
        System.out.println(arr);
    }
    public static ArrayList<Integer> randomArray(ArrayList<Integer> arr){
        Random random = new Random();
        for (int i = 0; i < 10; ++i)
            arr.add(random.nextInt(99 - 1));
        return arr;
    }
    public static boolean repeatedNumber(final List<Integer> list) {
        if (list.size() <= 1) {
            return false;
        }

        Collections.sort(list);

        for (int i = 0; i < list.size() - 1; ++i) {
            if (list.get(i) == list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr_a = new ArrayList<>();

        randomArray(arr_a);
        printArray(arr_a);
        if (repeatedNumber(arr_a))
            System.out.println("Set");
        else
            System.out.println("Isn't a set");
    }
}