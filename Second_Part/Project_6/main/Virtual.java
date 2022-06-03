public interface Virtual {

     void moving(double x, double y);

     default void moving() {
         System.out.println("Moving");
     }

     default String setInterface () {
         return "Setter";
     }

    default String getInterface () {
        return "Getter";
    }
}
