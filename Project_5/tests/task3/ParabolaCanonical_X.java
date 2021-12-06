package task3;

import java.util.Scanner;
/**
 * This class implement parabola on X axis
 * x^2 = 2yp
 * extends SecondOrderCurves class
 */
public class ParabolaCanonical_X extends SecondOrderCurves {
    private double p = 1;

    /**
     * Referring to parent class constructor
     */
    public ParabolaCanonical_X() {
        super();
    }

    /**
     * Constructor of the ParabolaCanonical_X class
     * refer ro parent class SecondOrderCurves
     * @param y_ -- y-coordinate of the parabola
     * @param p_ -- initialization of focus-radius
     * @throws NullPointerException when parameters doesnt
     * meet the conditions
     */
    public ParabolaCanonical_X(double y_, double p_) {
        super(0, y_);
        if (y_ < 0 | p_ == 0)
            throw new NullPointerException("Котик не инициализирован");
        p = p_;
    }

    /**
     * Setter of p -- focus-radius of the parabola
     * @throws NullPointerException when parameters doesnt
     * meet the conditions
     * @param scan -- for scanning p parameters
     */
    public void valuesSetter(Scanner scan) {
        super.valuesSetter(scan);
        System.out.println("Enter p: ");
        p = scan.nextDouble();
        if (y < 0 | p == 0)
            throw new NullPointerException("Котик не инициализирован");
    }

    /**
     * Getter of x value
     * @return double
     */
    public double get_value() {
        return Math.sqrt(2 * p * y);
    }

    /**
     * Getter of parabola view
     * @return string representative
     */
    public String getView() {
        return String.format("x^2 = %.1fy\n", 2 * p) + super.getView();
    }
}
