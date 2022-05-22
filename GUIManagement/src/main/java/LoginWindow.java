import javax.swing.*;
import java.awt.*;
import java.lang.constant.Constable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LoginWindow extends GraphicsWindow {

    Font BigFontCS = new Font("ComicSans", Font.BOLD, 40);
    JTextField login;
    JTextField password;
    JButton ent_button;
    JLabel labelLogin;
    JLabel labelPassword;
    int x = 400 , y = 100, width = 400 , height = 80;
    public Boolean entrance;
    LoginWindow() {
        this.entrance = false;

        this.labelLogin= new JLabel("Введите логин");
        this.labelLogin.setFont(BigFontCS);
        this.labelLogin.setBounds(x-330, y, width, height);
        this.jPanel.add(this.labelLogin);

        this.login = new JTextField();
        this.login.setBounds(x, y, width, height);
        this.login.setFont(BigFontCS);
        this.jPanel.add(this.login);

        this.labelPassword = new JLabel("Введите пароль");
        this.labelPassword.setFont(BigFontCS);
        this.labelPassword.setBounds(x-330, y+2*height, width, height);
        this.jPanel.add(this.labelPassword);

        this.password = new JTextField();
        this.password.setBounds(x, y+2*height, width, height);
        this.password.setFont(BigFontCS);
        this.jPanel.add(this.password);

        this.ent_button = new JButton("Войти");
        this.ent_button.setBounds(x, y+4*height, width, height);
        this.ent_button.setBackground(new Color(200, 100, 250, 90));
        this.ent_button.setFont(BigFontCS);
        this.ent_button.addActionListener(e -> {        // обработка нажатия
            this.jPanel.removeAll();                         // очистка панели
            this.jPanel.repaint();
            this.jPanel.revalidate();});

            this.entrance = true;
        this.jPanel.add(this.ent_button);
    }


    public Boolean getEntrance() {
        return this.entrance;
    }
    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>(2);
        data.add(this.login.getText());
        data.add(this.password.getText());
        return data;

    }
}
