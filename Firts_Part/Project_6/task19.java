import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

//19.	Изменение фигуры в графическом окне. В центре верхней панели (JPanel)
// "Вывод треугольника" в графическом контексте рисуется (с помощью метода
// drawPolygon()) треугольник.  В нижней панели (JPanel) "Параметры треугольника"
// задаются следующие компоненты: надпись (JLabel)   "Цвет:", раскрывающееся меню
// (JComboBox) с пунктами: "Черный" (цвет по умолчанию),  "Красный", "Зеленый" и
// "Синий", надпись (JLabel)   "Номер вершины:", раскрывающееся меню  (JComboBox)
// с пунктами "1", "2" и "3",  надпись (JLabel)   "Координата X:", вращающийся
// список  (JSpinner), надпись (JLabel)   "Координата Y:", вращающийся список
// (JSpinner) и кнопка (JButton) "Изменить треугольник". При наборе данных во
// вращающихся списках (в пикселях) и при нажатии кнопки "Изменить треугольник"
// треугольник перерисовывается заданным цветом и с заданным новым положением
// одной из вершин. Диапазон изменения вращающихся списков – от 0 до 150 с шагом 1.
public class task19 extends JFrame implements ActionListener {
    private JPanel menu;
    private JPanel Print;
    private JComboBox choose_color;
    private JSpinner choose_x;
    private JSpinner choose_y;
    private JButton change;
    private JComboBox choose_point;
    private JLabel col;
    private JLabel numb;
    private JLabel label_x;
    private JLabel label_y;
    protected String[] Colors = {"Black", "Red", "Green", "Blue" };
    protected Integer[] points = {1, 2, 3};
    protected Color color;
    protected int x[] = {100, 200, 400};
    protected int y[] = {100, 400, 200};
    protected int new_x, new_y;

    public task19(){
        super("Triangle");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        choose_color.setModel(new DefaultComboBoxModel(Colors));
        choose_color.setSelectedIndex(0);
        choose_point.setModel(new DefaultComboBoxModel(points));
        add(Print);
        add(menu, BorderLayout.SOUTH);
        pack();
        setSize(700, 700);
        color = new Color(0,0,0);
        choose_x.setModel(new SpinnerNumberModel(75, 0, 150, 1));
        choose_y.setModel(new SpinnerNumberModel(75, 0, 150, 1));

        choose_color.setActionCommand("Цвет");
        choose_point.setActionCommand("Вершина");
        change.setActionCommand("Изменить");
        choose_color.addActionListener(this);
        choose_point.addActionListener(this);
        change.addActionListener(this);
        Print.setBackground(new java.awt.Color(255, 255, 255));
        choose_x.addChangeListener(e -> {
            JSpinner spinner = (JSpinner) e.getSource();
            new_x = (int)spinner.getValue();
            System.out.println("X is " + new_x);
        });
        choose_y.addChangeListener(e -> {
            JSpinner spinner = (JSpinner) e.getSource();
            new_y = (int)spinner.getValue();
            System.out.println("Y is " + new_y);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Цвет" -> {
                String color1 = Objects.requireNonNull(choose_color.getSelectedItem()).toString();
                switch(color1) {
                    case "Black" -> color = Color.BLACK;
                    case "Red" -> color = Color.RED;
                    case "Green" -> color = Color.GREEN;
                    case "Blue" -> color = Color.BLUE;
                }
            }
            case "Вершина" -> {
                Integer point = (Integer) Objects.requireNonNull(choose_point.getSelectedItem());
                switch (point) {
                    case 1 -> {
                        x[0] = new_x;
                        y[0] = new_y;
                    }
                    case 2 -> {
                        x[1] = new_x;
                        y[1] = new_y;
                    }
                    case 3 -> {
                        x[2] = new_x;
                        y[2] = new_y;
                    }
                }
            }
        }
        if (command.equals("Изменить")) {
            repaint();
        }

    }
    private void createUIComponents() {Print = new imagePanel();}

    class imagePanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponents(g);
            g.setColor(color);
            g.drawPolygon(x, y, 3);
        }
    }


    public static void main(String[] args) { new task19().setVisible(true); }
}
