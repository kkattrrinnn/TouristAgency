import javax.swing.*; // импортируем блиатеку для открывание во окне
import java.awt.*;


public class GraphicsWindow{
    public static void main(String[] args) {
        создаем_окно();
    }

   public static void создаем_окно(){

        JFrame jFrame = new JFrame();

       ImageIcon img = new ImageIcon("GUIManagement/img/Icon.jpg");
       jFrame.setIconImage(img.getImage());  //-- для иконки приложения

        int width = 600;
        int height = 600;

        jFrame.setVisible(true); //что бы видет окно
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //что закрыть окно

        //ставим окно по центру экрана
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - width / 2,dimension.height / 2 - height / 2  ,width,height);
        //

        jFrame.setTitle("Tourist Agency"); // даем ему название

    }
}
