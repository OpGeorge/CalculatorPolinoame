package ro.tuc.Model;

import java.util.Objects;

public class Monom {

    private Double coef;
    private Integer grad;

    public Monom()
    {
        this.grad = 0;
        this.coef = 0.0;

    }

    public Monom(Double coef, Integer grad) {
        this.coef = coef;
        this.grad = grad;
    }

    public void setCoef(Double coef) {
        this.coef = coef;
    }

    public void setGrad(Integer grad) {
        this.grad = grad;
    }

    public Double getCoef()
    {
        return this.coef;
    }
    public Integer getGrad()
    {
        return this.grad;
    }


    @Override
    public String toString() {
        return
                (coef>=0?("+"+coef):coef.toString()) + ((grad>0)? "x^"+grad:grad==1?"x":"");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monom monom = (Monom) o;
        return Objects.equals(coef, monom.coef) && Objects.equals(grad, monom.grad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coef, grad);
    }
}
