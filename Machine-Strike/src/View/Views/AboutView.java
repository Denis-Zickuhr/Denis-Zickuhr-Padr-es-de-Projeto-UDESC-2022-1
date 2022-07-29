package View.Views;

import javax.swing.*;
import java.awt.*;

public class AboutView extends JDialog {

    public AboutView(Component component) {
        setSize(new Dimension(300,100));
        JPanel jp_contentPane = new JPanel();
        setContentPane(jp_contentPane);
        setTitle("Sobre");
        setLocationRelativeTo(component);
        setModal(true);


        JLabel email = new JLabel("Denis Zickuhr: deniszickuhr@gmail.com");

        add(email);

        setVisible(true);
    }
}