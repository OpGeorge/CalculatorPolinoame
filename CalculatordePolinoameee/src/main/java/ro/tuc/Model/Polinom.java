package ro.tuc.Model;

import java.util.Objects;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {

    private static final String REGEX = "(([-+]?\\d*)?x(\\^\\d+)?|([-+]?\\d+))";
    private static final String REGEX_VERIFY = "-?(\\d*x(\\^\\d+)?|(\\d+))([-+](\\d*x(\\^\\d+)?|\\d+))*";
    private static final Pattern REGEX_PATTERN = Pattern.compile(REGEX);


    private TreeMap<Integer, Monom> pol;


    public Polinom() // instantiere default
    {
        this.pol = new TreeMap<>();
    }


    public Polinom(Polinom Pol2)// copiere polinom
    {
        this.pol = new TreeMap<>();
        for (Monom monom : Pol2.pol.values()) {
            pol.put(monom.getGrad(), new Monom(monom.getCoef(), monom.getGrad()));
        }
    }

    public Polinom(String op)// magie regex
    {
        if (!Pattern.matches(REGEX_VERIFY, op)) {
            throw new IllegalArgumentException("Input invalid");
        }
        this.pol = new TreeMap<>();
        Matcher matcher = REGEX_PATTERN.matcher(op);
        while (matcher.find()) {
                if (matcher.group(4) == null) {
                    Double coef;
                    Integer grad;
                    if (matcher.group(2) != null) {
                        if (matcher.group(2).length() == 1) {
                            if (Objects.equals(matcher.group(2), "-"))
                                coef = -1.0;
                            else {
                                coef = Double.parseDouble(matcher.group(2));
                            }
                        } else {
                            coef = Double.parseDouble(matcher.group(2));
                        }
                    } else {
                        coef = 1.0;
                    }
                    if (matcher.group(3) != null) {
                        String gradul = matcher.group(3).split("\\^")[1];
                        grad = Integer.parseInt(gradul);
                    } else {
                        grad = 1;
                    }
                    Monom m = new Monom(coef, grad);
                    pol.put(m.getGrad(), m);

                } else {
                    Double coef;
                    coef = Double.parseDouble(matcher.group(4));
                    Integer grad = 0;
                    Monom m = new Monom(coef, grad);
                    pol.put(m.getGrad(), m);
                }
        }
    }

    public TreeMap<Integer, Monom> getPol() {
        return pol;
    }


    public Integer maxDegree() {

        Integer max = 0;
        for (Monom m : pol.descendingMap().values()) {
            max = m.getGrad();
            break;
        }
        return max;

    }

    public void delZerocoef() {

        for (Monom m : pol.values()) {
            if (m.getCoef().equals(0.0)) {
                pol.remove(m.getGrad());
            }
        }
    }

    public void addMonom(Monom m1) {

        if (pol.get(m1.getGrad()) != null) {
            if (pol.get(m1.getGrad()).getCoef() + m1.getCoef() != 0.0)
                pol.get(m1.getGrad()).setCoef(pol.get(m1.getGrad()).getCoef() + m1.getCoef());
            else {
                pol.remove(m1.getGrad());
            }
        } else {
            pol.putIfAbsent(m1.getGrad(), m1);
        }

    }

    public void subMonom(Monom m1) {


        if (pol.get(m1.getGrad()) != null) {
            if (pol.get(m1.getGrad()).getCoef() - m1.getCoef() != 0.0)
                pol.get(m1.getGrad()).setCoef(pol.get(m1.getGrad()).getCoef() - m1.getCoef());
            else {
                pol.remove(m1.getGrad());
            }
        } else {
            Monom secundar = new Monom();
            secundar.setCoef(-1.0 * m1.getCoef());
            secundar.setGrad(m1.getGrad());
            pol.putIfAbsent(secundar.getGrad(), secundar);

        }

    }

    public Polinom multiplyMonom(Monom m1) {
        Monom rezInt;
        Polinom Rezultat = new Polinom();
        for (Monom m : pol.values()) {
            rezInt = new Monom();
            rezInt.setCoef(m.getCoef() * m1.getCoef());
            rezInt.setGrad(m.getGrad() + m1.getGrad());
            Rezultat.pol.put(rezInt.getGrad(), rezInt);
        }
        return Rezultat;

    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Monom m : pol.descendingMap().values()) {
            text.append(m.toString());
        }
        return text.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polinom polinom = (Polinom) o;
        return Objects.equals(pol, polinom.pol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pol);
    }
}
