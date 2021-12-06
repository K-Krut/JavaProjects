package task3;

import java.util.Scanner;

/**
 * This class implement parabola on Y axis
 * y^2 = 2yx
 * extends SecondOrderCurves class
 */
public class ParabolaCanonical_Y extends SecondOrderCurves {
    private double p;
    {
        p = 1;
    }
    /**
     * Referring to parent class constructor
     */
    public ParabolaCanonical_Y() {
        super();
    }

    /**
     * Constructor of the ParabolaCanonical_Y class
     * refer ro parent class SecondOrderCurves
     * @param x_ -- x-coordinate of the parabola
     * @param p_ -- initialization of focus-radius
     * @throws NullPointerException when parameters doesnt
     * meet the conditions
     */
    public ParabolaCanonical_Y(double x_, double p_) {
        super(x_, 0);
        if(x_ < 0 | p_ == 0)
            throw new NullPointerException("Котик не инициализирован");
        p = p_;
    }

    /**
     * Setter of p -- focus-radius of the parabola
     * @throws NullPointerException when parameters doesn't
     * meet the conditions
     * @param scan -- for scanning p parameters
     */
    public void valuesSetter(Scanner scan) {
        super.valuesSetter(scan);
        System.out.println("Enter p: ");
        p = scan.nextDouble();
        if(x < 0 | p == 0)
            throw new NullPointerException("Котик не инициализирован");
    }

    /**
     * Getter of y value
     * @return double
     */
    public double getValue() {
        return Math.sqrt(2 * p * x);
    }

    /**
     * Getter of parabola view
     * @return string representative
     */
    public String getView() {
        return String.format("y^2 = %.1fx\n", 2 * p) + super.getView();
    }
}