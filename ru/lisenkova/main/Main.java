package ru.lisenkova.main;
import ru.lisenkova.geometry.*;
import ru.lisenkova.geometry.Point;
import ru.lisenkova.math.Fraction;

import static java.lang.System.out;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {

        Figure circle1 = new Circle(new Point(1,1), 1);
        Figure circle2 = new Circle(new Point(0,0),1);
        Figure square1 = new Square(new Point(2,1),1);
        Figure square2 = new Square(new Point(3,0),1);
        out.println(Methods.sumArea(new Figure[]{circle1, circle2, square1, square2})); //в этом частном случае PI+PI+1+1 =~8.28 //4.1.2

        Line line1 = new Line(new Point(1,1), new Point(1,0));
        Line line2 = new Line(new Point(1,1), new Point(0,1));
        PolyLine line3 = new PolyLine(List.of(new Point(0,0), new Point(1,0), new Point(1,4)));
        out.println(Methods.sumLength(new Lengthable[]{line1,line2,line3})); //в этом частном случае 1+1+1+4=7 //4.1.2

        out.println(Methods.powXY("5","2")); //4.1.4

        Point point1 = new Point(3,5);       //4.1.5
        java.awt.Point point2 = new java.awt.Point(4,3);
        out.println(point1);
        out.println(point2);

        out.println(Methods.Multiply("7", "11/3","3.21", "12345678912345678912"));

    }

}
