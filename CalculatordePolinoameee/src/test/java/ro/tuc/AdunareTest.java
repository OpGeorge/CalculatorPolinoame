package ro.tuc;

import org.junit.Test;
import ro.tuc.MathOperations.Operatii;
import ro.tuc.Model.Monom;
import ro.tuc.Model.Polinom;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
public class AdunareTest {
    @Test
    public void adunarePoltest()
    {
        // P1 = 4x^2+3x^1+5
        Monom m1 = new Monom(3.0,1);
        Monom m11= new Monom(4.0,2);
        Monom m12 = new Monom(5.0,0);
        Polinom p1 = new Polinom();
        p1.getPol().put(0,m12);
        p1.getPol().put(1,m1);
        p1.getPol().put(2,m11);

        //P2 = 1x^3+2x^1-6
        Polinom p2 = new Polinom();
        p2.getPol().put(1,new Monom(2.0,1));
        p2.getPol().put(0,new Monom(-6.0,0));
        p2.getPol().put(3,new Monom(1.0,3));

        //Rezultat = 1x^3+4x^2+5x^1-1
        Polinom rezultat = new Polinom();
        rezultat.getPol().put(3,new Monom(1.0,3));
        rezultat.getPol().put(2,new Monom(4.0,2));
        rezultat.getPol().put(1,new Monom(5.0,1));
        rezultat.getPol().put(0,new Monom(-1.0,0));

        assertEquals(rezultat, Operatii.addPol(p1,p2));
    }

    @Test
    public void testGresitadunare()
    {
        // P1 = 4x^2+3x^1+5
        Monom m1 = new Monom(3.0,1);
        Monom m11= new Monom(4.0,2);
        Monom m12 = new Monom(5.0,0);
        Polinom p1 = new Polinom();
        p1.getPol().put(0,m12);
        p1.getPol().put(1,m1);
        p1.getPol().put(2,m11);

        //P2 = 1x^3+2x^1-6
        Polinom p2 = new Polinom();
        p2.getPol().put(1,new Monom(2.0,1));
        p2.getPol().put(0,new Monom(-6.0,0));
        p2.getPol().put(3,new Monom(1.0,3));

        //Rezultat gresit = 1x^1+1
        Polinom rezultatGresit = new Polinom();
        rezultatGresit.getPol().put(1,new Monom(1.0,0));
        rezultatGresit.getPol().put(0,new Monom(1.0,0));
        assertEquals(rezultatGresit, Operatii.addPol(p1,p2));
    }

    @Test
    public void inmultirePoltest()
    {
        // P1 = 4x^2+3x^1+5
        Monom m1 = new Monom(3.0,1);
        Monom m11= new Monom(4.0,2);
        Monom m12 = new Monom(5.0,0);
        Polinom p1 = new Polinom();
        p1.getPol().put(0,m12);
        p1.getPol().put(1,m1);
        p1.getPol().put(2,m11);

        //P2 = 1x^3+2x^1-6
        Polinom p2 = new Polinom();
        p2.getPol().put(1,new Monom(2.0,1));
        p2.getPol().put(0,new Monom(-6.0,0));
        p2.getPol().put(3,new Monom(1.0,3));

        //Rezultat = +4.0x^5+3.0x^4+13.0x^3-18.0x^2-8.0x^1-30.0
        Polinom rezultat = new Polinom();
        rezultat.getPol().put(5,new Monom(4.0,5));
        rezultat.getPol().put(4,new Monom(3.0,4));
        rezultat.getPol().put(3,new Monom(13.0,3));
        rezultat.getPol().put(2,new Monom(-18.0,2));
        rezultat.getPol().put(1,new Monom(-8.0,1));
        rezultat.getPol().put(0,new Monom(-30.0,0));

        assertEquals(rezultat, Operatii.multiplyPol(p1,p2));
    }
    @Test
    public void testGresitinmultire()
    {
        // P1 = 4x^2+3x^1+5
        Monom m1 = new Monom(3.0,1);
        Monom m11= new Monom(4.0,2);
        Monom m12 = new Monom(5.0,0);
        Polinom p1 = new Polinom();
        p1.getPol().put(0,m12);
        p1.getPol().put(1,m1);
        p1.getPol().put(2,m11);

        //P2 = 1x^3+2x^1-6
        Polinom p2 = new Polinom();
        p2.getPol().put(1,new Monom(2.0,1));
        p2.getPol().put(0,new Monom(-6.0,0));
        p2.getPol().put(3,new Monom(1.0,3));

        //Rezultat gresit = 1x^1+1
        Polinom rezultatGresit = new Polinom();
        rezultatGresit.getPol().put(1,new Monom(1.0,0));
        rezultatGresit.getPol().put(0,new Monom(1.0,0));
        assertEquals(rezultatGresit, Operatii.multiplyPol(p1,p2));
    }

    @Test
    public void scaderePoltest()
    {
        // P1 = 4x^2+3x^1+5
        Monom m1 = new Monom(3.0,1);
        Monom m11= new Monom(4.0,2);
        Monom m12 = new Monom(5.0,0);
        Polinom p1 = new Polinom();
        p1.getPol().put(0,m12);
        p1.getPol().put(1,m1);
        p1.getPol().put(2,m11);

        //P2 = 1x^3+2x^1-6
        Polinom p2 = new Polinom();
        p2.getPol().put(1,new Monom(2.0,1));
        p2.getPol().put(0,new Monom(-6.0,0));
        p2.getPol().put(3,new Monom(1.0,3));

        //Rezultat = -1.0x^3+4.0x^2+1.0x^1+11.0
        Polinom rezultat = new Polinom();
        rezultat.getPol().put(3,new Monom(-1.0,3));
        rezultat.getPol().put(2,new Monom(4.0,2));
        rezultat.getPol().put(1,new Monom(1.0,1));
        rezultat.getPol().put(0,new Monom(11.0,0));
        assertEquals(rezultat, Operatii.subPol(p1,p2));

    }

