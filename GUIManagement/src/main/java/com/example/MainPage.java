package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainPage extends GraphicsWindow{
    Font BigFontCS = new Font("ComicSans", Font.BOLD, 40);
    JLabel label_hello_input;
    int x = 400 , y = 60, width = 400 , height = 80;
    String Tur_name,starting_city,destination_city,duration, Dates;
    int Tour_cost;
    JComboBox box_tur;
    JButton Book_a_tour;
    JButton ent_button_MainPage;
    String[] items = {"Выберете тур", "Элемент списка 1", "Элемент списка 2", "Элемент списка 3"};
    MainPage() {
//-----------------------------------------------------------------
        this.label_hello_input = new JLabel("Tourist Agency");
        this.label_hello_input.setFont(BigFontCS);
        this.label_hello_input.setBounds(x, y, width, height);
        this.jPanel.add(this.label_hello_input);
//-----------------------------------------------------------------
        box_tur = new JComboBox(items);
        box_tur.setFont(BigFontCS);
        box_tur.setBounds(x-100,y+100,width+100,height);
        jPanel.add(box_tur);
//-----------------------------------------------------------------
        starting_city = "Москва";
        destination_city = "Второй город";
        duration = "12 ночей";
        Dates = "C 08.02.22 по 08.02.2021";
        Tour_cost = 20000;
//-----------------------------------------------------------------
        ActionListener actionListener = new ActionListener() { // отслеживаем элемент
            public void actionPerformed(ActionEvent e) {
                JComboBox box = (JComboBox)e.getSource();
                Tur_name = (String)box.getSelectedItem();
            }
        };
        box_tur.addActionListener(actionListener);
//-----------------------------------------------------------------
        this.Book_a_tour = new JButton("Подробнее");
        this.Book_a_tour.setBounds(x-50, y+4*height, width, height);
        this.Book_a_tour.setBackground(new Color(255, 128, 128, 90));
        this.Book_a_tour.setFont(BigFontCS);
        this.Book_a_tour.addActionListener(e -> {        // обработка нажатия
            if (Tur_name != null){ //если тур небыл выбран
                this.jPanel.removeAll();                         // очистка панели
                this.jPanel.repaint();
                this.jPanel.revalidate();
                delFrame();
                OrderingTure OT = new OrderingTure(Tur_name, starting_city, destination_city, duration, Dates, Tour_cost);
            }else{
                this.jPanel.removeAll();                         // очистка панели
                this.jPanel.repaint();
                this.jPanel.revalidate();
                delFrame();
                new MainPage();
            }

        });
        this.jPanel.add(this.Book_a_tour);
//-----------------------------------------------------------------
        this.ent_button_MainPage = new JButton("Авторизация");
        this.ent_button_MainPage.setBounds(x-50, y+5*height+30, width, height);
        this.ent_button_MainPage.setBackground(new Color(200, 100, 250, 90));
        this.ent_button_MainPage.setFont(BigFontCS);
        this.ent_button_MainPage.addActionListener(e -> {        // обработка нажатия
            this.jPanel.removeAll();                         // очистка панели
            this.jPanel.repaint();
            this.jPanel.revalidate();
            delFrame();
            new LoginWindow();});
        this.jPanel.add(this.ent_button_MainPage);
    }
}

