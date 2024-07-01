package ru.lisenkova.main;

import ru.lisenkova.geometry.Figure;
import ru.lisenkova.geometry.Lengthable;
import ru.lisenkova.math.Fraction;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;


public class Methods {
    private Methods(){};
    public static double sumArea(Figure... objects) //3.3.3
    {
        double res=0;
        if (objects.length==0) return 0;
        for(int i=0;i<objects.length; i++ )
            res+=objects[i].area();
        return res;
    }

    public static double sumLength(Lengthable[] objects) //3.3.5
    {
        double res=0;
        if (objects.length==0) return 0;
        for(int i=0;i<objects.length; i++ )
            res+=objects[i].length();
        return res;
    }

    public static int powXY(String x, String y) //4.1.4
    {
        int x0 = parseInt(x);
        int y0 = parseInt(y);
        return (int) pow(x0,y0);

    }

    public static String Multiply(String... adding) //4.1.3
    {
        List<Fraction> fractions = new ArrayList<>();          //массив дробей
        List<BigInteger>  bigIntegers = new ArrayList<>();     //массив очень больших числе
        Fraction res = new Fraction(0);                     //для суммы дробей
        BigInteger resBig = new BigInteger("0");           //для суммы очень больших чисел
        for (String part:adding)
        {
            if (part.indexOf('.')!=-1) {                                 //если double
                fractions.add(new Fraction(Double.parseDouble(part)));
                res = res.sum(fractions.getLast());
            }
            else if (part.indexOf('/')!=-1) {                           //если дробь
                int ind=part.indexOf('/');
                int numerator = Integer.parseInt(part.substring(0,ind));
                int denominator = Integer.parseInt(part.substring(ind+1,part.length()));
                fractions.add(new Fraction(numerator,denominator));
                res = res.sum(fractions.getLast());
            }
            else {
                bigIntegers.add(new BigInteger(part));
                resBig = resBig.add(bigIntegers.getLast());
            }


        }
        double result0 = (double) res.getX()/ res.getY();
       // if (!bigIntegers.isEmpty()) return ""+resBig.add(new BigInteger(""+(float)result0));
        result0+=resBig.doubleValue();
        return ""+result0;
    }
}
