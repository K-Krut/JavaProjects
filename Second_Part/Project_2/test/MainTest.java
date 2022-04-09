import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    Rectangular Rectangle = new Rectangular(5, 6, 7, 8);

//    ArrayList<String> Expected_constructors = new ArrayList<String>(
//            Arrays.asList("Rectangular(class Rectangular)",
//            "Rectangular()", "Rectangular(double, double)", "Rectangular(double, double, double, double)"));

    ArrayList<String> Expected_methods = new ArrayList<>(Arrays.asList(
            "Rectangular.area() = 56.0", "Rectangular.getHeight() = 7.0", "Rectangular.getWidth() = 8.0",
            "Rectangular.getX() = 5.0", "Rectangular.getY() = 6.0", "Rectangular.perimeter() = 30.0")
    );

//    ArrayList<String> Expected_fields = new ArrayList<>(Arrays.asList(
//            "Rectangular.height = 7.0 type: double modifier: private", "Rectangular.width = 8.0 type: double modifier: private)"
//    ));
//

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
    void check_invocation() {
        try {
            Main.check_invocation(Rectangle);
        } catch (Exception e) {
            assertEquals("java.lang.RuntimeException: Object immutable", e.toString());
        }
    }
}