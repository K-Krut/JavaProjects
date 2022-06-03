import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//5.	Вывод строки заданным шрифтом и заданного цвета в графическом окне. В верхней панели
// (JPanel) "Управление выводом" задается  надпись (JLabel) "Текст:" и текстовое поле (JTextField),
// надпись (JLabel) "Гарнитура:", вращающийся список  (JSpinner) со значениями "Times New Roman"
// (шрифт по умолчанию),  "Arial" и "Verdana",  надпись (JLabel) "Цвет:" и вращающийся список
// (JSpinner) со значениями "Черный" (цвет по умолчанию),  "Красный", "Зеленый" и "Синий", а
// также кнопка (JButton) "Вывести строку". В нижней панели (JPanel) "Вывод строки" выводится
// в графическом контексте (с помощью метода drawString()) в произвольном месте пустая строка.
// При задании текста строки в текстовом поле, параметров строки во вращающихся списках  верхней
// панели и нажатии кнопки "Вывод строки" строка заданного содержимого и цвета выводится заданным
// шрифтом в нижней панели.
public class task5 extends JFrame implements ActionListener {
    private JPanel menu;
    private JSpinner choose_font;
    private JSpinner choose_color;
    private JTextField text;
    private JLabel l_text;
    private JLabel l_font;
    private JLabel l_color;
    private JButton print_string;
    private JPanel print_text;
    protected Font font;
    protected Color color;
    protected String[] font_type = {"Times New Roman", "Arial", "Verdana"};
    protected String[] colors = {"Black", "Red", "Green", "Blue" };
    protected String task = "";

    public task5(){
        super("Text");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        choose_color.setModel(new SpinnerListModel(colors));
        choose_color.setValue("Black");
        choose_font.setModel(new SpinnerListModel(font_type));
        choose_font.setValue("Times New Roman");
        add(menu,BorderLayout.NORTH);
        add(print_text);
        pack();
        setSize(500, 500);
        print_string.setActionCommand("Вывести строку");
        print_string.addActionListener(this);
        print_text.setBackground(new Color(255, 255, 255));

        choose_color.addChangeListener(e -> {
            JSpinner spinner = (JSpinner) e.getSource();
            String value = (String) spinner.getValue();
            switch (value){
                case "Black" -> color = Color.BLACK;
                case "Red" -> color = Color.RED;
                case "Green" -> color = Color.GREEN;
                case "Blue" -> color = Color.BLUE;
            }
            System.out.println("Color is " + value);
        });

        choose_font.addChangeListener(e -> {
            JSpinner spinner = (JSpinner) e.getSource();
            String value = (String) spinner.getValue();
            switch (value){
                case "Times New Roman" -> font = new Font("Times New Roman", Font.PLAIN, 14);
                case "Arial" -> font = new Font("Arial", Font.PLAIN, 14);
                case "Verdana" -> font = new Font("Verdana", Font.PLAIN, 14);
            }
            System.out.println("Font is " + value);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Вывести строку")) {
            task = text.getText();
            repaint();
        }
    }

    private void createUIComponents() {print_text = new imagePanel();}
    
    class imagePanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponents(g);
            g.setColor(color);
            g.setFont(font);
            g.drawString(task, 20, 70);
        }
    }

    public static void main(String[] args) {
        new task5().setVisible(true);
    }
}
