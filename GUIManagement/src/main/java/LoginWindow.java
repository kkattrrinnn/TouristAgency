import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LoginWindow extends GraphicsWindow {

    Font BigFontCS = new Font("ComicSans", Font.BOLD, 40);
    JTextField login;
    JTextField password_input;
    JButton ent_button_input;
    JLabel labelLogin_input;
    JLabel labelPassword_input;

    JLabel label_hello_input;

    JLabel error_no_password;
    int x = 400 , y = 160, width = 400 , height = 80;
    public Boolean entrance_input;
    LoginWindow() {
        this.entrance_input = false;
//-----------------------------------------------------------------
        this.error_no_password = new JLabel("Неверный пароль");
        this.error_no_password.setFont(BigFontCS);
        this.error_no_password.setForeground(Color.red);
        this.error_no_password.setBounds(x, y+4*height+50, width, height);
        this.jPanel.add(this.error_no_password);
//-----------------------------------------------------------------
        this.label_hello_input = new JLabel("Авторизация");
        this.label_hello_input.setFont(BigFontCS);
        this.label_hello_input.setBounds(x,y-60,width = 400 , height = 60);
        this.jPanel.add(this.label_hello_input);
//-----------------------------------------------------------------
        this.labelLogin_input = new JLabel("Введите логин");
        this.labelLogin_input.setFont(BigFontCS);
        this.labelLogin_input.setBounds(x-330, y, width, height);
        this.jPanel.add(this.labelLogin_input);

        this.login = new JTextField();
        this.login.setBounds(x, y, width, height);
        this.login.setFont(BigFontCS);
        this.jPanel.add(this.login);
//-----------------------------------------------------------------
        this.labelPassword_input = new JLabel("Введите пароль");
        this.labelPassword_input.setFont(BigFontCS);
        this.labelPassword_input.setBounds(x-330, y+2*height, width, height);
        this.jPanel.add(this.labelPassword_input);

        this.password_input = new JTextField();
        this.password_input.setBounds(x, y+2*height, width, height);
        this.password_input.setFont(BigFontCS);
        this.jPanel.add(this.password_input);
//-----------------------------------------------------------------
        this.ent_button_input = new JButton("Войти");
        this.ent_button_input.setBounds(x, y+4*height, width, height);
        this.ent_button_input.setBackground(new Color(255, 128, 128, 90));
        this.ent_button_input.setFont(BigFontCS);
        this.ent_button_input.addActionListener(e -> {        // обработка нажатия
            this.jPanel.removeAll();                         // очистка панели
            this.jPanel.repaint();
            this.jPanel.revalidate();});

            this.entrance_input = true;
        this.jPanel.add(this.ent_button_input);
    }

    //-----------------------------------------------------------------
    public Boolean getEntrance() {
        return this.entrance_input;
    }
    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>(2);
        data.add(this.login.getText());
        data.add(this.password_input.getText());
        return data;

    }
}
