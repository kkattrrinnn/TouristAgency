package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MyTours extends GraphicsWindow{

    /* Выпадающий список заказов, при выборе заказа в этом же окне появляется его описание (описание тура) */
    JComboBox box_tur;
    String Tur_name;
    JButton Book_a_tour;
    JLabel label_hello_input;
    JButton Will_come_back_button;
    JLabel error_no_tour;
    int x = 400 , y = 60, width = 400 , height = 80;
    Font BigFontCS = new Font("ComicSans", Font.BOLD, 30);
    public MyTours() {
        constructor();
    }
    public MyTours(int id) {
        this.id = id;
        constructor();
    }

    void constructor() {
        //-----------------------------------------------------------------
        try {
            this.label_hello_input = new JLabel("Ваши брони сеер " + DBProcessor.getUserNameById(this.id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.label_hello_input.setFont(BigFontCS);
        this.label_hello_input.setBounds(x, y, width, height);
        this.jPanel.add(this.label_hello_input);
//-------------------------------------------------------------------
        try {
            this.box_tur = new JComboBox(DBProcessor.getUserTours(this.id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.box_tur.setFont(BigFontCS);
        this.box_tur.setBounds(x-100,y+100,width+100,height);
        this.jPanel.add(this.box_tur);
//-----------------------------------------------------------------
        ActionListener actionListener = new ActionListener() { // отслеживаем элемент
            public void actionPerformed(ActionEvent e) {
                JComboBox box = (JComboBox)e.getSource();
                Tur_name = (String)box.getSelectedItem();
            }
        };
        this.box_tur.addActionListener(actionListener);
//-----------------------------------------------------------------
        this.Book_a_tour = new JButton("Подробнее про тур");
        this.Book_a_tour.setBounds(x+150, y+4*height, width, height);
        this.Book_a_tour.setForeground(Color.BLACK);
        this.Book_a_tour.setFont(BigFontCS);
        this.Book_a_tour.addActionListener(e -> {                   // обработка нажатия
            if (Tur_name != null){                                  //если тур не был выбран
                this.jPanel.removeAll();                            // очистка панели
                this.jPanel.repaint();
                this.jPanel.revalidate();
                delFrame();
                try {
                    new PersonalTour(this.id, Tur_name, DBProcessor.getInfoAboutTheTour(Tur_name));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                this.error_no_tour = new JLabel("Тур не выбран"); // сообщение об ошибке
                this.error_no_tour.setVisible(true);
                this.error_no_tour.setFont(BigFontCS);
                this.error_no_tour.setForeground(Color.red);
                this.error_no_tour.setBounds(x, y + 4 * height + 100, width, height);
                this.jPanel.add(this.error_no_tour);
                this.jPanel.repaint();
            }
        });
        this.jPanel.add(this.Book_a_tour);
//-----------------------------------------------------------------
        this.Will_come_back_button = new JButton("Выбрать ещё тур");
        this.Will_come_back_button.setBounds(x-350, y+4*height, width, height);
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
//-----------------------------------------------------------------
    }
}
