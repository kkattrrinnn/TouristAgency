package com.example;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegistrationWindow extends GraphicsWindow{
    Font BigFontCS = new Font("ComicSans", Font.BOLD, 40);
    JTextField login_Register;
    JPasswordField password_Register;
    JTextField Name_Register;
    JButton ent_button_Register;
    JLabel labelLogin_Register;
    JLabel labelName_Register;
    JLabel labelPassword_Register;

    int x = 400 , y = 190, width = 400 , height = 60;

    public RegistrationWindow(int id) {
        this.id = id;
        constructor();
    }
    public RegistrationWindow() {
        constructor();
    }

    void constructor() {
//-----------------------------------------------------------------
        this.label_hello_input = new JLabel("Регистрация");
        this.label_hello_input.setFont(BigFontCS);
        this.label_hello_input.setBounds(x,y-100,width = 400 , height = 60);
        this.jPanel.add(this.label_hello_input);
//-----------------------------------------------------------------
        this.labelName_Register = new JLabel("Введите имя");
        this.labelName_Register.setFont(BigFontCS);
        this.labelName_Register.setBounds(x-330, y, width, height);
        this.jPanel.add(this.labelName_Register);

        this.Name_Register = new JTextField();
        this.Name_Register.setBounds(x, y, width, height);
        this.Name_Register.setFont(BigFontCS);
        this.jPanel.add(this.Name_Register);
//-----------------------------------------------------------------
        this.labelLogin_Register = new JLabel("Введите логин");
        this.labelLogin_Register.setFont(BigFontCS);
        this.labelLogin_Register.setBounds(x-330, y+height+10, width, height);
        this.jPanel.add(this.labelLogin_Register);

        this.login_Register = new JTextField();
        this.login_Register.setBounds(x, y+height+10, width, height);
        this.login_Register.setFont(BigFontCS);
        this.jPanel.add(this.login_Register);
//-----------------------------------------------------------------
        this.labelPassword_Register = new JLabel("Введите пароль");
        this.labelPassword_Register.setFont(BigFontCS);
        this.labelPassword_Register.setBounds(x-330, y+2*height+20, width, height);
        this.jPanel.add(this.labelPassword_Register);

        this.password_Register = new JPasswordField();
        this.password_Register.setBounds(x, y+2*height+20, width, height);
        this.password_Register.setFont(BigFontCS);
        this.jPanel.add(this.password_Register);
//-----------------------------------------------------------------
        this.ent_button_Register = new JButton("Зарегистрироваться");
        this.ent_button_Register.setBounds(x+100, y+4*height+30, width+50, height);
        this.ent_button_Register.setForeground(Color.BLACK);
        this.ent_button_Register.setFont(BigFontCS);
        this.ent_button_Register.addActionListener(e -> {        // обработка нажатия
            ArrayList<String> registration_data = getData();
            try {
                if (DBProcessor.addUser(registration_data.get(0), registration_data.get(1), registration_data.get(2))) {
                    this.jPanel.removeAll();                         // очистка панели
                    this.jPanel.repaint();
                    this.jPanel.revalidate();
                    delFrame();
                    new LoginWindow();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        this.jPanel.add(this.ent_button_Register);
//-----------------------------------------------------------------
        this.Will_come_back_button = new JButton("Вернуться");
        this.Will_come_back_button.setBounds(x-350, y+4*height+30, width-50, height);
        this.Will_come_back_button.setForeground(Color.BLACK);
        this.Will_come_back_button.setFont(BigFontCS);
        this.Will_come_back_button.addActionListener(e -> {        // обработка нажатия
            this.jPanel.removeAll();                         // очистка панели
            this.jPanel.repaint();
            this.jPanel.revalidate();
            delFrame();
            new MainPage();
        });
        this.jPanel.add(this.Will_come_back_button);
    }

    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        if (this.Name_Register.getText() != null || this.Name_Register.getText() != "") {
            data.add(this.Name_Register.getText());
            if (this.login_Register.getText() != null || this.login_Register.getText() != "") {
                data.add(this.login_Register.getText());
                if (this.password_Register.getText() != null || this.password_Register.getText() != "") {
                    data.add(this.password_Register.getText());
                }
            }
        }
        return data;
    }
}