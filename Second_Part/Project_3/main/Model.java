import java.util.ArrayList;
import java.util.Objects;

public class Model implements Container {

    ArrayList<Point_Class> ListPoint = new ArrayList<>();
    ArrayList<Rectangular> ListRectangular = new ArrayList<>();

    private static Model instance;

    Factory factory = new Factory();

    private Model() {}

    public static Model getInstance() {
        return (instance == null) ? (instance = new Model()) : instance;
    }

    public Point_Class Point_Class(double x, double y) {
        Point_Class point = (Point_Class) factory.create("Point", x, y, 1.0, 1.0);
        ListPoint.add(point);
        return point;
    }

    public Rectangular Rectangular(double x, double y, double height, double width) {
        Rectangular rectangular = (Rectangular) factory.create("Rectangular", x, y, height, width);
        ListRectangular.add(rectangular);
        return rectangular;
    }

    @Override
    public Iterator getIterator(String name) {
        return Objects.equals(name, "Point") ? new ArrayListPointIterator() : new ArrayListRectangularIterator();
    }

    class ArrayListPointIterator implements Iterator {

        int index;

        @Override
        public boolean hasnext() {
            return index < ListPoint.size();
        }

        @Override
        public Object next() {
            return hasnext() ? ListPoint.get(index++) : null;
        }
    }

    class ArrayListRectangularIterator implements Iterator {

        int index;

        @Override
        public boolean hasnext() {
            return index < ListRectangular.size();
        }

        @Override
        public Object next() {
            return hasnext() ? ListRectangular.get(index++) : null;
        }
    }
}
