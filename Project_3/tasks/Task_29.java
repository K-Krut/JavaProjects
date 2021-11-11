// Анализ аргументов, задаваемых при запуске программы.
// Программа определяет, какие из введенных аргументов
// содержат строку, задаваемую в качестве первого параметра.
// Шаблон аргумента: строка либо цифр, либо латинских букв,
// либо букв кириллицы. Программа выводит количество заданных
// аргументов (без учета первого аргумента) и аргументы,
// содержащие заданную подстроку  или сообщение о том, что данная
// строка не содержится во введенных аргументах.
package task29;

public class Task_29 {
//
//    public static List<String> ConvertingToList(String str){
//        List<String> list = new ArrayList<>(Arrays.asList(str.split("")));
//        return list;
//    }
//    public static boolean Cheking(String strHex) {
//        List<String> list = ConvertingToList("0123456789ABCDEFabcdef");
//        List<String> listTemp = ConvertingToList(strHex);
//        return list.containsAll(listTemp);
//    }

    public static void checking(String args[]){
        for(int i = 1; i < args.length; ++i) {
            System.out.format("%s %s\n", args[i], args[i].contains(args[0]));
        }
    }
    public static void main(String args[]) {
        System.out.println(args.length - 1);
        checking(args);
    }
}
