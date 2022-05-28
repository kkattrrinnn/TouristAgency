package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class MainPage extends GraphicsWindow{
    Font BigFontCS = new Font("ComicSans", Font.BOLD, 30);
    JLabel label_hello_input;
    int x = 400 , y = 60, width = 400 , height = 80;
    String Tur_name;
    JComboBox box_tur;
    JButton Book_a_tour;
    JButton ent_button_MainPage;
    JButton reg_button;

    JButton Tour_design;
    JLabel error_no_tour;

    MainPage(int id) {
        this.id = id;
        constructor();
    }

    MainPage() {
        constructor();
    }

    void constructor() {
        //-----------------------------------------------------------------
        this.label_hello_input = new JLabel("Tourist Agency");
        this.label_hello_input.setFont(BigFontCS);
        this.label_hello_input.setBounds(x, y, width, height);
        this.jPanel.add(this.label_hello_input);
//-----------------------------------------------------------------
        try {
            this.box_tur = new JComboBox(DBProcessor.getTours());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.jPanel.add(this.box_tur);
        this.box_tur.setFont(BigFontCS);
        this.box_tur.setBounds(x-100,y+100,width+100,height);

//-----------------------------------------------------------------
        ActionListener actionListener = new ActionListener() { // отслеживаем элемент
            public void actionPerformed(ActionEvent e) {
                JComboBox box = (JComboBox)e.getSource();
                Tur_name = (String)box.getSelectedItem();
            }
        };
        this.box_tur.addActionListener(actionListener);
//-----------------------------------------------------------------
        this.Book_a_tour = new JButton("Подробнее");
        this.jPanel.add(this.Book_a_tour);

        this.Book_a_tour.setBounds(x-50, y+3*height, width, height);
        this.Book_a_tour.setForeground(Color.BLACK);
        this.Book_a_tour.setFont(BigFontCS);
        this.Book_a_tour.addActionListener(e -> {                   // обработка нажатия
            if (Tur_name != null){                                  //если тур не был выбран
                this.jPanel.removeAll();                            // очистка панели
                this.jPanel.repaint();
                this.jPanel.revalidate();
                delFrame();
                try {
                    new OrderingTure(this.id, Tur_name, DBProcessor.getInfoAboutTheTour(Tur_name));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }else {
                this.error_no_tour = new JLabel("Тур не выбран"); // сообщение об ошибке
                this.error_no_tour.setVisible(true);
                this.error_no_tour.setFont(BigFontCS);
                this.error_no_tour.setForeground(Color.red);
                this.error_no_tour.setBounds(x, y + 4 * height + 100, width, height);
                this.jPanel.add(this.error_no_tour);
                this.jPanel.repaint();
            }
        });

//-----------------------------------------------------------------
        if (this.id == 0) {
            this.ent_button_MainPage = new JButton("Авторизация");
            this.jPanel.add(this.ent_button_MainPage);

            this.ent_button_MainPage.setBounds(x + 200, y + 4 * height + 30, width, height);
            this.ent_button_MainPage.setForeground(Color.BLACK);
            this.ent_button_MainPage.setFont(BigFontCS);
            this.ent_button_MainPage.addActionListener(e -> {        // обработка нажатия
                this.jPanel.removeAll();                         // очистка панели
                this.jPanel.repaint();
                this.jPanel.revalidate();
                delFrame();
                new LoginWindow();
            });
//-----------------------------------------------------------------
            this.reg_button = new JButton("Регистрация");
            this.jPanel.add(this.reg_button);

            this.reg_button.setBounds(x - 280, y + 4 * height + 30, width, height);
            this.reg_button.setForeground(Color.BLACK);
            this.reg_button.setFont(BigFontCS);
            this.reg_button.addActionListener(e -> {        // обработка нажатия
                this.jPanel.removeAll();                         // очистка панели
                this.jPanel.repaint();
                this.jPanel.revalidate();
                delFrame();
                new RegistrationWindow();
            });
        }else{
            this.reg_button = new JButton("Выйти из акаунта");
            this.reg_button.setBounds(x+200, y + 4 * height + 30, width, height);
            this.reg_button.setForeground(Color.BLACK);
            this.reg_button.setFont(BigFontCS);
            this.reg_button.addActionListener(e -> {        // обработка нажатия
                this.jPanel.removeAll();                         // очистка панели
                this.jPanel.repaint();
                this.jPanel.revalidate();
                delFrame();
                new MainPage();
            });
            this.jPanel.add(this.reg_button);
 //----------------------------------------------------------------
            if (this.id == 19){
                this.Tour_design = new JButton("Менеджмент");
            }else this.Tour_design = new JButton("Мои туры");
            this.jPanel.add(this.Tour_design);

            this.Tour_design.setBounds(x - 280, y + 4 * height + 30, width, height);
            this.Tour_design.setForeground(Color.BLACK);
            this.Tour_design.setFont(BigFontCS);
            this.Tour_design.addActionListener(e -> {        // обработка нажатия
                this.jPanel.removeAll();                         // очистка панели
                this.jPanel.repaint();
                this.jPanel.revalidate();
                delFrame();
                    try {
                        DBProcessor.addOrder(this.id, DBProcessor.getTourId(Tur_name));
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    if (this.id ==19){
                        new TourManagement(this.id);
                    }else {
                        new MyTours(this.id);
                    }
            });
        }
    }
}
