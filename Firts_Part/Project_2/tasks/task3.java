package task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task3 {
    private static int[] ReadArray(int length, Scanner scan){
        System.out.println("Enter array");
        int[] arr = new int[length];
        for(int i = 0; i < length; ++i){
            arr[i] = scan.nextInt();
        }
        return arr;
    }
    public static ArrayList<Map<Integer, Integer>> checkFunction(int arr[]) {
        //ArrayList<NameClassPair<Integer,Integer>> TruePairs = new ArrayList<>();
        ArrayList<Map<Integer, Integer>> Pairs = new ArrayList<>();

        for (int i = 0; i < arr.length; ++i) {
            Map<Integer, Integer> map = new HashMap<>();
            boolean ind = true;
            for (int j = 0; j < arr.length; ++j) {
                if (arr[i] == arr[j] && i != j)
                    ind = false;
            }
            if (ind) {
                map.put(arr[i], i);
                Pairs.add(map);
                //System.out.print(arr[i] + " index-> " + i + "\n");
            }
        }
        return Pairs;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //int[] arr = { 7, 1, 7, 8, 1, 67, 6, 5, 6 };
        System.out.print("Enter array length: ");
        int length_arr = scan.nextInt();

        int[] arr = ReadArray(length_arr, scan);
        System.out.println(checkFunction(arr));
    }

}
