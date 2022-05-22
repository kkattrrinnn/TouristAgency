import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialWindow extends GraphicsWindow {

    Font BigFontCS = new Font("ComicSans", Font.BOLD, 45);
    JButton ent_button;
    JButton reg_button;

    /* Создание окна с двумя кнопками - вход и регистрация */
    InitialWindow() {
        this.ent_button = new JButton("Вход");
        this.ent_button.setBounds(350, 170, 400, 100);
        this.ent_button.setBackground(new Color(200, 100, 250, 90));
        this.ent_button.setFont(BigFontCS);
        this.ent_button.addActionListener(e -> {        // обработка нажатия
            jPanel.removeAll();                         // очистка панели
            jPanel.repaint();
            jPanel.revalidate();
            jFrame.dispose();
            LoginWindow LW = new LoginWindow();});        // создание страницы для входа
        jPanel.add(this.ent_button);
        
        this.reg_button = new JButton("Регистрация");
        this.reg_button.setBounds(250, 300, 600, 100);
        this.reg_button.setBackground(new Color(200, 100, 250, 90));
        this. reg_button.setFont(BigFontCS);
        this.reg_button.addActionListener(e -> {        // обработка нажатия
            jPanel.removeAll();                         // очистка панели
            jPanel.repaint();
            jPanel.revalidate();
            jFrame.dispose();
            RegistrationWindow RW = new RegistrationWindow(jFrame, jPanel);});      // создание страницы для регистрации
        jPanel.add(this.reg_button);
    }

}
