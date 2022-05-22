import javax.swing.*;
import java.awt.*;

public class LoginWindow extends GraphicsWindow {

    Font BigFontCS = new Font("ComicSans", Font.BOLD, 40);
    JTextField login;
    JButton ent_button;
    JLabel label;

    int x = 350 , y = 170, width = 400 , height = 100;
    LoginWindow() {

        this.label= new JLabel("Введите пароль");
        this.label.setFont(BigFontCS);
        this.label.setBounds(x-330, y  ,width,height);

        this.jPanel.add(this.label);

        this.login = new JTextField();
        this.login.setBounds(x , y ,width,height);
        this.login.setFont(BigFontCS);
        this.jPanel.add(this.login);

        this.ent_button = new JButton("Войти");
        this.ent_button.setBounds(400, 400, 400, 100);
        this.ent_button.setBackground(new Color(200, 100, 250, 90));
        this.ent_button.setFont(BigFontCS);
        this.ent_button.addActionListener(e -> {        // обработка нажатия
            this.jPanel.removeAll();                         // очистка панели
            this.jPanel.repaint();
            this.jPanel.revalidate();});


        this.jPanel.add(this.ent_button);
    }
}
