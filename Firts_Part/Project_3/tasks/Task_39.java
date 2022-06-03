//Преобразование аргументов, задаваемых при запуске программы.
// Программа определяет тип аргумент – шестнадцатеричное число без знака
// (шаблон: шестнадцатеричным числом без знака считается строка,
// которая содержит цифры от 0 до 9 и буквы
// A(a), B(b), C(c), D(d), E(e),F(f)) или строка.
// Введенные аргументы-числа преобразуются в двоичные числа.
// Программа выводит количество заданных аргументов, их значения,
// а также количество аргументов-чисел и их двоичные значения.
package task39;

import java.util.*;


public class Task_39 {

    public static List<String> ConvertingToList(String str){
        List<String> list = new ArrayList<>(Arrays.asList(str.split("")));
        return list;
    }
    public static boolean Cheking(String strHex) {
        List<String> list = ConvertingToList("0123456789ABCDEFabcdef");
        List<String> listTemp = ConvertingToList(strHex);
        return list.containsAll(listTemp);
    }
    public static int ConvertingDemical(String strHex) {
        return Integer.parseInt(strHex, 16);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        String str = "2F6";
        String str = scan.nextLine();
        if(str.length() <= 0){
            throw new InputMismatchException("Input is invalid");
        }
        if(Cheking(str)) {
            System.out.println(ConvertingDemical(str));
        } else {
            throw new InputMismatchException("Invalid input");
        }
    }
}
