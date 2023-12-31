package ro.tuc.Controller;

import ro.tuc.MathOperations.Operatii;
import ro.tuc.Model.Polinom;
import ro.tuc.View.ErrorPopUp;
import ro.tuc.View.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import static ro.tuc.MathOperations.Operatii.addPol;

public class Controller {
    GUI view = new GUI();

    public Controller() {
        view.adunareListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom p1 = getPol1();
                Polinom p2 = getPol2();
                if (p1 == null || p2 == null)
                    return;
                Polinom rezultat = Operatii.addPol(p1, p2);
                if (Operatii.addPol(p1, p2).getPol().isEmpty())
                    view.textRezultat.setText("0");
                else {
                    view.textRezultat.setText(rezultat.toString());
                }

            }
        });
        view.scadereListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom p1 = getPol1();
                Polinom p2 = getPol2();
                if (p1 == null || p2 == null)
                    return;
                Polinom rezultat = Operatii.subPol(p1, p2);
                if (Operatii.subPol(p1, p2).getPol().isEmpty())
                    view.textRezultat.setText("0");
                else {
                    view.textRezultat.setText(rezultat.toString());
                }
            }
        });

        view.inmultireListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom p1 = getPol1();
                Polinom p2 = getPol2();
                if (p1 == null || p2 == null) {
                    return;
                }
                Polinom rezultat = Operatii.multiplyPol(p1, p2);
                view.textRezultat.setText(rezultat.toString());
            }
        });

        view.impartireListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom p1 = getPol1();
                Polinom p2 = getPol2();
                if (p1 == null || p2 == null) {
                    return;
                }


                    ArrayList rezultat = Operatii.dividePol(p1, p2);
                    view.textRezultat.setText(rezultat.get(0).toString() + " | " + rezultat.get(1).toString());

            }
        });

        view.derivareListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom p1 = getPol1();
                if (p1 == null) {
                    return;
                }
                Polinom rezultat = Operatii.derivarePol(p1);
                view.textRezultat.setText(rezultat.toString());

            }
        });

        view.integrareListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom p1 = getPol1();
                if (p1 == null) {
                    return;

                }
                Polinom rezultat = Operatii.integrarePol(p1);
                view.textRezultat.setText(rezultat.toString());
            }
        });
    }

    public Polinom getPol1() {

        try {
            return new Polinom(view.getTextPol1());
        } catch (IllegalArgumentException exception) {
            new ErrorPopUp("Lipseste polinomul 1");
        }
        return null;
    }

    public Polinom getPol2() {

        try {
            return new Polinom(view.getTextPol2());
        } catch (IllegalArgumentException exception) {
            new ErrorPopUp("Lipseste polinomul 2");
        }
        return null;
    }


}
