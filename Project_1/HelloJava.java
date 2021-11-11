package project1;

public class HelloJava {

    public static void main(String[] args) {
        System.out.println("Hello, Java!");
        try {
            System.out.println(args[0]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Bad input");
        }
    }
}

















//javac -d bin Task_9.java
//javac -d C:\Users\User\Desktop\bin C:\Users\User\Desktop\Task_2.java
// javac -d bin Task_9.java
// java -classpath ./bin project1.Task_9
// cd