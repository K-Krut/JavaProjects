package task5;

import org.junit.Test;
import task3.ParabolaCanonical_Y;
import task3.ParabolaQuadratic;
import task3.SecondOrderCurves;

import static org.junit.Assert.assertEquals;

public class Task3Test {

    @Test
    public void checkCurveView() {
        SecondOrderCurves curve = new SecondOrderCurves(2, 4);
        assertEquals("x = 2,0, y = 4,0",curve.getView());
    }

    @Test
    public void checkParabolaView() {
        ParabolaQuadratic quadratic = new ParabolaQuadratic(3, 4, 1.2, 4.4, 5);
        assertEquals("f(x) = 1,2x^2 + 4,4x + 5,0\n" +
                "x = 3,0, y = 4,0",quadratic.getView());
    }
    @Test
    public void checkParabola_YView() {
        ParabolaCanonical_Y parabolaY = new ParabolaCanonical_Y(2, 6);
        assertEquals("y^2 = 12,0x\n" +
                "x = 2,0, y = 0,0",parabolaY.getView());
    }
}
