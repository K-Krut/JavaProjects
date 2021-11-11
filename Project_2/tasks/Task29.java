package task29;

import java.util.Arrays;

public class Task29 {
    public static void main(String[] args) {
        int[] a = new int[]{13, -14, 18, -14};
        int[] b = null;
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) b = addElementToArray(b, a[i]) ;
            }
        }
        for (int i = 0; i < b.length; i++) {
            System.out.print(" " + b[i]);
        }
    }
    public static int[] addElementToArray(int[] array, int element) {
        if (array == null) {
            return new int[]{element};
        }
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = element;
        return newArray;
    }
}
