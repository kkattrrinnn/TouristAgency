package com.example;

import javax.swing.*;
import java.awt.*;

public class InitialWindow extends GraphicsWindow {

    Font BigFontCS = new Font("ComicSans", Font.BOLD, 45);
    JButton ent_button;
    JButton reg_button;

    JLabel label_hello_input;
    public boolean entrance;
    public boolean registration;

    /* Создание окна с двумя кнопками - вход и регистрация */
    InitialWindow() {
//-----------------------------------------------------------------
        this.label_hello_input = new JLabel("Tourist Agency");
        this.label_hello_input.setFont(BigFontCS);
        this.label_hello_input.setBounds(400, -300, width, height);
        this.jPanel.add(this.label_hello_input);
//-----------------------------------------------------------------
        this.ent_button = new JButton("Вход");
        this.ent_button.setBounds(350, 170, 400, 100);
        this.ent_button.setBackground(new Color(200, 100, 250, 90));
        this.ent_button.setFont(BigFontCS);
        this.ent_button.addActionListener(e -> {        // обработка нажатия
            this.jPanel.removeAll();                         // очистка панели
            this.jPanel.repaint();
            this.jPanel.revalidate();
            this.entrance = true;
            delFrame();
            new MainPage();});
        this.jPanel.add(this.ent_button);
        
        this.reg_button = new JButton("Регистрация");
        this.reg_button.setBounds(250, 300, 600, 100);
        this.reg_button.setBackground(new Color(200, 100, 250, 90));
        this. reg_button.setFont(BigFontCS);
        this.reg_button.addActionListener(e -> {        // обработка нажатия
            this.jPanel.removeAll();                         // очистка панели
            this.jPanel.repaint();
            this.jPanel.revalidate();
            this.registration = true;
            delFrame();
            RegistrationWindow RW = new RegistrationWindow();});
        this.jPanel.add(this.reg_button);
    }

    public boolean getEntrance() {
        return this.entrance;
    }

    public boolean getRegistration() {
        return this.entrance;
    }

}
