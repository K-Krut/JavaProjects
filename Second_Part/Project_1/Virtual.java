package Project_1;

public interface Virtual {

    void moving(double x, double y);

    default void moving() {
        System.out.println("moving");
    }

    double getX();

    double getY();

    void setX(double x);

    void setY(double y);

    double getHeight();

    void setHeight(double height);

    double getWidth();

    void setWidth(double width);

    double area();

    double perimeter();

}