    @Test
    public void testGresitscadere()
    {
        // P1 = 4x^2+3x^1+5
        Monom m1 = new Monom(3.0,1);
        Monom m11= new Monom(4.0,2);
        Monom m12 = new Monom(5.0,0);
        Polinom p1 = new Polinom();
        p1.getPol().put(0,m12);
        p1.getPol().put(1,m1);
        p1.getPol().put(2,m11);

        //P2 = 1x^3+2x^1-6
        Polinom p2 = new Polinom();
        p2.getPol().put(1,new Monom(2.0,1));
        p2.getPol().put(0,new Monom(-6.0,0));
        p2.getPol().put(3,new Monom(1.0,3));

        //Rezultat gresit = 1x^1+1
        Polinom rezultatGresit = new Polinom();
        rezultatGresit.getPol().put(1,new Monom(1.0,0));
        rezultatGresit.getPol().put(0,new Monom(1.0,0));
        assertEquals(rezultatGresit, Operatii.subPol(p1,p2));
    }

    @Test
    public void impartirePoltest()
    {
        // P1 = 4x^2+3x^1+5
        Monom m1 = new Monom(3.0,1);
        Monom m11= new Monom(4.0,2);
        Monom m12 = new Monom(5.0,0);
        Polinom p1 = new Polinom();
        p1.getPol().put(0,m12);
        p1.getPol().put(1,m1);
        p1.getPol().put(2,m11);

        //P2 = 1x^3+2x^1-6
        Polinom p2 = new Polinom();
        p2.getPol().put(1,new Monom(2.0,1));
        p2.getPol().put(0,new Monom(-6.0,0));
        p2.getPol().put(3,new Monom(1.0,3));

        //Rezultat =   | +4.0x^2+3.0x^1+5.0
        ArrayList<Polinom> rezultat = new ArrayList<>();
        Polinom cat = new Polinom();
        Polinom rest= new Polinom("4x^2+3x^1+5");
        rezultat.add(0,cat);
        rezultat.add(1,rest);

        assertEquals(rezultat, Operatii.dividePol(p1,p2));
    }

    @Test
    public void testGresitimpartire()
    {
        // P1 = 4x^2+3x^1+5
        Monom m1 = new Monom(3.0,1);
        Monom m11= new Monom(4.0,2);
        Monom m12 = new Monom(5.0,0);
        Polinom p1 = new Polinom();
        p1.getPol().put(0,m12);
        p1.getPol().put(1,m1);
        p1.getPol().put(2,m11);

        //P2 = 1x^3+2x^1-6
        Polinom p2 = new Polinom();
        p2.getPol().put(1,new Monom(2.0,1));
        p2.getPol().put(0,new Monom(-6.0,0));
        p2.getPol().put(3,new Monom(1.0,3));

        //RezultatGresit  =   | 1x^1+1
        ArrayList<Polinom> rezultat = new ArrayList<>();
        Polinom cat = new Polinom();
        Polinom rest= new Polinom("1x^1+1");
        rezultat.add(0,cat);
        rezultat.add(1,rest);

        assertEquals(rezultat, Operatii.dividePol(p1,p2));
    }

    @Test
    public void derivarePoltest()
    {
        // P1 = 4x^2+3x^1+5
        Monom m1 = new Monom(3.0,1);
        Monom m11= new Monom(4.0,2);
        Monom m12 = new Monom(5.0,0);
        Polinom p1 = new Polinom();
        p1.getPol().put(0,m12);
        p1.getPol().put(1,m1);
        p1.getPol().put(2,m11);

        //Rezultat =  +8.0x^1+0.0
        Polinom rezultat = new Polinom("8x^1+0");
        assertEquals(rezultat, Operatii.derivarePol(p1));
    }

    @Test
    public void testGresitderivare()
    {
        // P1 = 4x^2+3x^1+5
        Monom m1 = new Monom(3.0,1);
        Monom m11= new Monom(4.0,2);
        Monom m12 = new Monom(5.0,0);
        Polinom p1 = new Polinom();
        p1.getPol().put(0,m12);
        p1.getPol().put(1,m1);
        p1.getPol().put(2,m11);

        //Rezultat = 1x^1+1
        Polinom rezultat = new Polinom("1x^1+1");
        assertEquals(rezultat, Operatii.derivarePol(p1));
    }

    @Test
    public void integrarePoltest()
    {
        // P1 = 3x^2+2x^1+5
        Monom m11= new Monom(3.0,2);
        Monom m1 = new Monom(2.0,1);
        Monom m12 = new Monom(5.0,0);
        Polinom p1 = new Polinom();
        p1.getPol().put(0,m12);
        p1.getPol().put(1,m1);
        p1.getPol().put(2,m11);
        // Rezultat = +1.0x^3+1x^2+5.0x^1
        Polinom rezultat = new Polinom("1x^3+1x^2+5x^1");
        assertEquals(rezultat, Operatii.integrarePol(p1));

    }

    @Test
    public void testGresitIntegrare()
    {
        // P1 = 3x^2+2x^1+5
        Monom m11= new Monom(3.0,2);
        Monom m1 = new Monom(2.0,1);
        Monom m12 = new Monom(5.0,0);
        Polinom p1 = new Polinom();
        p1.getPol().put(0,m12);
        p1.getPol().put(1,m1);
        p1.getPol().put(2,m11);
        // Rezultat Gresit= 1x^1+1
        Polinom rezultat = new Polinom("1x^1+1");
        assertEquals(rezultat, Operatii.integrarePol(p1));
    }



}
