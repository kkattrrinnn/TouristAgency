package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TourManagement extends GraphicsWindow{

    JComboBox box_tur;
    String Tur_name;
    JButton Book_a_tour;
    JLabel label_hello_input;
    JButton Will_come_back_button;
    JButton delete_tour;

    JButton reg_button;
    int x = 400 , y = 60, width = 300 , height = 80;
    Font BigFontCS = new Font("ComicSans", Font.BOLD, 30);
    public TourManagement() {
        constructor();
    }
    public TourManagement(int id) {
        this.id = id;
        constructor();
    }

    void constructor() {
        //-----------------------------------------------------------------
        this.label_hello_input = new JLabel("Все туры в приложении: админ "+this.id);
        this.label_hello_input.setFont(BigFontCS);
        this.label_hello_input.setBounds(x-150, y, width+300, height);
        this.jPanel.add(this.label_hello_input);
//-------------------------------------------------------------------
        try {
            this.box_tur = new JComboBox(DBProcessor.getTours());
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
        this.Book_a_tour = new JButton("Редактировать");
        this.Book_a_tour.setBounds(x, y+4*height, width, height);
        this.Book_a_tour.setBackground(new Color(255, 128, 128, 90));
        this.Book_a_tour.setFont(BigFontCS);
        this.Book_a_tour.addActionListener(e -> {                   // обработка нажатия
            if (Tur_name != null){                                  //если тур не был выбран
                this.jPanel.removeAll();                            // очистка панели
                this.jPanel.repaint();
                this.jPanel.revalidate();   //сделать редактирования если захотим
                delFrame();
                try {
                    new PersonalTour(this.id, Tur_name, DBProcessor.getInfoAboutTheTour(Tur_name));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        this.jPanel.add(this.Book_a_tour);
//-----------------------------------------------------------------
        this.Will_come_back_button = new JButton("Вернутся");
        this.Will_come_back_button.setBounds(x-350, y+4*height, width, height);
        this.Will_come_back_button.setBackground(new Color(255, 128, 128, 90));
        this.Will_come_back_button.setFont(BigFontCS);
        this.Will_come_back_button.addActionListener(e -> {        // обработка нажатия
            this.jPanel.removeAll();                         // очистка панели
            this.jPanel.repaint();
            this.jPanel.revalidate();
            delFrame();
            new MainPage(this.id);  //понять куда вернуться
        });
        this.jPanel.add(this.Will_come_back_button);
//-----------------------------------------------------------------
        this.delete_tour = new JButton("Удалить");
        this.delete_tour.setBounds(x+350, y+4*height, width, height);
        this.delete_tour.setBackground(new Color(255, 128, 128, 90));
        this.delete_tour.setFont(BigFontCS);
        this.delete_tour.addActionListener(e -> {        // обработка нажатия
            this.jPanel.removeAll();                         // очистка панели
            this.jPanel.repaint();
            this.jPanel.revalidate();  //сделать удаление
            delFrame();
            new TourManagement(this.id);
        });
        this.jPanel.add(this.delete_tour);

        this.reg_button = new JButton("Выйти из акаунта");
        this.reg_button.setBounds(x, y + 5 * height + 50, width, height);
        this.reg_button.setBackground(new Color(200, 100, 250, 90));
        this.reg_button.setFont(BigFontCS);
        this.reg_button.addActionListener(e -> {        // обработка нажатия
            this.jPanel.removeAll();                         // очистка панели
            this.jPanel.repaint();
            this.jPanel.revalidate();
            delFrame();
            new MainPage();
        });
        this.jPanel.add(this.reg_button);
//-----------------------------------------------------------------
    }
}
