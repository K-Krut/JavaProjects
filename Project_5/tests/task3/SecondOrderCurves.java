package task3;

import java.util.Scanner;

/**
 * Parent class for implementing parabola as curves of the second order
 */
public class SecondOrderCurves {
    protected double x = 1;
    protected double y = 1;

    /**
     * Constructor of the SecondOrderCurves class with no parameters
     */
    public SecondOrderCurves() {

    }

    /**
     * Constructor of the SecondOrderCurves class
     * @param x_ -- x coordinate of the parabola
     * @param y_ -- y coordinate of the parabola
     * @throws NullPointerException when x and y = 0
     */
    public SecondOrderCurves(double x_, double y_) {
        if(x == 0 && y == 0)
            throw new NullPointerException("Котик не инициализирован");
        x = x_;
        y = y_;
    }

    /**
     * Setter of the x, y parameters
     * @param scan -- for scanning coordinates
     */
    public void valuesSetter(Scanner scan) {
        System.out.println("Enter x: ");
        x = scan.nextDouble();
        System.out.println("Enter y: ");
        y = scan.nextDouble();
        if(x == 0 & y == 0)
            throw new NullPointerException("Котик не инициализирован");
    }

    /**
     * Getter of the parabola view
     * @return string representative
     */
    public String getView() {
        return String.format("x = %.1f, y = %.1f", x, y);
    }
}