package ro.tuc.MathOperations;

import ro.tuc.Model.Monom;
import ro.tuc.Model.Polinom;

import java.util.ArrayList;

public class Operatii {

    public static Polinom addPol(Polinom op1, Polinom op2) {

        Polinom rezultat = new Polinom(op1);
        for (Monom monom : op2.getPol().descendingMap().values()) {
            rezultat.addMonom(monom);
        }

        return rezultat;
    }

    public static Polinom subPol(Polinom op1, Polinom op2) {
        Polinom rezultat = new Polinom(op1);

        for (Monom monom : op2.getPol().values()) {
            rezultat.subMonom(monom);
        }

        return rezultat;
    }

    public static Polinom multiplyPol(Polinom op1, Polinom op2) {


        Polinom rezultat = new Polinom();
        for (Monom monom : op2.getPol().descendingMap().values()) {
            Polinom intermediar = op1.multiplyMonom(monom);
            rezultat = Operatii.addPol(rezultat, intermediar);
        }
        return rezultat;
    }

    public static ArrayList<Polinom> dividePol(Polinom numarator, Polinom numitor) {
        ArrayList<Polinom> rezultat = new ArrayList<>();
        numitor.delZerocoef();
        numarator.delZerocoef();
        if (numarator.getPol().isEmpty()) {
            throw new IllegalArgumentException("Numarator este gol");
        }
        if (numitor.getPol().isEmpty()) {
            throw new IllegalArgumentException("Numitor-ul este gol");
        }
        Polinom q = new Polinom();
        Polinom r = new Polinom(numarator);
        Integer rMaxdegree = r.maxDegree();
        Integer numMaxdegree = numitor.maxDegree();
        while (!r.getPol().isEmpty() && rMaxdegree >= numMaxdegree) {
            Polinom T = new Polinom();
            Monom t = new Monom();
            t.setGrad(r.getPol().get(rMaxdegree).getGrad() - numitor.getPol().get(numMaxdegree).getGrad());
            t.setCoef(r.getPol().get(rMaxdegree).getCoef() / numitor.getPol().get(numMaxdegree).getCoef());
            T.getPol().put(t.getGrad(), t);
            q = Operatii.addPol(q, T);
            q.delZerocoef();
            r = Operatii.subPol(r, Operatii.multiplyPol(T, numitor));
            r.delZerocoef();
            rMaxdegree = r.maxDegree();
        }
        rezultat.add(q);
        rezultat.add(r);
        return rezultat;
    }

    public static Polinom derivarePol(Polinom op1) {


        Polinom rezultat = new Polinom();

        for (Monom m : op1.getPol().descendingMap().values()) {
            Double coefNou;
            Integer gradNou;

            if(m.getGrad()<=0)
            {gradNou = 0;
                coefNou = 0.0;}
            else {
                gradNou = m.getGrad() - 1;
                coefNou = m.getCoef() * m.getGrad();
            }

            Monom monomNou = new Monom(coefNou, gradNou);
            rezultat.getPol().put(gradNou, monomNou);
        }
        //rezultat.delZerocoef();
        return rezultat;
    }

    public static Polinom integrarePol(Polinom op1)
    {

        Polinom rezultat = new Polinom();
        for(Monom m : op1.getPol().descendingMap().values())
        {
            Double coefNou=0.0;
            Integer gradNou=0;
            if(m.getGrad()==0)
            {
                gradNou = 1;
                coefNou = m.getCoef();
            }
            else{
                coefNou = m.getCoef()/(m.getGrad()+1);
                gradNou = m.getGrad()+1;
            }
            Monom monomNou = new Monom(coefNou, gradNou);
            rezultat.getPol().put(gradNou, monomNou);

        }
        rezultat.delZerocoef();

        return rezultat;
    }


}
