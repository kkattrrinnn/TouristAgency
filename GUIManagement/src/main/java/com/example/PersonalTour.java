package com.example;

import javax.swing.*;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonalTour extends GraphicsWindow{
    JButton Tour_design;
    Font BigFontCS = new Font("ComicSans", Font.BOLD, 40);
    JLabel label_Tur_name;
    int x = 300 , y = 30, width = 900 , height = 80;

    public PersonalTour(int id, String Tur_name, ArrayList<String> tours) {
        this.id = id;
        constructor(Tur_name, tours);
    }
    public PersonalTour(String Tur_name, ArrayList<String> tours){
        constructor(Tur_name, tours);
    }

    void constructor(String Tur_name, ArrayList<String> tours) {
//-----------------------------------------------------------------
        this.label_Tur_name = new JLabel("Ваш тур: "+ Tur_name);
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
        this.Will_come_back_button = new JButton("К турам");
        this.Will_come_back_button.setBounds(x-150, y+480, width-550, height);
        this.Will_come_back_button.setForeground(Color.BLACK);;
        this.Will_come_back_button.setFont(BigFontCS);
        this.Will_come_back_button.addActionListener(e -> {        // обработка нажатия
            this.jPanel.removeAll();                         // очистка панели
            this.jPanel.repaint();
            this.jPanel.revalidate();
            delFrame();
            if (this.id == 19){
                new TourManagement(this.id);
            }else new MyTours(this.id);
        });
        this.jPanel.add(this.Will_come_back_button);
//----------------------------------------------------------------
        this.Tour_design = new JButton("Отменить тур");
        this.Tour_design.setBounds(x+250, y+480, width-550, height);
        this.Tour_design.setForeground(Color.BLACK);;
        this.Tour_design.setFont(BigFontCS);
        this.Tour_design.addActionListener(e -> {        // обработка нажатия
            this.jPanel.removeAll();                         // очистка панели
            this.jPanel.repaint();
            this.jPanel.revalidate();
            delFrame();
            try {
                int order_id = DBProcessor.getOrderId(this.id, DBProcessor.getTourId(Tur_name));
                if (order_id != 0) {
                    DBProcessor.deleteOrder(order_id);          // удаление заказа из БД
                    new MyTours(this.id);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        this.jPanel.add(this.Tour_design);
    }
}