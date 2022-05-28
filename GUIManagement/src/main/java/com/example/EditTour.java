package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class EditTour extends GraphicsWindow{

    public  String Tur_name;

    public EditTour() {
        constructor();
    }
    public EditTour(int id) {
        this.id = id;
        this.Tur_name = Tur_name;
        constructor();
    }

    JComboBox box_tur;
    JButton Book_a_tour;
    JLabel label_hello_input;
    JButton Will_come_back_button;

    JLabel label_new_value;
    JTextField new_value_input;
    int x = 400 , y = 60, width = 300 , height = 80;
    Font BigFontCS = new Font("ComicSans", Font.BOLD, 30);
    void constructor() {
        //-----------------------------------------------------------------
        this.label_hello_input = new JLabel("Редоктирование тура: " + Tur_name);
        this.label_hello_input.setFont(BigFontCS);
        this.label_hello_input.setBounds(x-150, y, width+300, height);
        this.jPanel.add(this.label_hello_input);
//-------------------------------------------------------------------
        try {
            this.box_tur = new JComboBox(DBProcessor.getTours()); //параметры тура
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
        this.label_new_value = new JLabel("Новое значение");
        this.label_new_value.setFont(BigFontCS);
        this.label_new_value.setBounds(x - 330, y + 3 * height, width, height);
        this.jPanel.add(this.label_new_value);
//-----------------------------------------------------------------
        this.new_value_input = new JTextField();
        this.new_value_input.setBounds(x, y + 3 * height, width+100, height);
        this.new_value_input.setFont(BigFontCS);
        this.jPanel.add(this.new_value_input);
//-----------------------------------------------------------------
        this.Book_a_tour = new JButton("Редактировать");
        this.Book_a_tour.setBounds(x, y+5*height, width, height);
        this.Book_a_tour.setForeground(Color.BLACK);
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
        this.Will_come_back_button.setBounds(x-350, y+5*height, width, height);
        this.Will_come_back_button.setForeground(Color.BLACK);
        this.Will_come_back_button.setFont(BigFontCS);
        this.Will_come_back_button.addActionListener(e -> {        // обработка нажатия
            this.jPanel.removeAll();                         // очистка панели
            this.jPanel.repaint();
            this.jPanel.revalidate();
            delFrame();
            new TourManagement(this.id);  //понять куда вернуться
        });
        this.jPanel.add(this.Will_come_back_button);
//-----------------------------------------------------------------
    }
}
