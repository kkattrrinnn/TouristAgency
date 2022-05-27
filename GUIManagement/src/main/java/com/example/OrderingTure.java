package com.example;

import javax.swing.*;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderingTure extends GraphicsWindow{
    JButton Will_come_back_button;
    JButton Tour_design;
    Font BigFontCS = new Font("ComicSans", Font.BOLD, 40);
    JLabel label_Tur_name;
    int x = 300 , y = 30, width = 900 , height = 80;

    public OrderingTure(int id, String Tur_name, ArrayList<String> tours) {
        this.id = id;
        constructor(Tur_name, tours);
    }
    public OrderingTure(String Tur_name, ArrayList<String> tours){
        constructor(Tur_name, tours);
    }

    void constructor(String Tur_name, ArrayList<String> tours) {
//-----------------------------------------------------------------
        this.label_Tur_name = new JLabel("Тур: "+ Tur_name);
        this.label_Tur_name.setFont(BigFontCS);
        this.label_Tur_name.setBounds(x, y, width, height);
        this.jPanel.add(this.label_Tur_name);
//-----------------------------------------------------------------
        this.label_Tur_name = new JLabel("Отправление из города: "+ tours.get(0));
        this.label_Tur_name.setFont(BigFontCS);
        this.label_Tur_name.setBounds(x-200, y+80, width, height);
        this.jPanel.add(this.label_Tur_name);
//-----------------------------------------------------------------
        this.label_Tur_name = new JLabel("Прибытие в город: " + tours.get(1));
        this.label_Tur_name.setFont(BigFontCS);
        this.label_Tur_name.setBounds(x-200, y+160, width, height);
        this.jPanel.add(this.label_Tur_name);


//-----------------------------------------------------------------
        this.label_Tur_name = new JLabel("Дата отправления: " + tours.get(2));
        this.label_Tur_name.setFont(BigFontCS);
        this.label_Tur_name.setBounds(x-200, y+240, width, height);
        this.jPanel.add(this.label_Tur_name);

//-----------------------------------------------------------------

        this.label_Tur_name = new JLabel("Продолжительность тура: " + tours.get(3) + " days");
        this.label_Tur_name.setFont(BigFontCS);
        this.label_Tur_name.setBounds(x-200, y+320, width, height);
        this.jPanel.add(this.label_Tur_name);

//-----------------------------------------------------------------
        this.label_Tur_name = new JLabel("Стоимость тура: " + tours.get(4));
        this.label_Tur_name.setFont(BigFontCS);
        this.label_Tur_name.setBounds(x-200, y+400, width, height);
        this.jPanel.add(this.label_Tur_name);

//-----------------------------------------------------------------
        this.Will_come_back_button = new JButton("Вернуться");
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
        this.Tour_design = new JButton("Заказать тур");
        this.Tour_design.setBounds(x+250, y+480, width-550, height);
        this.Tour_design.setBackground(new Color(255, 128, 128, 90));
        this.Tour_design.setFont(BigFontCS);
        this.Tour_design.addActionListener(e -> {        // обработка нажатия
            this.jPanel.removeAll();                         // очистка панели
            this.jPanel.repaint();
            this.jPanel.revalidate();
            delFrame();
            if (this.id != 0) {
                try {
                    DBProcessor.addOrder(this.id, DBProcessor.getTourId(Tur_name));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                new MyTours(this.id);
            } else {
                System.out.println(this.id);
                System.out.println("Вы не вошли в систему!");
                new LoginWindow();
            }

        });
        this.jPanel.add(this.Tour_design);
    }

//----------------------------------------------------------------

}
