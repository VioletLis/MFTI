public class Fraction
{
    private int x, y; // числитель, знаменатель


    Fraction(int x, int y)
    {
        checkY(y);
        this.x=x;
        this.y=y;
    }
     private static void checkY(int y)
     {
         if(y<=0)
             throw new IllegalArgumentException("denominator (y) must be positive");
     }

    private static Fraction SimplifyD(Fraction A2)
    {
        return A2;
    }
    public String getF()
    {
        return this.x + "/" + this.y;
    }

    public Fraction sum(Fraction A2)
    {
        Fraction A1 = new Fraction(this.x, this.y);
        // (A1.x * A2.y + A2.x * A1.y) / (A1.y*A2.y);
        Fraction summa = new Fraction(this.x * A2.y + A2.x * this.y, this.y*A2.y);
        return summa;
    }
    public Fraction sum(int z)
    {
        Fraction A1 = new Fraction(this.x, this.y);
        // (A1.x * A2.y + A2.x * A1.y) / (A1.y*A2.y);
        Fraction summa = new Fraction(this.x  + z * this.y, this.y);
        return summa;
    }
    public Fraction minus(Fraction A2)
    {
        // (A1.x * A2.y - A2.x * A1.y) / (A1.y*A2.y);
        Fraction minus = new Fraction(this.x * A2.y - A2.x * this.y, this.y*A2.y);
        return minus;
    }

    public Fraction minus(int z)
    {
        // (A1.x * A2.y - A2.x * A1.y) / (A1.y*A2.y);
        Fraction minus = new Fraction(this.x  - z * this.y, this.y);
        return minus;
    }
    public Fraction multiply(Fraction A2)
    {
        // (A1.x * A2.x ) / (A1.y*A2.y);
        Fraction multyD = new Fraction((this.x * A2.x), this.y*A2.y);
        return multyD;
    }
    public Fraction multiply(int z)
    {
        // (A1.x * A2.x ) / (A1.y*A2.y);
        Fraction multyD = new Fraction((this.x * z), this.y);
        return multyD;
    }
    public Fraction div(Fraction A2)
    {
        // (A1.x * A2.x ) / (A1.y*A2.y);
        int t1=this.x * A2.y;
        int t2=this.y*A2.x;
        if (t2<0)
        {
            t1 *= -1;
            t2 *= -1;
        }
        else if (t2==0)
            throw new ArithmeticException("Divide by 0");
        Fraction multyD = new Fraction(t1, t2);
        return multyD;
    }
    public Fraction div(int z)
    {
        // (A1.x * A2.x ) / (A1.y*A2.y);
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

        return multyD;
    }
}
