package ru.lisenkova.math;

import java.util.Objects;

public class Fraction implements Cloneable, Fractionable
{
    private int num, denum; // числитель, знаменатель

    public Fraction(int num, int denum) {
        checkDenum(denum);
        this.num=num;
        this.denum =denum;
    }
    public Fraction(int x){
        this.num = x;
        this.denum = 1;
    }
    public void setNum(int num)
    {
        this.num = num;
    }
    public void setDenum(int denum)
    {
        this.denum = denum;
    }

    @Override
    public double doubleValue()
    {
        System.out.println("invoke doubleValue");
        return (double) this.num /this.denum;
    }
    public Fraction(double z){
        String s = String.valueOf(z);
        int digitsDec = s.length() - 1 - s.indexOf('.');
        int denom = 1;
        for(int i = 0; i < digitsDec; i++){
            z *= 10;
            denom *= 10;
        }
        int num = (int) Math.round(z);
        int gdc=findGCD(num,denom);
        this.num = num/gdc;
        this.denum = denom/gdc;
    }
    public int getNum()
    {
        return this.num;
    }
    public  int getDenum()
    {
        return this.denum;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass()!= obj.getClass()) return false;
        Fraction a = (Fraction) obj;
        return ((this.num == a.num) && (this.denum == a.denum));
    }

    @Override
    public Fraction clone()  {
        try {
            Fraction res = (Fraction) super.clone();
            return res;
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, denum);
    }


    private static void checkDenum(int y) {
         if(y<=0)
             throw new IllegalArgumentException("denominator (y) must be positive");
     }

    private static Fraction simplifyD(Fraction A2) {
        int gcd=findGCD(A2.num,A2.denum);
        A2.num=A2.num/gcd;
        A2.denum =A2.denum /gcd;
        return A2;
    }
    private static int findGCD(int num1, int num2)
    {
        if (num2 == 0)
            return num1;
        return findGCD(num2, num1 % num2);

    }
    @Override
    public String toString() {
        return this.num + "/" + this.denum;
    }

    public Fraction sum(Fraction A2) {
        Fraction A1 = new Fraction(this.num, this.denum);
        Fraction summa = new Fraction(this.num * A2.denum + A2.num * this.denum, this.denum *A2.denum);
        simplifyD(summa);
        return summa;
    }

    public Fraction sum(int z) {
        Fraction A1 = new Fraction(this.num, this.denum);
        Fraction summa = new Fraction(this.num  + z * this.denum, this.denum);
        return summa;
    }

    public Fraction minus(Fraction A2) {
        Fraction minus = new Fraction(this.num * A2.denum - A2.num * this.denum, this.denum *A2.denum);
        simplifyD(minus);
        return minus;
    }

    public Fraction minus(int z) {
        Fraction minus = new Fraction(this.num  - z * this.denum, this.denum);
        simplifyD(minus);
        return minus;
    }

    public Fraction multiply(Fraction A2) {
        Fraction multyD = new Fraction((this.num * A2.num), this.denum *A2.denum);
        simplifyD(multyD);
        return multyD;
    }

    public Fraction multiply(int z) {
        Fraction multyD = new Fraction((this.num * z), this.denum);
        simplifyD(multyD);
        return multyD;
    }

    public Fraction div(Fraction A2) {
        int t1 = this.num * A2.denum;
        int t2 = this.denum * A2.num;
        if (t2<0)
        {
            t1 *= -1;
            t2 *= -1;
        }
        else if (t2==0)
            throw new ArithmeticException("Divide by 0");
        Fraction multyD = new Fraction(t1, t2);
        simplifyD(multyD);
        return multyD;
    }

    public Fraction div(int z) {
        int t1=this.num;
        int t2=this.denum *z;
        if (z==0)
            throw new ArithmeticException("Divide by 0");
        else if (z<0)
        {
            t1*=-1;
            t2*=-1;
        }
        Fraction multyD = new Fraction(t1, t2);
        simplifyD(multyD);
        return multyD;
    }
}
