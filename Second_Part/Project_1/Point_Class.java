package Project_1;

import java.util.Objects;

public class Point_Class {
    public double x;
    public double y;

    public Point_Class(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point_Class() {
        x = 0;
        y = 0;
    }
    @AnnotationReflectable(name="Getting x")
    public double getX() {
        return x;
    }

    @AnnotationReflectable(name="Getting y")
    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }


    public void setY(double y) {
        this.y = y;
    }


    public void moving(double x, double y) {
        this.x += x;
        this.y += y;
    }

    @Override
    @AnnotationReflectable(name="toString")
    public String toString() {
        return "point {x = " + x + "; y = " + y + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Point_Class point = (Point_Class) obj;

        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}