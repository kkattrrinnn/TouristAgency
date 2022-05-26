package com.example;

import javax.swing.*;

import java.awt.*;

public class OrderingTure extends GraphicsWindow{
    JButton Will_come_back_button;
    JButton Tour_design;
    Font BigFontCS = new Font("ComicSans", Font.BOLD, 45);
    JLabel label_Tur_name;
    int x = 300 , y = 30, width = 900 , height = 80;
    OrderingTure(String Tur_name, String starting_city, String destination_city, String duration, String Dates, int Tour_cost){
        System.out.println(Tur_name);
//-----------------------------------------------------------------
        this.label_Tur_name = new JLabel("Тур: "+ Tur_name);
        this.label_Tur_name.setFont(BigFontCS);
        this.label_Tur_name.setBounds(x, y, width, height);
        this.jPanel.add(this.label_Tur_name);
//-----------------------------------------------------------------
        this.label_Tur_name = new JLabel("Отправление из города: "+ starting_city);
        this.label_Tur_name.setFont(BigFontCS);
        this.label_Tur_name.setBounds(x-200, y+80, width, height);
        this.jPanel.add(this.label_Tur_name);
//-----------------------------------------------------------------
        this.label_Tur_name = new JLabel("Прибытие в город: " + destination_city);
        this.label_Tur_name.setFont(BigFontCS);
        this.label_Tur_name.setBounds(x-200, y+160, width, height);
        this.jPanel.add(this.label_Tur_name);


//-----------------------------------------------------------------
        this.label_Tur_name = new JLabel("Продолжительность: " + duration);
        this.label_Tur_name.setFont(BigFontCS);
        this.label_Tur_name.setBounds(x-200, y+240, width, height);
        this.jPanel.add(this.label_Tur_name);

//-----------------------------------------------------------------

        this.label_Tur_name = new JLabel("Даты тура: " + Dates);
        this.label_Tur_name.setFont(BigFontCS);
        this.label_Tur_name.setBounds(x-200, y+320, width, height);
        this.jPanel.add(this.label_Tur_name);

//-----------------------------------------------------------------
        this.label_Tur_name = new JLabel("Стоимность тура: " + Tour_cost);
        this.label_Tur_name.setFont(BigFontCS);
        this.label_Tur_name.setBounds(x-200, y+400, width, height);
        this.jPanel.add(this.label_Tur_name);

//-----------------------------------------------------------------
        this.Will_come_back_button = new JButton("Вернутся");
        this.Will_come_back_button.setBounds(x-150, y+480, width-550, height);
        this.Will_come_back_button.setBackground(new Color(255, 128, 128, 90));
        this.Will_come_back_button.setFont(BigFontCS);
        this.Will_come_back_button.addActionListener(e -> {        // обработка нажатия
            this.jPanel.removeAll();                         // очистка панели
            this.jPanel.repaint();
            this.jPanel.revalidate();
            delFrame();
            new MainPage();
        });
        this.jPanel.add(this.Will_come_back_button);
//----------------------------------------------------------------
        this.Tour_design = new JButton("Оформить");
        this.Tour_design.setBounds(x+250, y+480, width-550, height);
        this.Tour_design.setBackground(new Color(255, 128, 128, 90));
        this.Tour_design.setFont(BigFontCS);
        this.Tour_design.addActionListener(e -> {        // обработка нажатия
            this.jPanel.removeAll();                         // очистка панели
            this.jPanel.repaint();
            this.jPanel.revalidate();
            delFrame();
            // отправить человека на авторизацию если он не зашел
            new MainPage();  //надо сделать на страницу заказа
        });
        this.jPanel.add(this.Tour_design);
    }


//----------------------------------------------------------------

}
