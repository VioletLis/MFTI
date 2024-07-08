package ru.lisenkova.math;

import ru.lisenkova.geometry.Point;

import java.util.Objects;

public class Fraction implements Cloneable
{
    private int x, y; // числитель, знаменатель

    public Fraction(int x, int y) {
        checkY(y);
        this.x=x;
        this.y=y;
    }
    public Fraction(int x){
        this.x = x;
        this.y = 1;
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
        this.x = num/gdc;
        this.y = denom/gdc;
    }
    public int getX()
    {
        return this.x;
    }
    public  int getY()
    {
        return this.y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass()!= obj.getClass()) return false;
        Fraction a = (Fraction) obj;
        return ((this.x == a.x) && (this.y == a.y));
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
        return Objects.hash(x, y);
    }


    private static void checkY(int y) {
         if(y<=0)
             throw new IllegalArgumentException("denominator (y) must be positive");
     }

    private static Fraction simplifyD(Fraction A2) {
        int gcd=findGCD(A2.x,A2.y);
        A2.x=A2.x/gcd;
        A2.y=A2.y/gcd;
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
        return this.x + "/" + this.y;
    }

    public Fraction sum(Fraction A2) {
        Fraction A1 = new Fraction(this.x, this.y);
        // (A1.x * A2.y + A2.x * A1.y) / (A1.y*A2.y);
        Fraction summa = new Fraction(this.x * A2.y + A2.x * this.y, this.y*A2.y);
        simplifyD(summa);
        return summa;
    }

    public Fraction sum(int z) {
        Fraction A1 = new Fraction(this.x, this.y);
        // (A1.x * A2.y + A2.x * A1.y) / (A1.y*A2.y);
        Fraction summa = new Fraction(this.x  + z * this.y, this.y);
        return summa;
    }

    public Fraction minus(Fraction A2) {
        // (A1.x * A2.y - A2.x * A1.y) / (A1.y*A2.y);
        Fraction minus = new Fraction(this.x * A2.y - A2.x * this.y, this.y*A2.y);
        simplifyD(minus);
        return minus;
    }

    public Fraction minus(int z) {
        // (A1.x * A2.y - A2.x * A1.y) / (A1.y*A2.y);
        Fraction minus = new Fraction(this.x  - z * this.y, this.y);
        simplifyD(minus);
        return minus;
    }

    public Fraction multiply(Fraction A2) {
        // (A1.x * A2.x ) / (A1.y*A2.y);
        Fraction multyD = new Fraction((this.x * A2.x), this.y*A2.y);
        simplifyD(multyD);
        return multyD;
    }

    public Fraction multiply(int z) {
        // (A1.x * A2.x ) / (A1.y*A2.y);
        Fraction multyD = new Fraction((this.x * z), this.y);
        simplifyD(multyD);
        return multyD;
    }

    public Fraction div(Fraction A2) {
        // (A1.x * A2.x ) / (A1.y*A2.y);
        int t1 = this.x * A2.y;
        int t2 = this.y * A2.x;
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
        // (A1.x * A2.x ) / (A1.y * A2.y);
        int t1=this.x;
        int t2=this.y*z;
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
