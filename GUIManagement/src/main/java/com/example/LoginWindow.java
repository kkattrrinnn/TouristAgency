package com.example;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
public class LoginWindow extends GraphicsWindow {

    Font BigFontCS = new Font("ComicSans", Font.BOLD, 40);
    JTextField login;
    JPasswordField password_input;
    JButton ent_button_input;
    JButton Will_come_back_button;
    JLabel labelLogin_input;
    JLabel labelPassword_input;
    JLabel label_hello_input;
    JLabel error_no_password;
    int x = 400 , y = 160, width = 400 , height = 80;
    public ArrayList<String> login_data;
    public LoginWindow(int id) {
        this.id = id;
        constructor();

    }
    public LoginWindow() {
        constructor();
    }

    void constructor() {
        //-----------------------------------------------------------------
        this.error_no_password = new JLabel("Неверный пароль"); // сообщение об ошибке
        this.error_no_password.setFont(BigFontCS);
        this.error_no_password.setForeground(Color.red);
        this.error_no_password.setBounds(x, y + 4 * height + 50, width, height);
        this.jPanel.add(this.error_no_password);
//-----------------------------------------------------------------
        this.label_hello_input = new JLabel("Авторизация");
        this.label_hello_input.setFont(BigFontCS);
        this.label_hello_input.setBounds(x, y - 60, width = 400, height = 60);
        this.jPanel.add(this.label_hello_input);
//-----------------------------------------------------------------
        this.labelLogin_input = new JLabel("Введите логин");
        this.labelLogin_input.setFont(BigFontCS);
        this.labelLogin_input.setBounds(x - 330, y, width, height);
        this.jPanel.add(this.labelLogin_input);
//----------------------------------------------------------------
        this.login = new JTextField();
        this.login.setBounds(x, y, width, height);
        this.login.setFont(BigFontCS);
        this.jPanel.add(this.login);
//-----------------------------------------------------------------
        this.labelPassword_input = new JLabel("Введите пароль");
        this.labelPassword_input.setFont(BigFontCS);
        this.labelPassword_input.setBounds(x - 330, y + 2 * height, width, height);
        this.jPanel.add(this.labelPassword_input);
//-----------------------------------------------------------------
        this.password_input = new JPasswordField();
        this.password_input.setBounds(x, y + 2 * height, width, height);
        this.password_input.setFont(BigFontCS);
        this.jPanel.add(this.password_input);
//-----------------------------------------------------------------
        this.ent_button_input = new JButton("Войти");
        this.ent_button_input.setBounds(x+150, y + 4 * height, width, height);
        this.ent_button_input.setForeground(Color.BLACK);
        this.ent_button_input.setFont(BigFontCS);
        this.ent_button_input.addActionListener(e -> {        // обработка нажатия
            login_data = getData();
            try {
                this.id = Server.authorization(login_data.get(0), login_data.get(1));
                if (this.id != 0) {
                    this.jPanel.removeAll();                         // очистка панели
                    this.jPanel.repaint();
                    this.jPanel.revalidate();
                    delFrame();
                    if (this.id == 19){
                        new TourManagement(this.id);
                    }else new MainPage(this.id);   //сделать если зашел админ
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        this.jPanel.add(this.ent_button_input);

//-----------------------------------------------------------------
        this.Will_come_back_button = new JButton("Вернуться");
        this.Will_come_back_button.setBounds(x - 270, y + 4 * height, width, height);
        this.Will_come_back_button.setForeground(Color.BLACK);
        this.Will_come_back_button.setFont(BigFontCS);
        this.Will_come_back_button.addActionListener(e -> {        // обработка нажатия
            this.jPanel.removeAll();                         // очистка панели
            this.jPanel.repaint();
            this.jPanel.revalidate();
            delFrame();
            new MainPage(this.id);
        });
        this.jPanel.add(this.Will_come_back_button);
    }
//-----------------------------------------------------------------
    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        if (this.login.getText() != null) {
            data.add(this.login.getText());
            if (this.password_input.getText() != null) {
                data.add(this.password_input.getText());
            }
        }
        return data;
    }
}
