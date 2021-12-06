// Построить программу для работы с классом для хранения
// данных о кривой второго порядка - параболе. Программа
// должна обеспечивать простейшие функции: расчет у по
// х и наоборот, ввод значений, вывод значений.
package task3;

import java.util.Scanner;
/**
 * Primary class of task 3
 */

public class Task_3 {
    /**
     * Gives the user the opportunity to see result of program
     *
     * @param args parameters are not expected
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SecondOrderCurves curve = new SecondOrderCurves(2, 4);
        System.out.println(curve.getView());
        ParabolaQuadratic quadratic = new ParabolaQuadratic(3, 4, 1.2, 4.4, 5);
        System.out.println(quadratic.getView());
        System.out.printf("Parabola value: %.2f\n", quadratic.getValue());
        ParabolaCanonical_Y parabolaY = new ParabolaCanonical_Y(2, 6);
        System.out.println(parabolaY.getView());
        System.out.printf("Parabola value: %.2f\n", parabolaY.getValue());
        ParabolaCanonical_X parabolaX = new ParabolaCanonical_X();
        parabolaX.valuesSetter(scan);
        System.out.println(parabolaX.getView());
        System.out.printf("Parabola value: %.2f\n", parabolaX.get_value());
    }
}
