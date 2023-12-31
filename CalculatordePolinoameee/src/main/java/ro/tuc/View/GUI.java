package ro.tuc.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame  {

    JLabel pol1Label = new JLabel("Polinom 1");
    JTextField textPolinom1 = new JTextField();
    JLabel pol2Label = new JLabel("Polinom 2");
    JTextField textPolinom2 = new JTextField();
    JLabel polRezlabel = new JLabel("Rezultat");
    public JTextField textRezultat = new JTextField();
    JPanel buttonGrid = new JPanel(new GridLayout(2,3));
    JButton buttonAdunare = new JButton("+");
    JButton buttonScadere = new JButton("-");
    JButton buttonInmultire = new JButton("*");
    JButton buttonImpartire = new JButton("/");
    JButton buttonDerivare = new JButton("d/dx");
    JButton buttonIntegrare = new JButton("∫...dx");

    public GUI()
    {
        String title = "Claculator de polinoame";
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500,450);
        setTitle(title);
        setResizable(false);
        setLocationRelativeTo(null);
        pol1Label.setBounds(10,10,100,50);
        textPolinom1.setBounds(110,25,300,25);
        pol2Label.setBounds(10,40,100,50);
        textPolinom2. setBounds(110,55,300,25);
        polRezlabel.setBounds(10,300,100,50);
        textRezultat.setBounds(110,315,300,25);

        buttonGrid.add(buttonAdunare);
        buttonGrid.add(buttonScadere);
        buttonGrid.add(buttonInmultire);
        buttonGrid.add(buttonImpartire);
        buttonGrid.add(buttonDerivare);
        buttonGrid.add(buttonIntegrare);

        for(Component b:buttonGrid.getComponents())
        {
            b.setBackground(new Color(120, 124, 124));
            b.setForeground(new Color(255, 255, 255));

            buttonGrid.add(b);
        }

        buttonGrid.setBounds(135,150,200,100);
        add(buttonGrid);
        add(pol1Label);
        add(textPolinom1);
        add(pol2Label);
        add(textPolinom2);
        add(polRezlabel);
        add(textRezultat);

        setVisible(true);

    }

    public void adunareListener(ActionListener l)
    {
        buttonAdunare.addActionListener(l);
    }

    public void scadereListener(ActionListener l)
    {
        buttonScadere.addActionListener(l);
    }

    public void inmultireListener(ActionListener l)
    {
        buttonInmultire.addActionListener(l);
    }

    public void impartireListener(ActionListener l)
    {
        buttonImpartire.addActionListener(l);
    }

    public void derivareListener(ActionListener l)
    {
        buttonDerivare.addActionListener(l);
    }

    public void integrareListener(ActionListener l)
    {
        buttonIntegrare.addActionListener(l);
    }

    public String getTextPol1()
    {
        return textPolinom1.getText();
    }

    public String getTextPol2()
    {
        return textPolinom2.getText();
    }

    public void setRezultat(String text)
    {
        textRezultat.setText(text);
    }
}

