package ru.lisenkova.math;

public class NewFraction implements Fractionable{
    private boolean isNew;
    private Fraction fract;
    private double value;
    public NewFraction(Fraction fraction)
    {
        this.fract = fraction;
        this.isNew = true;
    }
    @Override
    public double doubleValue()
    {
        if (this.isNew) {
            this.value = fract.doubleValue();
            this.isNew = false;
        }
        return this.value;
    }
    @Override
    public void setNum(int num) {
        this.fract.setNum(num);
        this.isNew = true;
    }

    @Override
    public void setDenum(int denum) {
        this.fract.setDenum(denum);
        isNew = true;
    }
}
