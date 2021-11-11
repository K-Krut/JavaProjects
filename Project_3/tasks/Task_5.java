//Создайте программу для шифрования\расшифровки текста методом Цезаря.
// В нем ключом является целое число, а шифрование\расшифровка заключается в
// суммировании вычитании кодов символов открытого текста\криптотекста с ключом.


package task5;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;
import java.util.MissingResourceException;
import java.util.Scanner;

public class Task_5 {

    public static String Ceaser(String text, int shift) {
        String result = "";

        for (int i = 0; i < text.length(); ++i) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) + shift - 65) % 26 + 65);
                result += ch;
            } else {
                char ch = (char) (((int) text.charAt(i) + shift - 97) % 26 + 97);
                result+= ch;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
            System.out.println("Enter a message: ");
            String message = scan.nextLine();
            if(message.length() <= 0){
                throw new MissingFormatArgumentException("Invalid input");
            }
            System.out.println("Enter key: ");
            Integer key = scan.nextInt();
            if(!(key instanceof Integer) | key <= 0 | key > 26) {
                throw new InputMismatchException("");
            }
            try {
                System.out.println(Ceaser(message, key));
                System.out.println(Ceaser(message, 26 + key));
            } catch (MissingResourceException | MissingFormatArgumentException e) {
                System.out.println(e);
            }
        }
    }

