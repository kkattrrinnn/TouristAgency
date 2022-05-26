package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class MainPage extends GraphicsWindow{
    Font BigFontCS = new Font("ComicSans", Font.BOLD, 40);
    JLabel label_hello_input;
    int x = 400 , y = 60, width = 400 , height = 80;
    public static String Tur_name;
    JComboBox box_tur;
    JButton Book_a_tour;
    String[] items = {"Элемент списка 1", "Элемент списка 2", "Элемент списка 3"};
    MainPage() {
//-----------------------------------------------------------------
        this.label_hello_input = new JLabel("Tourist Agency");
        this.label_hello_input.setFont(BigFontCS);
        this.label_hello_input.setBounds(x, y, width, height);
        this.jPanel.add(this.label_hello_input);
//-----------------------------------------------------------------
        box_tur = new JComboBox(items);
        box_tur.setFont(BigFontCS);
        box_tur.setBounds(x,y+100,width+100,height);
        jPanel.add(box_tur);

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox box = (JComboBox)e.getSource();
                Tur_name = (String)box.getSelectedItem();

            }
        };
        box_tur.addActionListener(actionListener);
//-----------------------------------------------------------------
        this.Book_a_tour = new JButton("Заказать тур");
        this.Book_a_tour.setBounds(x, y+4*height, width, height);
        this.Book_a_tour.setBackground(new Color(255, 128, 128, 90));
        this.Book_a_tour.setFont(BigFontCS);
        this.Book_a_tour.addActionListener(e -> {        // обработка нажатия

            this.jPanel.removeAll();                         // очистка панели
            this.jPanel.repaint();
            this.jPanel.revalidate();
            delFrame();
            OrderingTure OT = new OrderingTure();
        });
        this.jPanel.add(this.Book_a_tour);
    }
    }

