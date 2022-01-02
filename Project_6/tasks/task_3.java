//3.	Изменение размера фигуры в графическом окне. В окне определена строка меню
// (JMenuBar), в которой определены меню (JMenu)  "Параметр" и "Изменение". В меню
// "Параметр" определены два пункта меню (JCheckBoxMenuItem): "Ширина" (по умолчанию
// включена)  и "Высота" (по умолчанию включена). В меню "Изменение" определены два
// пункта меню (JMenuItem): "Увеличить"   и "Уменьшить". В центре панели (JPanel) окна
// "Вывод изображения" в графическом контексте задается (с помощью метода drawRect())
// прямоугольник.    При выборе одного из пунктов второго меню  фигура скачкообразно
// (на 10 пикселей) увеличивается или уменьшается для заданного параметра или параметров
// в первом меню и перерисовывается. Если в первом меню не включен ни один из пунктов,
// фигура не меняется.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task_3 extends JFrame implements ActionListener {
    private JPanel Print;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu parameter = new JMenu("parameter");
    private JMenu change = new JMenu("change");
    private JMenuItem increase = new JMenuItem("Увеличить");
    private JMenuItem reduce= new JMenuItem("Уменьшить");
    private JCheckBoxMenuItem width = new JCheckBoxMenuItem("Ширина");
    private JCheckBoxMenuItem height= new JCheckBoxMenuItem("Высота");

    protected int rect_width, rect_height;

    public task_3() {
        super("Rectangle");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(Print);
        add(menuBar, BorderLayout.NORTH);
        pack();
        setSize(500, 500);
        rect_width = 150;
        rect_height = 150;
        parameter.add(width);
        parameter.add(height);
        change.add(increase);
        change.add(reduce);
        menuBar.add(parameter);
        menuBar.add(change);
        width.setActionCommand("Ширина");
        height.setActionCommand("Высота");
        increase.setActionCommand("Увеличить");
        reduce.setActionCommand("Уменьшить");

        height.addActionListener(this);
        increase.addActionListener(this);
        reduce.addActionListener(this);
        width.addActionListener(this);

        Print.setBackground(new java.awt.Color(255, 255, 255));
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("Увеличить")){
            if(width.isSelected()){
                rect_width += 10;
            }
            if(height.isSelected()){
                rect_height += 10;
            }
        }
        if(command.equals("Уменьшить")){
            if(width.isSelected()){
                rect_width -= 10;
            }
            if(height.isSelected()){
                rect_height -= 10;
            }
        }
        repaint();
    }

    private void createUIComponents() {Print = new imagePanel();}

    class imagePanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawRect(50, 50, rect_width, rect_height);
        }
    }
    public static void main(String[] args) {
        new task_3().setVisible(true);
    }
}

