import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    Rectangular Rectangle = new Rectangular(5, 6, 7, 8);

    ArrayList<String> Expected_constructors = new ArrayList<String>(
            Arrays.asList("Rectangular(class Rectangular)",
            "Rectangular()", "Rectangular(double, double)", "Rectangular(double, double, double, double)"));

    ArrayList<String> Expected_methods = new ArrayList<>(Arrays.asList(
            "Rectangular.area() = 56.0", "Rectangular.getHeight() = 7.0", "Rectangular.getWidth() = 8.0",
            "Rectangular.getX() = 5.0", "Rectangular.getY() = 6.0", "Rectangular.perimeter() = 30.0")
    );
    ArrayList<String> Expected_fields = new ArrayList<>(Arrays.asList(
            "Rectangular.height = 7.0 type: double modifier: private", "Rectangular.width = 8.0 type: double modifier: private)"
    );

    @BeforeAll
    static void setUp() {
    }

    @Test
    void getting_class_methods() {
        try {
            assertEquals(Main.getting_class_methods(Rectangle), Expected_methods);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getting_class_fields() {
        try {
            assertEquals(Main.getting_class_fields(Rectangle), Expected_methods);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getting_annotated_methods() {
    }

    @Test
    void getting_method_by_name() {
    }

    @Test
    void getting_filed_by_name() {
    }

    @Test
    void get_annotations() {
    }

    @Test
    void get_constructors() {
    }

    @Test
    void get_types() {
    }

    @Test
    void testGet_types() {
    }

    @Test
    void rectangle_constructor_test() {
    }

    @Test
    void check_invocation() {
    }
}