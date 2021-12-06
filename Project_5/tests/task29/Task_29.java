package task29;

/**
 * Primary class for teh Task 29
 */
public class Task_29 {
    /**
     * Function for showing the result of the program running
     * @param args parameters are not expected
     */
    public static void main(String[] args){
        Student St1 = new Student("Sara Nelson", 3, 123094211L);
        Graduate Gd1 = new Graduate("John McCarthy", 5,
                45324545L, "SomeTopic");
        System.out.println(St1);
        System.out.println(Gd1);
    }
}
