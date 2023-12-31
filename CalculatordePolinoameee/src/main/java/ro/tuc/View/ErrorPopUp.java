package ro.tuc.View;

import javax.swing.*;

public class ErrorPopUp extends JFrame {

    public ErrorPopUp(String t)
    {
        String title = "Claculator de polinoame";
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(400,250);
        setTitle(title);
        setResizable(false);
        setLocationRelativeTo(null);

        JLabel error = new JLabel(t);
        error.setBounds(10,10,300,100);
        add(error);
        setVisible(true);
    }
}
