package task3;

import java.util.Scanner;

/**
 * This class implement parabola on Y axis in quadratic form
 * y = ax^2 + bx + c
 * extends SecondOrderCurves class
 */
public class ParabolaQuadratic extends SecondOrderCurves {
    private double a;
    private double b;
    private double c;
    {
        a = 1;
        b = c = 0;
    }
    public ParabolaQuadratic() {
        super();
    }
    /**
     *
     * Constructor of the ParabolaCanonical_Y class
     * refer ro parent class SecondOrderCurves
     * @param x_ -- x-coordinate of the parabola
     * @param y_ -- initialization of focus-radius
     * @param a_ -- param of the formula
     * @param b_ -- param of the formula
     * @param c_ -- param of the formula
     * @throws NullPointerException when parameters doesn't
     * meet the conditions
     */
    public ParabolaQuadratic(double x_, double y_, double a_, double b_, double c_) {
        super(x_, y_);
        a = a_;
        if(a == 0){
            throw new NullPointerException("Котик не инициализирован");
        }
        b = b_;
        c = c_;
    }

    /**
     * Setter of p -- focus-radius of the parabola
     * @throws NullPointerException when parameters doesn't
     * meet the conditions
     * @param scan -- for scanning p parameters
     */
    public void valuesSetter(Scanner scan) {
        super.valuesSetter(scan);
        a = scan.nextDouble();
        if(a == 0){
            throw new NullPointerException("Котик не инициализирован");
        }
        b = scan.nextDouble();
        c = scan.nextDouble();
    }

    /**
     * Getter of y value
     * @return double
     */
    public double getValue() {
        return x * (a * x + b) + c;
    }

    public String getView() {
        return String.format("f(x) = %.1fx^2 + %.1fx + %.1f\n", a, b, c) + super.getView();

    }
}
