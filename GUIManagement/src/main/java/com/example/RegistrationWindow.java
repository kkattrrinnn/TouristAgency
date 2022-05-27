package com.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RegistrationWindow extends GraphicsWindow{
    Font BigFontCS = new Font("ComicSans", Font.BOLD, 40);
    JTextField login_Register;
    JTextField password_Register;
    JTextField Name_Register;
    JButton ent_button_Register;
    JButton Will_come_back_button;
    JLabel labelLogin_Register;
    JLabel labelName_Register;
    JLabel labelPassword_Register;
    JLabel label_hello_Register;

    JLabel error_no_login;
    int x = 400 , y = 190, width = 400 , height = 60;
    public Boolean entrance_Register;
    RegistrationWindow() {
        this.entrance_Register = false;
 //-----------------------------------------------------------------
        this.error_no_login = new JLabel("Пользователь не обнаружен, зарегистрируйтесь");  // сообщение об ошибке
        this.error_no_login.setFont(BigFontCS);
        this.error_no_login.setForeground(Color.red);
        this.error_no_login.setBounds(x-350,y-110,width = 1000 , height = 60);
        this.jPanel.add(this.error_no_login);
//-----------------------------------------------------------------
        this.label_hello_Register = new JLabel("Регистрация");
        this.label_hello_Register.setFont(BigFontCS);
        this.label_hello_Register.setBounds(x,y-60,width = 400 , height = 60);
        this.jPanel.add(this.label_hello_Register);
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

        this.password_Register = new JTextField();
        this.password_Register.setBounds(x, y+2*height+20, width, height);
        this.password_Register.setFont(BigFontCS);
        this.jPanel.add(this.password_Register);
//-----------------------------------------------------------------

        this.ent_button_Register = new JButton("Зарегистрироватся");
        this.ent_button_Register.setBounds(x+100, y+4*height+30, width+50, height);
        this.ent_button_Register.setBackground(new Color(255, 128, 128, 90));
        this.ent_button_Register.setFont(BigFontCS);
        this.ent_button_Register.addActionListener(e -> {        // обработка нажатия
            this.jPanel.removeAll();                         // очистка панели
            this.jPanel.repaint();
            this.jPanel.revalidate();});

        this.entrance_Register = true;
        this.jPanel.add(this.ent_button_Register);
//-----------------------------------------------------------------
        this.Will_come_back_button = new JButton("Вернутся");
        this.Will_come_back_button.setBounds(x-350, y+4*height+30, width-50, height);
        this.Will_come_back_button.setBackground(new Color(255, 128, 128, 90));
        this.Will_come_back_button.setFont(BigFontCS);
        this.Will_come_back_button.addActionListener(e -> {        // обработка нажатия
            this.jPanel.removeAll();                         // очистка панели
            this.jPanel.repaint();
            this.jPanel.revalidate();
            delFrame();
            new InitialWindow();
        });
        this.jPanel.add(this.Will_come_back_button);
    }
//----------------------------------------------------------------

}