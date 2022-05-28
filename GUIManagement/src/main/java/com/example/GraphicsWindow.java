package com.example;

import javax.swing.*;
import java.awt.*;

public class GraphicsWindow{
    public JFrame jFrame;
    public JPanel jPanel;
    public int width = 1100;                        // размеры окна
    public int height = 700;

    public int id = 0;
    GraphicsWindow() {
        this.jFrame = new JFrame();
        ImageIcon img = new ImageIcon("GUIManagement/img/Icon.jpg");
        this.jFrame.setIconImage(img.getImage());  // иконка приложения

        Toolkit toolkit = Toolkit.getDefaultToolkit();      // расположение по центру
        Dimension dimension = toolkit.getScreenSize();
        this.jFrame.setBounds(dimension.width/2-width/2,dimension.height/2-height/2, width, height);
        this.jFrame.setTitle("Tourist Agency");
        this.jFrame.setResizable(false);
        this.jFrame.setVisible(true);                // видимость окна
        this.jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   // для закрытия окна
        this.jFrame.setLayout(null);

        this.jPanel = new JPanel();      // создание панели
        this.jPanel.setSize(1100, 700);
        this.jPanel.setVisible(true);
        this.jPanel.setLayout(null);
        this.jFrame.add(this.jPanel);
    }

    public void delFrame() {
        this.jFrame.dispose();
    }

    public static void main(String[] args) {
        GraphicsWindow GW = new GraphicsWindow();
    }
}
