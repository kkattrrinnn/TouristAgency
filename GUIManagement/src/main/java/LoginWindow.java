import javax.swing.*;
import java.awt.*;

public class LoginWindow extends GraphicsWindow {

    Font BigFontCS = new Font("ComicSans", Font.BOLD, 45);
    JTextField login;
    JButton ent_button;
    LoginWindow() {
        this.login = new JTextField();
        this.login.setBounds(300, 200, 400, 100);
        this.login.setFont(BigFontCS);
        jPanel.add(this.login);

        this.ent_button = new JButton("Войти");
        this.ent_button.setBounds(400, 400, 400, 100);
        this.ent_button.setBackground(new Color(200, 100, 250, 90));
        this.ent_button.setFont(BigFontCS);
        this.ent_button.addActionListener(e -> {        // обработка нажатия
            jPanel.removeAll();                         // очистка панели
            jPanel.repaint();
            jPanel.revalidate();});


        jPanel.add(this.ent_button);
    }
}
