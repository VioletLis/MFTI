package ru.lisenkova.main;

import ru.lisenkova.geometry.*;
import ru.lisenkova.math.Fraction;
import ru.lisenkova.tools.Box;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;
import static java.lang.Math.random;


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

    public static <T extends Point2D> void addStartX(Line<T> line) //5.2.1
    {
        line.getStart().setX((line.getStart().getX()+10));
    }

    public static double maxBox(Box<? extends Number> ... boxes)  //5.2.2
    {
        double res=(double)boxes[0].get();
        double tmp;
        for (int i=1; i<boxes.length; i++)
        {
            tmp = Double.parseDouble(String.valueOf(boxes[i].get()));
            if (res <= tmp)
                res = tmp;
        }
        return res;
    }

    public static void putPoint3D(Box<? super Point3D> box) //5.2.3
    {

        Random r = new Random();
        box.set(new Point3D(r.nextInt(20),r.nextInt(20),r.nextInt(20)));
    }

   // public static void setList(List<? super Integer> list)  //5.2.4
    public static <K extends Number> List<K> setList(List<K> list)
    {
        //List<K> list1 = new ArrayList<>();
        for (int i=0; i < 100; i++) list.add((K) Integer.valueOf(i+1));
        return list;
    }

    public static void putInList(List<? super Integer> list)  //5.2.4
    {
        //List<K> list1 = new ArrayList<>();
        for (int i=0; i < 100; i++) list.add((i+1));
    }

}
