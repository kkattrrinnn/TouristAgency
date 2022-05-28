package com.example;

import javax.swing.*;
import java.awt.*;

public class AddTour extends GraphicsWindow{

    Font BigFontCS = new Font("ComicSans", Font.BOLD, 35);
    JLabel labelName_input;
    JTextField Name;
    JLabel labelStarting_input;
    JTextField Starting_input;
    JLabel labelFinal_input;
    JTextField Final_input;
    JLabel labelDate_input;
    JTextField Date_input;
    JLabel labelDuration_input;
    JTextField Duration_input;
    JLabel labelPrice_input;
    JTextField Price_input;
   JButton delete_tour;


    AddTour(int id) {
        this.id = id;
        constructor();
    }

    AddTour() {
        constructor();
    }
    int x = 400 , y = 140, width = 400 , height = 50;
    void constructor() {
        //-----------------------------------------------------------------
        this.label_hello_input = new JLabel("Добавление нового тура");
        this.label_hello_input.setFont(BigFontCS);
        this.label_hello_input.setBounds(x - 110, y - 100, width + 150, height = 60);
        this.jPanel.add(this.label_hello_input);
//-----------------------------------------------------------------
        this.labelName_input = new JLabel("Название тура");
        this.labelName_input.setFont(BigFontCS);
        this.labelName_input.setBounds(x - 350, y, width, height);
        this.jPanel.add(this.labelName_input);
//----------------------------------------------------------------
        this.Name = new JTextField();
        this.Name.setBounds(x, y, width, height);
        this.Name.setFont(BigFontCS);
        this.jPanel.add(this.Name);
//-----------------------------------------------------------------
        this.labelStarting_input = new JLabel("Город отправления");
        this.labelStarting_input.setFont(BigFontCS);
        this.labelStarting_input.setBounds(x - 350, y + 2 * height - 50, width, height);
        this.jPanel.add(this.labelStarting_input);
//-----------------------------------------------------------------
        this.Starting_input = new JTextField();
        this.Starting_input.setBounds(x, y + 2 * height - 50, width, height);
        this.Starting_input.setFont(BigFontCS);
        this.jPanel.add(this.Starting_input);
//-----------------------------------------------------------------
        this.labelFinal_input = new JLabel("Город прибытия");
        this.labelFinal_input.setFont(BigFontCS);
        this.labelFinal_input.setBounds(x - 350, y + 3 * height - 40, width, height);
        this.jPanel.add(this.labelFinal_input);
//-----------------------------------------------------------------
        this.Final_input = new JTextField();
        this.Final_input.setBounds(x, y + 3 * height - 40, width, height);
        this.Final_input.setFont(BigFontCS);
        this.jPanel.add(this.Final_input );
//-----------------------------------------------------------------
        this.labelDate_input = new JLabel("Дата отправления");
        this.labelDate_input.setFont(BigFontCS);
        this.labelDate_input.setBounds(x - 350, y + 4 * height - 30, width, height);
        this.jPanel.add(this.labelDate_input);
//-----------------------------------------------------------------
        this.Date_input = new JTextField();
        this.Date_input.setBounds(x, y + 4 * height - 30, width, height);
        this.Date_input.setFont(BigFontCS);
        this.jPanel.add(this.Date_input);
//-----------------------------------------------------------------
        this.labelDuration_input = new JLabel("Длительность тура");
        this.labelDuration_input.setFont(BigFontCS);
        this.labelDuration_input.setBounds(x - 350, y + 5 * height - 20, width, height);
        this.jPanel.add(this.labelDuration_input);
//-----------------------------------------------------------------
        this.Duration_input = new JTextField();
        this.Duration_input.setBounds(x, y + 5 * height - 20, width, height);
        this.Duration_input.setFont(BigFontCS);
        this.jPanel.add(this.Duration_input);
//-----------------------------------------------------------------
        this.labelPrice_input = new JLabel("Стоимость тура");
        this.labelPrice_input.setFont(BigFontCS);
        this.labelPrice_input.setBounds(x - 350, y + 6 * height - 10, width, height);
        this.jPanel.add(this.labelPrice_input);
//-----------------------------------------------------------------
        this.Price_input = new JTextField();
        this.Price_input.setBounds(x, y + 6 * height - 10, width, height);
        this.Price_input.setFont(BigFontCS);
        this.jPanel.add(this.Price_input);
//-----------------------------------------------------------------
        this.delete_tour = new JButton("Добавить тур");
        this.delete_tour.setBounds(x + 250, y + 7 * height, width, height);
        this.delete_tour.setForeground(Color.BLACK);
        this.delete_tour.setFont(BigFontCS);
        this.delete_tour.addActionListener(e -> {        // обработка нажатия
            this.jPanel.removeAll();                         // очистка панели
            this.jPanel.repaint();
            this.jPanel.revalidate();  //сделать удаление
            delFrame();
            new AddTour(this.id);
        });
        this.jPanel.add(this.delete_tour);
//-----------------------------------------------------------------
        this.Will_come_back_button = new JButton("Вернуться");
        this.Will_come_back_button.setBounds(x - 250, y + 7 * height, width, height);
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
