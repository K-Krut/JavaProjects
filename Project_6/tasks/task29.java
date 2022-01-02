import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*29.	Изменение размера изображения в графическом окне. В верхней панели
 окна  (JPanel) "Размер изображения" заданы следующие компоненты: надпись
 (JLabel)   "Ширина:", текстовое поле  (JTextField), надпись (JLabel)
 "Высота:", текстовое поле  (JTextField) и кнопка  (JButton): "Вывести
 изображение". В нижней панели окна (JPanel) окна "Вывод изображения" в
 компоненте (JLabel) задается произвольное изображение. При вводе размера
 изображения по ширине и высоте и нажатии кнопки "Вывести изображение" в
 нижней панели выводится масштабированное изображение с заданными размерами
 (в пикселях). Первоначально изображение имеет «естественный» размер. Перед
 выводом изображения выполняется проверка, заданы ли значения ширины и высоты
 и являются ли они целыми числами.*/
public class task29 extends JFrame implements ActionListener {
    private JTextField width;
    private JTextField height;
    private JButton print_image;
    private JLabel l_width;
    private JLabel l_height;
    private JPanel menu;
    private JPanel Print;
    private JLabel l_image;
    protected int img_width = 250, img_height = 250;

    public task29 (){
        super("Image");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(Print);
        add(menu, BorderLayout.SOUTH);
        pack();
        setSize(800, 800);
        print_image.addActionListener(this);
        Print.setBackground(new java.awt.Color(255, 255, 255));

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!width.getText().isEmpty() && !height.getText().isEmpty() && Integer.parseInt(width.getText()) > 0 &&
                Integer.parseInt(height.getText()) > 0) {
            img_width = Integer.parseInt(width.getText());
            img_height = Integer.parseInt(height.getText());

        }
        Image i = new ImageIcon("stitch.png").getImage().getScaledInstance(img_width,
                img_height, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(i);
        icon.getImage().flush();
        l_image.setIcon(icon);
        l_image.setVisible(true);
    }
    private void createUIComponents() {
        Image icon = new ImageIcon("stitch.png").getImage().getScaledInstance(img_width,
                img_height, Image.SCALE_DEFAULT);
        l_image = new JLabel(new ImageIcon(icon));
        l_image.setVisible(false);
    }
    public static void main(String[] args){
        new task29().setVisible(true);
    }

}
