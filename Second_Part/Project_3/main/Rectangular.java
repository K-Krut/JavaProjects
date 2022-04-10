import java.util.Objects;

public class Rectangular extends Point_Class implements Virtual {

    private double height;
    private double width;

    public Rectangular(double x, double y, double height, double width) {
        super(x, y);
        this.height = height;
        this.width = width;
    }

    public Rectangular(double height, double width) {
        super();
        this.height = height;
        this.width = width;
    }

    public Rectangular() {
        super();
        this.height = 0;
        this.width = 0;
    }

    public Rectangular(Rectangular r) {
        super(r.getX(), r.getY());
        this.width = r.getWidth();
        this.height = r.getHeight();
    }

    @AnnotationReflectable(name="Getting Height")
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @AnnotationReflectable(name="Getting Width")
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @AnnotationReflectable(name="Getting Area")
    public double area() {
        return width * height;
    }

    @AnnotationReflectable(name="Getting Perimeter")
    public double perimeter() {
        return 2 * (width + height);
    }

    public boolean isEmpty() {
        return (width <= 0.0) || (height <= 0.0);
    }

    public boolean contains(double x, double y) {
        double x0 = getX();
        double y0 = getY();
        return (x >= x0 && y >= y0 && x < x0 + getWidth() && y < y0 + getHeight());
    }

    @Override
    public void moving(double x, double y) {
        super.moving(x, y);
    }

    @Override
    public String toString() {
        return "Rectangular {height = " + height + ", width = " + width + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) return false;
        Rectangular that = (Rectangular) obj;
        return Double.compare(that.height, height) == 0 && Double.compare(that.width, width) == 0;
    }
}